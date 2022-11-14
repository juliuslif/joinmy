package com.julius.joinmy.helpers;


import java.util.List;

public class PageRender<T> {
    private String url;
    private List<T> page;

    private int totalPaginas;

    private int numElementsPagina;

    private int paginaActual;

    public PageRender(String url, List<T> page, int paginaActual, int totalPaginas, int numElementsPagina) {
        this.url = url;
        this.page = page;
        this.totalPaginas = totalPaginas;
        this.numElementsPagina = numElementsPagina;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getNumElementsPagina() {
        return numElementsPagina;
    }

    public void setNumElementsPagina(int numElementsPagina) {
        this.numElementsPagina = numElementsPagina;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }
}
