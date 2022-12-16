package com.julius.joinmy.dtos;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class EventoDTO {

    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;

    private String descripcionCorta;

    private Date createAt;
    //@DateTimeFormat(pattern = "MM-dd-yyyy' at' HH:mm:ss")
    private Date date;

    private String dateFormated;

    //@DateTimeFormat(pattern = "MM-dd-yyyy' at' HH:mm:ss")
    private Date dateFinal;

    @Range(min = 3, max = 1000)
    private Integer maxNumOfPersons;

    private List<UsuarioDTO> subscriptores;

    private UsuarioDTO userAdmin;

    private Boolean isUserSubscrito;

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

    public Integer getMaxNumOfPersons() {
        return maxNumOfPersons;
    }

    public void setMaxNumOfPersons(Integer maxNumOfPersons) {
        this.maxNumOfPersons = maxNumOfPersons;
    }

    public List<UsuarioDTO> getSubscriptores() {
        return subscriptores;
    }

    public void setSubscriptores(List<UsuarioDTO> subscriptores) {
        this.subscriptores = subscriptores;
    }

    public UsuarioDTO getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UsuarioDTO userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getDateFormated() {
        return dateFormated;
    }

    public void setDateFormated(String dateFormated) {
        this.dateFormated = dateFormated;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public Boolean getUserSubscrito() {
        return isUserSubscrito;
    }

    public void setUserSubscrito(Boolean userSubscrito) {
        isUserSubscrito = userSubscrito;
    }
}
