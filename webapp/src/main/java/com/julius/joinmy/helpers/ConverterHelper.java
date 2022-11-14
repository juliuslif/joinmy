package com.julius.joinmy.helpers;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterHelper {

    public static List<?> convertList(List<?> list, Class<?> toConvertClass, ModelMapper mapper) {
        return list.stream().map(e -> mapper.map(e, toConvertClass)).collect(Collectors.toList());
    }

}
