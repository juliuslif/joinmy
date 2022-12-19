package com.julius.joinmy.dtos;
import com.julius.joinmy.models.entity.embedeable.Localizacion;
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

    @NotBlank
    private String descripcionCorta;


    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;

    private String dateFormated;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateFinal;

    @Range(min = 3, max = 1000)
    private Integer maxNumOfPersons;

    private LocalizacionDTO localizacion;

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

    public LocalizacionDTO getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(LocalizacionDTO localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "EventoDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", descripcionCorta='" + descripcionCorta + '\'' +
                ", createAt=" + createAt +
                ", date=" + date +
                ", dateFormated='" + dateFormated + '\'' +
                ", dateFinal=" + dateFinal +
                ", maxNumOfPersons=" + maxNumOfPersons +
                ", localizacion=" + localizacion +
                ", subscriptores=" + subscriptores +
                ", userAdmin=" + userAdmin +
                ", isUserSubscrito=" + isUserSubscrito +
                '}';
    }
}
