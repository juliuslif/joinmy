package com.julius.joinmy.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Eventos")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;

    private String descripcion;

    private String descripcionCorta;

    @Column(name = "max_persons", nullable = false)
    private Integer maxNumOfPersons;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "date_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "date_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user_admin")
    private Usuario userAdmin;

    @ManyToMany(mappedBy = "eventosSubscriber", fetch = FetchType.LAZY)
    private Set<Usuario> subscriptores;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

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

    public Usuario getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(Usuario userAdmin) {
        this.userAdmin = userAdmin;
    }

    public Set<Usuario> getSubscriptores() {
        return subscriptores;
    }

    public void setSubscriptores(Set<Usuario> subscriptores) {
        this.subscriptores = subscriptores;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }
}
