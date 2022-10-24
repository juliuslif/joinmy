package com.julius.joinmy.services;

import com.julius.joinmy.models.dao.IEventoDao;
import com.julius.joinmy.models.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosServiceImpl implements IEventosService {
    private IEventoDao eventoDao;

    @Override
    public List<Evento> findAll() {
        return eventoDao.findAll();
    }

    @Override
    public void save(Evento evento) {
        eventoDao.save(evento);
    }

    @Autowired
    public void setEventoDao(IEventoDao eventoDao) {
        this.eventoDao = eventoDao;
    }
}
