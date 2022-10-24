package com.julius.joinmy.models.dao;

import com.julius.joinmy.models.entity.Evento;

import java.util.List;

public interface IEventoDao {

    List<Evento> findAll();

    void save(Evento evento);


}
