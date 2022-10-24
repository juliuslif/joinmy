package com.julius.joinmy.mapper;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.models.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    EventoDTO eventoToeventoDTO(Evento evento);

    Evento eventoDTOtoevento(EventoDTO eventoDTO);

}

