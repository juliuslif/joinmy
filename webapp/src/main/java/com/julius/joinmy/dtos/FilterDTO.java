package com.julius.joinmy.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FilterDTO {
    private int pagina;
    private String busqueda;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechaFinal;

    private String localizacion;

    private Double longitud;

    private Double latitud;

    private Double radio;
    private Boolean isPlazaLibre;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Boolean getPlazaLibre() {
        return isPlazaLibre;
    }

    public void setPlazaLibre(Boolean plazaLibre) {
        isPlazaLibre = plazaLibre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "FilterDTO{" +
                "pagina=" + pagina +
                ", busqueda='" + busqueda + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", localizacion='" + localizacion + '\'' +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", radio=" + radio +
                ", isPlazaLibre=" + isPlazaLibre +
                '}';
    }
}
