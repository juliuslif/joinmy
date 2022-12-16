package com.julius.joinmy.models.dao.Specifications;

import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.models.entity.Evento;
import com.julius.joinmy.models.entity.Evento_;
import com.julius.joinmy.models.entity.Usuario_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;


public class EventoSpecidications implements Specification<Evento>{

    private final FilterDTO filter;

    public EventoSpecidications(FilterDTO filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Evento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
        if(filter.getBusqueda()!= null) {
            Predicate predicate1 = criteriaBuilder.like(root.get(Evento_.TITULO), "%"+filter.getBusqueda()+"%");
            Predicate predicate2 = criteriaBuilder.like(root.get(Evento_.DESCRIPCION), "%"+filter.getBusqueda()+"%");
            predicate =  criteriaBuilder.and(predicate,criteriaBuilder.or(predicate1,predicate2));
        }
        if(filter.getFechaFinal()!= null) {
            Predicate predicate1 = criteriaBuilder.lessThanOrEqualTo(root.get(Evento_.date), filter.getFechaFinal());
            predicate =  criteriaBuilder.and(predicate,predicate1);
        }
        if(filter.getFechaInicio()!= null) {
            Predicate predicate1 = criteriaBuilder.greaterThanOrEqualTo(root.get(Evento_.date), filter.getFechaInicio());
            predicate =  criteriaBuilder.and(predicate,predicate1);
        }
        if (filter.getPlazaLibre()!= null && filter.getPlazaLibre()) {
            Subquery<Integer> subquery = query.subquery(Integer.class);
            Root<Evento> subqueryRoot = subquery.from(Evento.class);
            subquery.select(criteriaBuilder.size(subqueryRoot.get(Evento_.SUBSCRIPTORES)));
            subquery.where(criteriaBuilder.equal(subqueryRoot.get(Evento_.ID), root.get(Evento_.ID)));
            Predicate predicate1 = criteriaBuilder.lessThan(subquery, root.get(Evento_.MAX_NUM_OF_PERSONS));
            predicate =  criteriaBuilder.and(predicate,predicate1);
        }
        query.orderBy(criteriaBuilder.asc(root.get(Evento_.DATE)));


        return predicate;
    }
}
