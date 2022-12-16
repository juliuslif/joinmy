package com.julius.joinmy.helpers;

import com.julius.joinmy.dtos.UsuarioDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConverterHelper {

    public static List<?> convertSet(Set<?> set, Class<?> toConvertClass, ModelMapper mapper) {
        return set.stream().map(e -> mapper.map(e, toConvertClass)).collect(Collectors.toList());
    }
    public static List<?> convertList(List<?> list, Class<?> toConvertClass, ModelMapper mapper) {
        return list.stream().map(e -> mapper.map(e, toConvertClass)).collect(Collectors.toList());
    }

    public static boolean hasUser(List<UsuarioDTO> users , String username) {
        Boolean result = users.stream().anyMatch((u) ->u.getUsername().equals(username));
        System.out.println(result);
        return result;
    }

}
