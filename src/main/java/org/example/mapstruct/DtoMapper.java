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
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface    DtoMapper {
    @Mapping(target = "status", source = "ajzt")
    @Mapping(target = "source", expression = "java(ConvertAjly(record.getAjly()))")
    @Mapping(target = "remark", expression = "java(ConvertBz(record.getBz()))")
    public abstract CaseDTO JzajConvertCaseDTO(Record record);
     default String ConvertAjly(String s){
        String ajly = s;
        if (Objects.equals(ajly,"101")){
            return  "来源A";
        }
        if (Objects.equals(ajly,"201")){
            return  "来源B";
        }
        return null;
    }

     default String ConvertBz(String b){
         String bz = b;
         if (Objects.equals(bz,"这是备注")){
            return  "是的是备注";
        }
        if (Objects.equals(bz,"201")){
            return  "来源B";
        }
        return null;
    }
}
