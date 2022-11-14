package com.julius.joinmy.models.dao;

import com.julius.joinmy.models.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoDao extends JpaRepository<Evento, Long> {


}
