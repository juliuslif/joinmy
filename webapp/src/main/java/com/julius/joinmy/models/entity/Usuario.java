package com.julius.joinmy.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 6, max = 25)
    @Column(unique = true)
    String username;

    @Size(min = 6, max = 60)
    String password;

    @Size(min = 6, max = 30)
    String nombreCompleto;

    Boolean enabled;

    String authority;

    @OneToMany(mappedBy = "userAdmin",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Evento> eventosAdmin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "subscription",
            joinColumns = { @JoinColumn(name = "fk_usuario") },
            inverseJoinColumns = { @JoinColumn(name = "fk_evento") })
    List<Evento> eventosSubscriber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<Evento> getEventosAdmin() {
        return eventosAdmin;
    }

    public void setEventosAdmin(List<Evento> eventosAdmin) {
        this.eventosAdmin = eventosAdmin;
    }

    public List<Evento> getEventosSubscriber() {
        return eventosSubscriber;
    }

    public void setEventosSubscriber(List<Evento> eventosSubscriber) {
        this.eventosSubscriber = eventosSubscriber;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
