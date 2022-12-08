package com.julius.joinmy.models.dao.Specifications;

import com.julius.joinmy.models.entity.Evento;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;


public class EventoSpecidications {

    public static Specification<Evento> getEventoFechaInicio(String fecha) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.greaterThan(root.get("date"), fecha);
            return predicate;
        };

    }
    public static Specification<Evento> getEventoFechaFinal(String fecha) {

        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.greaterThan(root.get("date"), fecha);
            return predicate;
        };
    }
    public static Specification<Evento> getEventoPlazasLibres() {
        return null;

    }
}
