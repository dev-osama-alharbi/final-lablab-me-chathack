import {Injectable} from '@angular/core';
import {AxiosService} from "./axios.service";
import {NewMsgDTO} from "../dto/new.msg.dto";
import {MsgDTO} from "../dto/msg.dto";
import {ApiResponse} from "../dto/api.response.dto";
import {ModelsService} from "./models.service";
import {AddNewTagDTO} from "../dto/addNewTagDTO";
import {ComponentM} from "../dto/tag.dto";
import {ChatGptResultDTO} from "../dto/chat.gpt.result.dto";


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private axiosService: AxiosService) {
  }

  addMsg(projectId: number, newMsg: NewMsgDTO) {
    this.axiosService.request(
      "POST",
      `api/v1/chat/project/${projectId}/msg`,
      newMsg
    )
  }

  getAllMsg(projectId: number, models: ModelsService) {

    this.axiosService.request(
      "GET",
      `api/v1/chat/project/${projectId}/msg`,
      undefined
    ).then(value => {
      console.log("AARR => "+value.data);
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "MSG_ALL":
            models.addAllMsg(body.body as MsgDTO[]);
          break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }
  addTag(projectId: number, tagDTO: AddNewTagDTO) {
    this.axiosService.request(
      "POST",
      `api/v1/tag/project/${projectId}/msg/${tagDTO.msgId}`,
      tagDTO
    )
  }

  getAllTag(projectId: number, models: ModelsService) {
    this.axiosService.request(
      "GET",
      `api/v1/tag/project/${projectId}`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "TAG_GET_ALL":
            models.addAllTag(body.body as ComponentM[]);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }

  callAiDes(projectId: number,callback: (result:string) => void) {
    let result = '';
    this.axiosService.request(
      "GET",
      `api/v1/component/project/${projectId}/call/type/DES`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "OPENAI_RESPONSE_DES":
            result = (body.body as ChatGptResultDTO).answer;
            callback(result);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }

  callAiSql(projectId: number,callback: (result:string) => void) {
    let result = '';
    this.axiosService.request(
      "GET",
      `api/v1/component/project/${projectId}/call/type/SQL`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "OPENAI_RESPONSE_SQL":
            result = (body.body as ChatGptResultDTO).answer;
            callback(result);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }

  callAiJava(projectId: number,callback: (result:string) => void) {
    let result = '';
    this.axiosService.request(
      "GET",
      `api/v1/component/project/${projectId}/call/type/JAVA`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "OPENAI_RESPONSE_JAVA":
            result = (body.body as ChatGptResultDTO).answer;
            callback(result);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }

  callAiCpp(projectId: number,callback: (result:string) => void) {
    let result = '';
    this.axiosService.request(
      "GET",
      `api/v1/component/project/${projectId}/call/type/CPP`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "OPENAI_RESPONSE_CPP":
            result = (body.body as ChatGptResultDTO).answer;
            callback(result);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }

  callAiJson(projectId: number,callback: (result:string) => void) {
    let result = '';
    this.axiosService.request(
      "GET",
      `api/v1/component/project/${projectId}/call/type/JSON`,
      undefined
    ).then(value => {
      const body: ApiResponse = value.data as ApiResponse;
      if (!body.hasErrors) {
        switch (body.type) {
          case "OPENAI_RESPONSE_JSON":
            result = (body.body as ChatGptResultDTO).answer;
            callback(result);
            break;
          default:{
            console.log("AAAAAAAAA "+body.type);
          }
        }
      } else {
      }
    });
  }
}
