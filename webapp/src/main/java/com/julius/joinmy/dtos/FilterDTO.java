package com.julius.joinmy.dtos;

public class FilterDTO {
    private int pagina;
    private String busqueda;

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

    @Override
    public String toString() {
        return "FilterDTO{" +
                "pagina=" + pagina +
                ", busqueda='" + busqueda + '\'' +
                '}';
    }
}
