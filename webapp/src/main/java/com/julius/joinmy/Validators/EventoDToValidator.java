package com.julius.joinmy.Validators;


import com.julius.joinmy.dtos.EventoDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class EventoDToValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EventoDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EventoDTO eventoDTO = (EventoDTO) target;

        if(eventoDTO.getDate().after(new Date())) {
            if(eventoDTO.getDateFinal().after(eventoDTO.getDate())){
                errors.rejectValue("dateFinal", "la fecha final tiene que ser mayor a la inicial.");
            }
        }else {
            errors.rejectValue("date", "la fecha tiene que ser mayor que la de hoy.");
        }


    }


}
