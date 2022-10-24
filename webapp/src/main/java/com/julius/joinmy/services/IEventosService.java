package com.julius.joinmy.services;

import com.julius.joinmy.models.entity.Evento;

import java.util.List;

public interface IEventosService {
    List<Evento> findAll();

    void save(Evento evento);

}
