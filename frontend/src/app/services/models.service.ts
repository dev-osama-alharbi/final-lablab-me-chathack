import { Injectable } from '@angular/core';
import {MsgDTO} from "../dto/msg.dto";
import {ComponentM, ComponentDTO, Item, Tag} from "../dto/tag.dto";

@Injectable({
  providedIn: 'root'
})
export class ModelsService {
  listMsg: Array<MsgDTO> = [];
  /*
  addMsg
  getMsg
  getAllMsg
   */

  // listComponent: Array<Component> = [];
  // listItem: Array<Item> = [];
  public listComponent: Map<number,ComponentM> = new Map<number, ComponentM>();
  /*
  addComponent
  getComponentById
  getAllComponent
   */
  public listItem: Map<number,Item> = new Map<number, Item>();
  public listTag: Map<number,Tag[]> = new Map<number, Tag[]>();
  public listTagByComponentId: Map<number,Tag[]> = new Map<number, Tag[]>();
  // public listComponent: Map<number,Component[]> = new Map<number, Component[]>();
  // public listItem: Map<number,ItemDTO[]> = new Map<number, ItemDTO[]>();

  constructor() { }
  addMsg(msg: MsgDTO){
    this.listMsg.push(msg);
  }

  addAllMsg(allMsg: MsgDTO[]) {
    this.listMsg = [];
    allMsg.forEach(value => {
      this.listMsg.push(value);
    });
  }

  addAllTag(components: ComponentM[]) {
    this.listComponent.clear();
    this.listItem.clear();
    this.listTag.clear();
    this.listTagByComponentId.clear();

    components.forEach(component => {
      if(!this.listComponent.has(component.id)){
        this.listComponent.set(component.id,component);
        const tag = new Tag();
        tag.isComponent = true;
        tag.msgId = component.msgId;
        tag.item = undefined;
        tag.component = component;
        if(tag.component.componentType.endsWith("DB")){
          tag.title = component.title;
        }else{
          tag.title = "Description";
        }
        this.addToTag(tag);
      }
      component.items.forEach(item => {
        if(!this.listItem.has(item.id)){
          this.listItem.set(item.id,item);
          const tag = new Tag();
          tag.isComponent = false;
          tag.msgId = item.msgId;
          tag.item = item;
          tag.component = undefined;
          if(component.componentType.endsWith("DB")){
            tag.title = component.title;
          }else{
            tag.title = "Description";
          }
          this.addToTag(tag);
        }
      })
    });
  }

  addToTag(tag: Tag){
    if(!this.listTag.has(tag.msgId)){
      this.listTag.set(tag.msgId,[]);
      if(tag.isComponent){
        if(tag.component){
          if(!this.listTagByComponentId.has(tag.component.id)){
            this.listTagByComponentId.set(tag.component.id,[]);
          }
        }
      }else{
        if(tag.item){
          if(!this.listTagByComponentId.has(tag.item.componentId)){
            this.listTagByComponentId.set(tag.item.componentId,[]);
          }
        }
      }
    }
    this.listTag.get(tag.msgId)?.push(tag);
    if(tag.isComponent){
      if(tag.component){
        this.listTagByComponentId.get(tag.component.id)?.push(tag);
      }
    }else{
      if(tag.item){
        this.listTagByComponentId.get(tag.item.componentId)?.push(tag);
      }
    }
  }

  getDbTitleByComponentId(componentId:number):string{
    const component = this.listComponent.get(componentId);
    if(component){
      if(component.componentType.endsWith("DB")){
        return component.title;
      }
    }
    return "Description";
  }

  addWsTagComponent(componentDTO: ComponentDTO) {
    const component = new ComponentM();
    component.id = componentDTO.id;
    component.msgId = componentDTO.msgId;
    component.componentType = componentDTO.componentType;
    component.msg = componentDTO.msg;
    component.projectId = componentDTO.projectId;
    component.title = componentDTO.title;
    // c.
    if(!this.listComponent.has(componentDTO.id)) {
      component.items = [];
      this.listComponent.set(componentDTO.id, component)
    }else{
      const item = this.listComponent.get(componentDTO.id)?.items;
      if(item){
        component.items = item;
        this.listComponent.set(componentDTO.id, component)
      }
    }
    const tag = new Tag();
    tag.isComponent = true;
    tag.msgId = component.msgId;
    tag.item = undefined;
    tag.component = component;
    if(component.componentType.endsWith("DB")){
      tag.title = component.title;
    }else{
      tag.title = "Description";
    }
    this.addToTag(tag);
  }

  addWsTagItem(item: Item) {
    if(!this.listItem.has(item.id)) {
      this.listItem.set(item.id, item);
    }else{
      this.listItem.set(item.id, item);
    }
    const tag = new Tag();
    tag.isComponent = false;
    tag.msgId = item.msgId;
    tag.item = item;
    tag.component = undefined;

    const component = this.listComponent.get(tag.item.componentId);
    if(component){
      if(component.componentType.endsWith("DB")){
        tag.title = component.title;
      }else{
        tag.title = "Description";
      }
    }else{
      tag.title = "XXXXXXXXX";
    }

    this.addToTag(tag);
  }

  getAllDbComponents(){
    const components: Array<ComponentM> = [];
    console.log("DB -- -1"+this.listComponent.size);
    this.listComponent.forEach(value => {
      console.log("DB -- 0");
      if(value.componentType == "DB"){
        console.log("DB -- 1")
        components.push(value);
      }
    })
    return components;
  }
}
