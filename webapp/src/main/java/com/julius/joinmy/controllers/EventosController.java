package com.julius.joinmy.controllers;

import com.julius.joinmy.models.entity.Evento;
import com.julius.joinmy.services.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventosController {

    private IEventosService eventosService;

    @RequestMapping(method = RequestMethod.GET, path = "eventos")
    public String getEventos(Model model) {
        model.addAttribute("eventos", eventosService.findAll());
        return "eventos";
    }

    @RequestMapping(value = "addEvento")
    public String addEventoForm(@ModelAttribute Evento evento) {

        return "eventoForm";
    }

    @RequestMapping(value = "addEvento", method = RequestMethod.POST)
    public String addEvento(@ModelAttribute Evento evento) {


        eventosService.save(evento);
        return "redirect:/eventos";
    }

    @Autowired
    public void setEventosService(IEventosService eventosService) {
        this.eventosService = eventosService;
    }
}
