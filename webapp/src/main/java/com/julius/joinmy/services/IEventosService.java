package com.julius.joinmy.services;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.helpers.PageRender;

import java.util.List;

public interface IEventosService {
    List<EventoDTO> findAll();

    PageRender<EventoDTO> findAll(Integer page);

    void save(EventoDTO evento);

    EventoDTO findOne(Long id);

}
