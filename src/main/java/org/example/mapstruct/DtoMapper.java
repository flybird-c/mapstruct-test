package org.example.mapstruct;


import lombok.extern.slf4j.Slf4j;
import org.example.dto.CaseDTO;
import org.example.dto.Record;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 *@author : lzp
 *@date : 2024/10/16 14:29
 *@apiNote : 字段映射
 */
@Slf4j
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public abstract class DtoMapper {
    @Mapping(target = "status", source = "ajzt")
    @Mapping(target = "source", expression = "java(ConvertAjly(record.getAjly()))")
    @Mapping(target = "remark", source = "bz")
    public abstract CaseDTO JzajConvertCaseDTO(Record record);
    String ConvertAjly(String s){
        if (Objects.equals(s,"101")){
            return  "来源A";
        }
        if (Objects.equals(s,"201")){
            return  "来源B";
        }
        return null;
    }
}
