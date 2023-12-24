package com.team.chathack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<BODY> {
    private BODY body;
    private ApiResponseType type = ApiResponseType.NO_TYPE;
    private int httpCode;
    private ArrayList<String> errors = new ArrayList<>();
    private boolean hasErrors = false;

    public void addError(String error){
        errors.add(error);
    }
    public ArrayList<String> getErrors(){
        return this.errors;
    }

    public enum ApiResponseType{
        NO_TYPE("NO_TYPE"),
        MSG_NEW("MSG_NEW"),
        MSG_ALL("MSG_ALL"),
        TAG_ADDED("TAG_ADDED"),
        TAG_GET_ALL("TAG_GET_ALL"),
        TAG_ADDED_ITEM("TAG_ADDED_ITEM"),
        TAG_ADDED_COMPONENT("TAG_ADDED_COMPONENT"),
        OPENAI_RESPONSE_DES("OPENAI_RESPONSE_DES"),
        OPENAI_RESPONSE_SQL("OPENAI_RESPONSE_SQL"),
        OPENAI_RESPONSE_JAVA("OPENAI_RESPONSE_JAVA"),
        OPENAI_RESPONSE_CPP("OPENAI_RESPONSE_CPP"),
        OPENAI_RESPONSE_JSON("OPENAI_RESPONSE_JSON");
        private String type;
        ApiResponseType(String type){
            this.type = type;
        }
        @Override
        public String toString() {
            return this.type;
        }
    }
}
