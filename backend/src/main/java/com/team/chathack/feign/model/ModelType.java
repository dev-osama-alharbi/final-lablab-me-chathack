package com.team.chathack.feign.model;

public enum ModelType {
    GPT_3_5_TURBO_0613("gpt-3.5-turbo-1106"),TEXT_ADA_001("text-embedding-ada-002");
    private final String type;
    ModelType(String type){
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}
