package com.julius.joinmy.dtos;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class EventoDTO {

    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;

    private Date createAt;
    //@DateTimeFormat(pattern = "MM-dd-yyyy' at' HH:mm:ss")
    private Date date;

    //@DateTimeFormat(pattern = "MM-dd-yyyy' at' HH:mm:ss")
    private Date dateFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }
}
