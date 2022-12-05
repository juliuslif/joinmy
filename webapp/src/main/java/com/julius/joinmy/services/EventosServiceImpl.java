package com.julius.joinmy.services;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.helpers.ConverterHelper;
import com.julius.joinmy.helpers.PageRender;
import com.julius.joinmy.models.dao.IEventoDao;
import com.julius.joinmy.models.entity.Evento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosServiceImpl implements IEventosService {
    private IEventoDao eventoDao;
    private ModelMapper mapper;

    @Override
    public List<EventoDTO> findAll() {
        return (List<EventoDTO>) ConverterHelper.convertList( eventoDao.findAll(), EventoDTO.class, mapper);
    }

    @Override
    public PageRender<EventoDTO> findAll(Integer page) {
        Pageable pageRequest = PageRequest.of(page, 2);
        Page<Evento> pageObject = eventoDao.findAll(pageRequest);
        List<EventoDTO> content = (List<EventoDTO>) ConverterHelper.convertList( pageObject.getContent(), EventoDTO.class, mapper);

        Boolean previusPage = false;
        Boolean nextPage = false;
        if(page<pageObject.getTotalPages()-1) {
            nextPage = true;
        }
        if(page >0) {
            previusPage = true;
        }

        PageRender<EventoDTO> pageRender= new PageRender<EventoDTO>("", content,page,pageObject.getTotalPages(),pageObject.getNumberOfElements(), previusPage, nextPage);
        return pageRender;
    }

    @Override
    public List<EventoDTO> findAllByFilter(FilterDTO filter) {
        Pageable pageRequest = PageRequest.of(filter.getPagina(), 8);
        if (filter.getFechaInicio()!= null) {

        }
        if (filter.getFechaFinal()!= null) {

        }
        List<Evento> lista = eventoDao.findByTituloLikeIgnoreCaseOrDescripcionLikeIgnoreCase("%" + filter.getBusqueda() + "%", "%" + filter.getBusqueda() + "%" , pageRequest);
        List<EventoDTO> content = (List<EventoDTO>) ConverterHelper.convertList( lista, EventoDTO.class, mapper);
        return content;
    }

    @Override
    public void save(EventoDTO evento) {
        eventoDao.save(mapper.map(evento, Evento.class));

        //if(evento.getId()!= null && evento.getId()>0) {
        //    eventoDao.save(evento);
        //}else {
        //    eventoDao.save(evento);
        //}

    }

    @Override
    public EventoDTO findOne(Long id) {
        return mapper.map(eventoDao.findById(id).orElse(null), EventoDTO.class);
    }

    @Autowired
    public void setEventoDao(IEventoDao eventoDao) {
        this.eventoDao = eventoDao;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
