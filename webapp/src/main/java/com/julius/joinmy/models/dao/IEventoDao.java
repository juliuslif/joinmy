package com.julius.joinmy.models.dao;

import com.julius.joinmy.models.entity.Evento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventoDao extends JpaRepository<Evento, Long> {

    List<Evento> findByTituloLikeIgnoreCaseOrDescripcionLikeIgnoreCase(String titulo, String descripcion, Pageable pageable);

}
