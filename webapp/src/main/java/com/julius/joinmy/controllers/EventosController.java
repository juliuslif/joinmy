package com.julius.joinmy.controllers;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.helpers.ConverterHelper;
import com.julius.joinmy.helpers.PageRender;
import com.julius.joinmy.services.IEventosService;
import jdk.jfr.ContentType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventosController {

    private IEventosService eventosService;

    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.GET, path = "eventos")
    public String getEventos(@RequestParam(defaultValue = "0") int pagina, Model model) {

        List<EventoDTO> eventosDTOs = (List<EventoDTO>) ConverterHelper.convertList(eventosService.findAll(), EventoDTO.class, mapper);
        PageRender<EventoDTO> pageRender = eventosService.findAll(pagina);
        //List<EventoDTO> eventosDTOs = eventosService.findAll().stream().map(evento -> mapper.map(evento, EventoDTO.class)).collect(Collectors.toList());

        model.addAttribute("pageRender", pageRender);
        return "eventos";
    }

    @RequestMapping(value = "/evento/{id}")
    public String editEventoForm(@PathVariable Long id, Model model, RedirectAttributes flash) {
        EventoDTO eventoDTO;
        if(id>0) {
            eventoDTO = eventosService.findOne(id);
            if(eventoDTO== null){
                flash.addFlashAttribute("error", "No se encontro el evento");
                return "redirect:/eventos";
            }
        } else {
            flash.addFlashAttribute("error", "EL id tiene que ser mayor a 0");
            return "redirect:/eventos";
        }
        model.addAttribute("evento", eventoDTO);

        return "eventoForm";


    }

    @RequestMapping(value = "addEvento")
    public String addEventoForm(@ModelAttribute("evento") EventoDTO eventoDTO) {

        return "eventoForm";
    }

    @RequestMapping(value = "addEvento", method = RequestMethod.POST)
    public String addEvento(@ModelAttribute("evento") @Valid EventoDTO eventoDTO, BindingResult result, RedirectAttributes flash) {

        if (result.hasErrors()){
            return "eventoForm";
        }

        eventosService.save(eventoDTO);
        flash.addFlashAttribute("success", "Cliente creado con exito");
        return "redirect:/eventos";
    }

    @ResponseBody
    @RequestMapping(value = "/eventos/res", produces = { "application/json", "application/xml" })
    public List<EventoDTO> eventosRes(FilterDTO filter) {
        System.out.println(filter);
        return eventosService.findAllByFilter(filter);
    }

    @Autowired
    public void setEventosService(IEventosService eventosService) {
        this.eventosService = eventosService;
    }

    @Autowired
    public void setMapper(ModelMapper modelMapper) { this.mapper = modelMapper;}
}
