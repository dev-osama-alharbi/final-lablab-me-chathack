import { Injectable } from '@angular/core';
import axios, {Method} from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    // axios.defaults.baseURL = "https://2925-51-39-65-71.ngrok-free.app";
    // axios.defaults.baseURL = "http://localhost:8080";
    // axios.defaults.baseURL = "http://lablabb:8080";
    // axios.defaults.headers.post["Content-type"] = "application/json";
    axios.defaults.headers.post["Content-type"] = "application/json";
    axios.defaults.headers.put["Content-type"] = "application/json";
    axios.defaults.headers.patch["Content-type"] = "application/json";
    axios.defaults.headers.delete["Content-type"] = "application/json";
  }

  request(method: Method, url: string, data: any): Promise<any>{

    return axios({
      method: method,
      url: url,
      data: data
    });

  }

  requestWithResponseBody<T>(method: Method, url: string): Promise<any>{
    return axios<T>({
      method: method,
      url: url,
      transformResponse: data1 => JSON.parse(data1) as T
    });

  }

  requestGet(url: string): Promise<any>{
    return axios.get(url);
  }
}
