package com.example;


import org.example.Main;
import org.example.dto.CaseDTO;
import org.example.dto.Record;
import org.example.mapstruct.DtoMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class MapStructTest {
    @Autowired
    DtoMapper dtoMapper;
    @Test
    public void testConvert(){

        Record record = new Record();
        record.setAjly("101");
        record.setBz("这是备注");
        record.setAjzt("1");
        CaseDTO caseDTO = dtoMapper.JzajConvertCaseDTO(record);
        Assertions.assertEquals("来源A",caseDTO.getSource());
        Assertions.assertEquals("是的是备注",caseDTO.getRemark());
        Assertions.assertSame(record.getAjzt(),caseDTO.getStatus());
    }

}
