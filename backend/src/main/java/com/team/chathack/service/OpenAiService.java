package com.team.chathack.service;

import com.team.chathack.entity.Component;
import com.team.chathack.entity.Item;
import com.team.chathack.feign.OpenAiMethods;
import com.team.chathack.feign.model.*;
import com.team.chathack.repo.ComponentRepo;
import com.team.chathack.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final OpenAiMethods openAi;
    private final ComponentRepo componentRepo;
    private final ItemRepo itemRepo;
//    @Value("${openai.OPENAI_API_KEY}")
    private String OPENAI_API_KEY = "";

    public OpenAiResponse callDes(long projectId){
        HashMap<Component,ArrayList<Item>> map = convertToMap(getComponentByProjectId(projectId),getAllItemByProjectId(projectId));

        ArrayList<Role> roleArrayList = new ArrayList<>();
        map.forEach((component, itemArrayList) -> {
            switch (component.getComponentType()){
                case DES -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(component.getMsg()+"\n\r");
                    sb.append(component.getTitle()+"\n\r");
                    itemArrayList.forEach(item -> {
                        sb.append(item.getMsg()+"\n\r");
                    });
                    RoleUser roleUser = new RoleUser();
                    roleUser.setContent(sb.toString());
                    roleArrayList.add(roleUser);
                }
            }
        });

        RoleSystem roleSystem = new RoleSystem();
        roleSystem.setContent("""
                You are an Writer.
                Don't say anything else. Respond only with the Description of what you have.
                """);
        roleArrayList.add(roleSystem);

        OpenAiRequest openAiRequest = new OpenAiRequest();
        openAiRequest.setModel(ModelType.GPT_3_5_TURBO_0613.toString());
        openAiRequest.setMax_tokens(300);
        openAiRequest.setMessages(roleArrayList);
        OpenAiResponse result = openAi.call("Bearer "+OPENAI_API_KEY,openAiRequest);
        return result;
    }

    public OpenAiResponse callSQL(long projectId){
        HashMap<Component,ArrayList<Item>> map = convertToMap(getComponentByProjectId(projectId),getAllItemByProjectId(projectId));

        ArrayList<Role> roleArrayList = new ArrayList<>();
        map.forEach((component, itemArrayList) -> {
            switch (component.getComponentType()){
                case DB -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(component.getMsg()+"\n");
                    sb.append(component.getTitle()+"\n");
                    itemArrayList.forEach(item -> {
                        sb.append(item.getMsg()+"\n");
                    });
                    RoleUser roleUser = new RoleUser();
                    roleUser.setContent(sb.toString());
                    roleArrayList.add(roleUser);
                }
            }
        });

        RoleSystem roleSystem = new RoleSystem();
        roleSystem.setContent("""
                You are an API server that responds in a SQL format with foreign key.
                Don't say anything else. Respond only with the SQL for all role user.
                """);
        roleArrayList.add(roleSystem);

        OpenAiRequest openAiRequest = new OpenAiRequest();
        openAiRequest.setModel(ModelType.GPT_3_5_TURBO_0613.toString());
        openAiRequest.setMax_tokens(1000);
        openAiRequest.setMessages(roleArrayList);
        OpenAiResponse result = openAi.call("Bearer "+OPENAI_API_KEY,openAiRequest);
        return result;
    }

    public OpenAiResponse callJava(long projectId){
        HashMap<Component,ArrayList<Item>> map = convertToMap(getComponentByProjectId(projectId),getAllItemByProjectId(projectId));

        ArrayList<Role> roleArrayList = new ArrayList<>();
        map.forEach((component, itemArrayList) -> {
            switch (component.getComponentType()){
                case DB -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(component.getMsg()+"\n");
                    sb.append(component.getTitle()+"\n");
                    itemArrayList.forEach(item -> {
                        sb.append(item.getMsg()+"\n");
                    });
                    RoleUser roleUser = new RoleUser();
                    roleUser.setContent(sb.toString());
                    roleArrayList.add(roleUser);
                }
            }
        });

        RoleSystem roleSystem = new RoleSystem();
        roleSystem.setContent("""
                You are an API server that responds in a Java Spring Boot format.
                Don't say anything else. Respond only with Java Spring Boot.
                convert database description to java Spring boot.
                get the entity, repo, service.
                """);
        roleArrayList.add(roleSystem);

        OpenAiRequest openAiRequest = new OpenAiRequest();
        openAiRequest.setModel(ModelType.GPT_3_5_TURBO_0613.toString());
        openAiRequest.setMax_tokens(1000);
        openAiRequest.setMessages(roleArrayList);
        OpenAiResponse result = openAi.call("Bearer "+OPENAI_API_KEY,openAiRequest);
        return result;
    }

    public OpenAiResponse callJson(long projectId){
        HashMap<Component,ArrayList<Item>> map = convertToMap(getComponentByProjectId(projectId),getAllItemByProjectId(projectId));

        ArrayList<Role> roleArrayList = new ArrayList<>();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Component, ArrayList<Item>> ent:map.entrySet()) {
            counter++;
            switch (ent.getKey().getComponentType()){
                case DB -> {
                    sb.append("# start database number "+counter+"\n");
                    sb.append("this is database about "+ent.getKey().getTitle()+"\n");
//                    sb.append("the scheme describe in line by line"+"\n");
                    sb.append(ent.getKey().getMsg()+"\n");
                    ent.getValue().forEach(item -> {
                        sb.append(item.getMsg()+"\n");
                    });
                    sb.append("# end database number "+counter+"\n");
                }
            }
        }
        RoleUser roleUser = new RoleUser();
        roleUser.setContent(sb.toString());
        roleArrayList.add(roleUser);

        RoleSystem roleSystem = new RoleSystem();
        roleSystem.setContent("""
                You are an API server that responds in a Json format.
                Don't say anything else. Respond only with Json format.
                convert database description to json.
                """);
        roleArrayList.add(roleSystem);

        OpenAiRequest openAiRequest = new OpenAiRequest();
        openAiRequest.setModel(ModelType.GPT_3_5_TURBO_0613.toString());
        openAiRequest.setMax_tokens(1000);
        openAiRequest.setMessages(roleArrayList);
        OpenAiResponse result = openAi.call("Bearer "+OPENAI_API_KEY,openAiRequest);
        return result;
    }

    public OpenAiResponse callCpp(long projectId){
        HashMap<Component,ArrayList<Item>> map = convertToMap(getComponentByProjectId(projectId),getAllItemByProjectId(projectId));

        ArrayList<Role> roleArrayList = new ArrayList<>();
        map.forEach((component, itemArrayList) -> {
            switch (component.getComponentType()){
                case DB -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(component.getMsg()+"\n");
                    sb.append(component.getTitle()+"\n");
                    itemArrayList.forEach(item -> {
                        sb.append(item.getMsg()+"\n");
                    });
                    RoleUser roleUser = new RoleUser();
                    roleUser.setContent(sb.toString());
                    roleArrayList.add(roleUser);
                }
            }
        });

        RoleSystem roleSystem = new RoleSystem();
        roleSystem.setContent("""
                You are an API server that responds in a cpp format.
                Don't say anything else. Respond only with cpp.
                convert database description to java Spring boot.
                """);
        roleArrayList.add(roleSystem);

        OpenAiRequest openAiRequest = new OpenAiRequest();
        openAiRequest.setModel(ModelType.GPT_3_5_TURBO_0613.toString());
        openAiRequest.setMax_tokens(1000);
        openAiRequest.setMessages(roleArrayList);
        OpenAiResponse result = openAi.call("Bearer "+OPENAI_API_KEY,openAiRequest);
        return result;
    }




    private HashMap<Component,ArrayList<Item>> convertToMap(ArrayList<Component> componentArrayList, ArrayList<Item> itemArrayList) {
        HashMap<Long,Component> componentMap = new HashMap<>();
        HashMap<Component,ArrayList<Item>> result = new HashMap<>();
        componentArrayList.forEach(component -> {
            componentMap.put(component.getId(),component);
        });
        itemArrayList.forEach(item -> {
                if(!result.containsKey(componentMap.get(item.getComponentId()))){
                    result.put(componentMap.get(item.getComponentId()),new ArrayList<>());
                }
                result.get(componentMap.get(item.getComponentId())).add(item);
        });
        return result;
    }
    private ArrayList<Component> getComponentByProjectId(long projectId) {
        Iterable<Component> iterable = componentRepo.findAllByProjectId(projectId);
        ArrayList<Component> lst = new ArrayList<>();
        iterable.forEach(item -> {
            if(item != null){
                lst.add(item);
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
