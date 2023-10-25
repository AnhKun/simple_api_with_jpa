package com.example.simpleapi.onetoone.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    public static <T> T toModel(Object obj, Class<T> zClass) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
        return (T) modelMapper.map(obj, zClass);
    }

    public static <T, Y> List<T> toList(List<Y> list, Class<T> zClass){
        return list.stream().map(e -> toModel(e, zClass)).toList();
    }
}
