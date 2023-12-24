package com.team.chathack.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;
    private int sort;
    private int name;
    private int value;
    private ItemTypeDTO itemType;
    private ComponentDTO component;

}
