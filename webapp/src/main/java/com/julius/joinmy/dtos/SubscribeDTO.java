package com.julius.joinmy.dtos;

import javax.validation.constraints.NotNull;

public class SubscribeDTO {

    @NotNull
    private Long eventoId;

    @NotNull
    private Boolean isSubscribe;

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Boolean getSubscribe() {
        return isSubscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        isSubscribe = subscribe;
    }

    @Override
    public String toString() {
        return "SubscribeDTO{" +
                "eventoId=" + eventoId +
                ", isSubscribe=" + isSubscribe +
                '}';
    }
}
