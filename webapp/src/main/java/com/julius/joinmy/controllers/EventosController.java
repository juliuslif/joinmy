package com.julius.joinmy.controllers;

import com.julius.joinmy.dtos.EventoDTO;
import com.julius.joinmy.dtos.FilterDTO;
import com.julius.joinmy.dtos.SubscribeDTO;
import com.julius.joinmy.helpers.ConverterHelper;
import com.julius.joinmy.models.exceptions.SubscribeException;
import com.julius.joinmy.models.exceptions.UnsubscribeException;
import com.julius.joinmy.services.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class EventosController {

    private IEventosService eventosService;

    @RequestMapping(method = RequestMethod.GET, path = "eventos")
    public String getEventos() {
        return "eventos";
    }

    @RequestMapping(method = RequestMethod.GET, path = "mieventos")
    public String getMisEventos(Authentication authentication, Model model) {
        model.addAttribute("eventos",eventosService.finAllByUser(authentication.getName()));
        return "myeventos";
    }
    @RequestMapping(method = RequestMethod.GET, path = "misubs")
    public String getMisSubs(Authentication authentication, Model model) {
        model.addAttribute("eventos",eventosService.finSubsByUser(authentication.getName()));
        return "myeventos";
    }

    @RequestMapping(value = "/evento/{id}")
    public String editEventoForm(@PathVariable Long id, Model model, RedirectAttributes flash, Authentication authentication) {
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

        String pattern = "MMMM dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(eventoDTO.getDate());
        eventoDTO.setDateFormated(date);
        eventoDTO.setUserSubscrito(ConverterHelper.hasUser(eventoDTO.getSubscriptores(), authentication.getName()));
        model.addAttribute("evento", eventoDTO);

        return "eventoView";


    }

    @RequestMapping(value = "addEvento")
    public String addEventoForm(@ModelAttribute("evento") EventoDTO eventoDTO) {

        return "eventoForm";
    }

    @RequestMapping(value = "addEvento", method = RequestMethod.POST)
    public String addEvento(@ModelAttribute("evento") @Valid EventoDTO eventoDTO, BindingResult result, RedirectAttributes flash, Authentication authentication) {

        if (result.hasErrors()){
            return "eventoForm";
        }


        eventosService.save(eventoDTO, authentication.getName());
        flash.addFlashAttribute("success", "Cliente creado con exito");
        return "redirect:/eventos";
    }

    @ResponseBody
    @RequestMapping(value = "/eventos/res", produces = { "application/json", "application/xml" })
    public List<EventoDTO> eventosRes(FilterDTO filter) {
        System.out.println(filter);
        return eventosService.findAllByFilter(filter);
    }
    @RequestMapping(value = "subscribirse", method = RequestMethod.POST)
    public String subscribirse (@Valid SubscribeDTO subscribe, BindingResult result, Authentication authentication, RedirectAttributes flash) {

        System.out.println("-----------------------------------------------------------------------");
        System.out.println(subscribe);
        if(result.hasErrors()) {
            flash.addFlashAttribute("error", "ALgo fue mal en la subscripcion");
            return "redirect:/eventos";
        }

        if (subscribe.getSubscribe()) {
            try {
                eventosService.subscribeByUsernameAndEventoId(authentication.getName(), subscribe.getEventoId());
            }catch (SubscribeException subscribeException) {
                flash.addFlashAttribute("error", subscribeException.getMessage());
                return "redirect:/eventos";
            }

        }else {
            try {
                eventosService.desSubscribeByUsernameAndEventoId(authentication.getName(), subscribe.getEventoId());
            }catch (UnsubscribeException unsubscribeException) {
                flash.addFlashAttribute("error", unsubscribeException.getMessage());
                return "redirect:/eventos";
            }

        }

        flash.addFlashAttribute("success",(subscribe.getSubscribe())? "subscrito correctamente": "desubscrito correctamente");
        return "redirect:/evento/".concat(subscribe.getEventoId().toString());
    }

    @Autowired
    public void setEventosService(IEventosService eventosService) {
        this.eventosService = eventosService;
    }

}
