package com.julius.joinmy.services;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.helpers.PageRender;
import com.julius.joinmy.models.exceptions.SubscribeException;

import java.util.List;

public interface IEventosService {
    List<EventoDTO> findAll();

    //PageRender<EventoDTO> findAll(Integer page);

    List<EventoDTO> findAllByFilter(FilterDTO filter);

    List<EventoDTO> finAllByUser(String username);

    List<EventoDTO> finSubsByUser(String username);

    void save(EventoDTO evento, String username);

    EventoDTO findOne(Long id);

    void subscribeByUsernameAndEventoId(String username, Long eventoId) throws SubscribeException;

    void desSubscribeByUsernameAndEventoId(String username, Long eventoId);

}
