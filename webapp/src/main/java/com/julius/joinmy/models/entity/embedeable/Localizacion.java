package com.julius.joinmy.models.entity.embedeable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Localizacion {

    @Column(nullable = false)
    private String localizacion;
    private Double longitud;
    private Double latitud;

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
}
