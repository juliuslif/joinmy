package com.julius.joinmy.models.dao;

import com.julius.joinmy.models.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventoDaoImpl implements IEventoDao {


    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List findAll() {

        return em.createQuery("from Evento").getResultList();
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        em.persist(evento);

    }

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
