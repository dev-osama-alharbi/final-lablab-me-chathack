package com.team.chathack.service;

import com.team.chathack.dto.response.ApiResponse;
import com.team.chathack.dto.tags.ComponentDTO;
import com.team.chathack.dto.tags.ItemDTO;
import com.team.chathack.dto.tags.NewTagDTO;
import com.team.chathack.dto.tags.TagDTO;
import com.team.chathack.entity.Component;
import com.team.chathack.entity.Item;
import com.team.chathack.entity.Msg;
import com.team.chathack.repo.ComponentRepo;
import com.team.chathack.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class TagService {
    private final ComponentRepo componentRepo;
    private final ItemRepo itemRepo;
    private final MsgService msgService;
    private final TableIdsService tableIdsService;
    private final ChatListenerWsService chatListenerWsService;

    //TODO getAll
    //TODO addTag

    public boolean addTag(long projectId, NewTagDTO tagDTO){
        if(!isAvailableForTag(projectId,tagDTO)){
            return false;
        }
        Msg msg = msgService.getMsgById(tagDTO.getMsgId());
        if(msg == null){
            return false;
        }
        if(tagDTO.isTypeDb()){
            if (tagDTO.isStatusNew()){
                Component component = Component
                        .builder()
                        .id(tableIdsService.newComponentId())
                        .projectId(projectId)
                        .componentType(Component.ComponentType.DB)
                        .msg(msg.getMsg())
                        .msgId(tagDTO.getMsgId())
                        .title(tagDTO.getTitle())
                        .build();
                componentRepo.save(component);

                ApiResponse<ComponentDTO> body = ApiResponse
                        .<ComponentDTO>builder()
                        .type(ApiResponse.ApiResponseType.TAG_ADDED_COMPONENT)
                        .hasErrors(false)
                        .httpCode(HttpStatus.OK.value())
                        .body(ComponentDTO
                                .builder()
                                .id(component.getId())
                                .msgId(component.getMsgId())
                                .projectId(component.getProjectId())
                                .msg(component.getMsg())
                                .title(component.getTitle())
                                .componentType(component.getComponentType().toString())
                                .build())
                        .build();
                chatListenerWsService.addNewTagComponent(projectId,body);

            }else{
                Component component = getComponentId(tagDTO.getParentComponentId());
                if(component == null
                        || component.getComponentType() != Component.ComponentType.DB
                        || component.getProjectId() != projectId){
                    return false;
                }else{
                    Item item = Item
                            .builder()
                            .id(tableIdsService.newItemId())
                            .msg(msg.getMsg())
                            .componentId(component.getId())
                            .msgId(tagDTO.getMsgId())
                            .projectId(projectId)
                            .build();
                    Item newItem = itemRepo.save(item);

                    ApiResponse<ItemDTO> body = ApiResponse
                            .<ItemDTO>builder()
                            .type(ApiResponse.ApiResponseType.TAG_ADDED_ITEM)
                            .hasErrors(false)
                            .httpCode(HttpStatus.OK.value())
                            .body(ItemDTO
                                    .builder()
                                    .id(newItem.getId())
                                    .msgId(newItem.getMsgId())
                                    .projectId(newItem.getProjectId())
                                    .msg(newItem.getMsg())
                                    .componentId(newItem.getComponentId())
                                    .build())
                            .build();
                    chatListenerWsService.addNewTagItem(projectId,body);
                }
            }
        }else{
            //Description
            ArrayList<Component> componentList = getComponentByProjectIdAndMsgId(projectId);
            Component component = null;
            for (Component component1 : componentList) {
                if(component1 != null){
                    if(component1.getComponentType().toString().equals("DES")){
                        component = component1;
                    }
                }
            }
            if(component == null){
                component = Component
                        .builder()
                        .id(tableIdsService.newComponentId())
                        .projectId(projectId)
                        .componentType(Component.ComponentType.DES)
                        .msg(msg.getMsg())
                        .msgId(tagDTO.getMsgId())
                        .title(tagDTO.getTitle())
                        .build();
                componentRepo.save(component);

                ApiResponse<ComponentDTO> body = ApiResponse
                        .<ComponentDTO>builder()
                        .type(ApiResponse.ApiResponseType.TAG_ADDED_COMPONENT)
                        .hasErrors(false)
                        .httpCode(HttpStatus.OK.value())
                        .body(ComponentDTO
                                .builder()
                                .id(component.getId())
                                .msgId(component.getMsgId())
                                .projectId(component.getProjectId())
                                .msg(component.getMsg())
                                .title(component.getTitle())
                                .componentType(component.getComponentType().toString())
                                .build())
                        .build();
                chatListenerWsService.addNewTagComponent(projectId,body);
            }else{
                if (component.getMsgId() == tagDTO.getMsgId()){
                    return false;
                }
                ArrayList<Item> items = getItemByProjectIdAndMsgId(msg.getProjectId(),tagDTO.getMsgId());
                if(items.size() >= 1){
                    return false;
                }
                for (Item item : items) {
                    Component componentItem = getComponentId(item.getComponentId());
                    if(componentItem.getComponentType().toString().equals("DES")){
                        return false;
                    }
                }
                Item item = Item
                        .builder()
                        .id(tableIdsService.newItemId())
                        .msg(msg.getMsg())
                        .componentId(component.getId())
                        .msgId(tagDTO.getMsgId())
                        .projectId(projectId)
                        .build();
                Item newItem = itemRepo.save(item);

                ApiResponse<ItemDTO> body = ApiResponse
                        .<ItemDTO>builder()
                        .type(ApiResponse.ApiResponseType.TAG_ADDED_ITEM)
                        .hasErrors(false)
                        .httpCode(HttpStatus.OK.value())
                        .body(ItemDTO
                                .builder()
                                .id(newItem.getId())
                                .msgId(newItem.getMsgId())
                                .projectId(newItem.getProjectId())
                                .msg(newItem.getMsg())
                                .componentId(newItem.getComponentId())
                                .build())
                        .build();
                chatListenerWsService.addNewTagItem(projectId,body);
            }
        }
        return true;
    }

    private boolean isAvailableForTag(long projectId, NewTagDTO tagDTO) {
        boolean flag = false;
        if(tagDTO.isTypeDb()){
            if(tagDTO.isStatusNew()){
                ArrayList<Component> componentArrayList = getComponentByProjectIdAndMsgId(projectId,tagDTO.getMsgId());
                for (Component component : componentArrayList) {
                    if(component.getComponentType().toString().equals("DB")){
                        return false;
                    }
                }
                return true;
            }else{
                Iterable<Item> arr = itemRepo.findAllByProjectIdAndMsgId(projectId,tagDTO.getMsgId());
//                ArrayList<Item> lst = new ArrayList<>();
                boolean flagIsHasDb = false;
                for (Item item : arr) {
                    if(item != null){
                        if(getComponentId(item.getComponentId()).getComponentType().equals("DB")){
                            flagIsHasDb = true;
                        }
//                        lst.add(item);
                    }
                }

                if(flagIsHasDb){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return true;
    }

    private Component getComponentProjectId(long projectId){
        return componentRepo.findByProjectId(projectId).orElse(null);
    }

    private Component getDesComponentProjectId(long projectId){
        return componentRepo.findByProjectIdAndComponentType(projectId, Component.ComponentType.DES.toString()).orElse(null);
    }

//    private List<Component> getComponentByMsgId(long projectId){
//        return componentRepo.findByProjectIdAndComponentType(projectId, Component.ComponentType.DES.toString()).orElse(null);
//    }

    private ArrayList<Component> getComponentByProjectIdAndMsgId(long projectId) {
        Iterable<Component> iterable = componentRepo.findAllByProjectId(projectId);
        ArrayList<Component> lst = new ArrayList<>();
        iterable.forEach(item -> {
            if(item != null){
                lst.add(item);
            }
        });
        return lst;
    }

    private ArrayList<Component> getComponentByProjectIdAndMsgId(long projectId,long msgId) {
        Iterable<Component> iterable = componentRepo.findAllByProjectIdAndMsgId(projectId,msgId);
        ArrayList<Component> lst = new ArrayList<>();
        iterable.forEach(item -> {
            if(item != null){
                lst.add(item);
            }
        });
        return lst;
    }

    private ArrayList<Item> getItemByProjectIdAndMsgId(long projectId,long msgId) {
        Iterable<Item> iterable = itemRepo.findAllByProjectIdAndMsgId(projectId,msgId);
        ArrayList<Item> lst = new ArrayList<>();
        iterable.forEach(item -> {
            if(item != null){
                lst.add(item);
            }
        });
        return lst;
    }

    private Component getComponentId(long componentId){
        return componentRepo.findById(componentId).orElse(null);
    }

    public List<TagDTO> getAll(long projectId) {
        ArrayList<Component> componentList = getAllComponentByProjectId(projectId);
        ArrayList<Item> itemList = getAllItemByProjectId(projectId);
        HashMap<Long,List<Item>> itemMap = new HashMap<>();
        HashMap<Long,Component> componentMap = new HashMap<>();

        componentList.forEach(component -> {
            itemMap.put(component.getId(),new ArrayList<>());
            componentMap.put(component.getId(),component);
        });

        itemList.forEach(item -> {
            if(itemMap.containsKey(item.getComponentId())){
                itemMap.get(item.getComponentId()).add(item);
            }
        });

        ArrayList<TagDTO> result = new ArrayList<>();
        itemMap.forEach((componentId, items) -> {
            ArrayList<ItemDTO> itemsDTO = new ArrayList<>();
            items.forEach(item -> {
                itemsDTO.add(ItemDTO
                        .builder()
                        .id(item.getId())
                        .componentId(item.getComponentId())
                        .msgId(item.getMsgId())
                        .msg(item.getMsg())
                        .projectId(item.getProjectId())
                        .build());
            });
            Component component = componentMap.get(componentId);
            TagDTO tagDTO = TagDTO
                    .builder()
                    .id(component.getId())
                    .msgId(component.getMsgId())
                    .projectId(component.getProjectId())
                    .msg(component.getMsg())
                    .componentType(component.getComponentType().toString())
                    .title(component.getTitle())
                    .items(itemsDTO)
                    .build();
            result.add(tagDTO);
        });
        return result;
    }

    private ArrayList<Component> getAllComponentByProjectId(long projectId) {
        Iterable<Component> iterable = componentRepo.findAllByProjectId(projectId);
        ArrayList<Component> lst = new ArrayList<>();
        iterable.forEach(component -> {
            if(component != null){
                lst.add(component);
            }
        });
        return lst;
    }

    private ArrayList<Item> getAllItemByProjectId(long projectId) {
        Iterable<Item> iterable = itemRepo.findAllByProjectId(projectId);
        ArrayList<Item> lst = new ArrayList<>();
        iterable.forEach(item -> {
            if(item != null){
                lst.add(item);
            }
        });
        return lst;
    }
}
