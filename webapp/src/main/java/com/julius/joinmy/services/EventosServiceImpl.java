package com.julius.joinmy.services;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.helpers.ConverterHelper;
import com.julius.joinmy.helpers.PageRender;
import com.julius.joinmy.models.dao.IEventoDao;
import com.julius.joinmy.models.dao.IUsuarioDao;
import com.julius.joinmy.models.dao.Specifications.EventoSpecidications;
import com.julius.joinmy.models.entity.Evento;
import com.julius.joinmy.models.entity.Usuario;
import com.julius.joinmy.models.exceptions.SubscribeException;
import com.julius.joinmy.models.exceptions.UnsubscribeException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventosServiceImpl implements IEventosService {
    private IEventoDao eventoDao;

    private IUsuarioDao usuarioDao;
    private ModelMapper mapper;

    @Override
    public List<EventoDTO> findAll() {
        return (List<EventoDTO>) ConverterHelper.convertList( eventoDao.findAll(), EventoDTO.class, mapper);
    }

/*    @Override
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
    }*/

    @Override
    public List<EventoDTO> findAllByFilter(FilterDTO filter) {
        Pageable pageRequest = PageRequest.of(filter.getPagina(), 8);
        EventoSpecidications eventoSpecidications = new EventoSpecidications(filter);
        List<Evento> lista = eventoDao.findAll(eventoSpecidications,pageRequest).getContent();
        List<EventoDTO> content = (List<EventoDTO>) ConverterHelper.convertList( lista, EventoDTO.class, mapper);
        return content;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventoDTO> finAllByUser(String username) {
        Usuario usuario = usuarioDao.findByUsername(username);
        List<Evento> list = usuario.getEventosAdmin();
        List<EventoDTO> content = (List<EventoDTO>) ConverterHelper.convertList( list, EventoDTO.class, mapper);
        return content;
    }

    @Override
    public List<EventoDTO> finSubsByUser(String username) {
        Usuario usuario = usuarioDao.findByUsername(username);
        Set<Evento> set = usuario.getEventosSubscriber();
        List<EventoDTO> content = (List<EventoDTO>) ConverterHelper.convertSet( set, EventoDTO.class, mapper);
        return content;
    }

    @Override
    @Transactional
    public void save(EventoDTO evento, String username) {
        Usuario usuario = usuarioDao.findByUsername(username);
        Evento eventoE = mapper.map(evento, Evento.class);
        eventoE.setUserAdmin(usuario);
        eventoDao.save(eventoE);

    }

    @Override
    public EventoDTO findOne(Long id) {
        return mapper.map(eventoDao.findById(id).orElse(null), EventoDTO.class);
    }

    @Override
    @Transactional
    public void subscribeByUsernameAndEventoId(String username, Long eventoId) throws SubscribeException{
        Usuario usuario = usuarioDao.findByUsername(username);
        Optional<Evento> eventoO = eventoDao.findById(eventoId);
        if(eventoO.isPresent()) {
            Optional<Usuario> result = eventoO.get().getSubscriptores()
                    .stream().parallel()
                    .filter(sub -> sub.getUsername().equalsIgnoreCase(username)).findAny();
            if (result.isPresent()){
                throw new SubscribeException();
            }else {
                usuario.addEventoSub(eventoO.get());
            }
        }else {
            throw new SubscribeException();
        }



    }

    @Override
    @Transactional
    public void desSubscribeByUsernameAndEventoId(String username, Long eventoId)  throws UnsubscribeException{
        Usuario usuario = usuarioDao.findByUsername(username);
        Optional<Evento> eventoO = eventoDao.findById(eventoId);
        if(eventoO.isPresent()) {
            Optional<Usuario> result = eventoO.get().getSubscriptores()
                    .stream().parallel()
                    .filter(sub -> sub.getUsername().equalsIgnoreCase(username)).findAny();
            if (result.isPresent()){
                usuario.removeEventoSub(eventoO.get());

            }else {
                throw new UnsubscribeException();
            }
        }else {
            throw new UnsubscribeException();
        }

    }

    @Autowired
    public void setEventoDao(IEventoDao eventoDao) {
        this.eventoDao = eventoDao;
    }

    @Autowired
    public void setUsuarioDao(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
