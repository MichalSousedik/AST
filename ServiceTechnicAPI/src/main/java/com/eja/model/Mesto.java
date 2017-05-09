/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michal
 */
@Entity
@Table(name = "MESTO")
@XmlRootElement
@NamedQuery(name = "Mesto.all", query = "SELECT m FROM Mesto m")
public class Mesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_mesto;

    private String nazev;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCil")
    private List<Trasa> cil;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStart")
    private List<Trasa> start;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesto")
    private List<Vyjezd> vyjezdList;

    
    
    
    public Mesto() {
    }

    
    @XmlTransient
    public List<Vyjezd> getVyjezdList() {
        return vyjezdList;
    }

    public void setVyjezdList(List<Vyjezd> vyjezdList) {
        this.vyjezdList = vyjezdList;
    }

    public Mesto(Long idMesto) {
        this.id_mesto = idMesto;
    }

    public Mesto(Long idMesto, String nazev) {
        this.id_mesto = idMesto;
        this.nazev = nazev;
    }

    public Mesto(String nazev) {
        this.nazev = nazev;
    }

    public Long getId_mesto() {
        return id_mesto;
    }
    

    public void setId_mesto(Long id_mesto) {
        this.id_mesto = id_mesto;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

        @XmlTransient
    public List<Trasa> getCil() {
        return cil;
    }

    public void setCil(List<Trasa> cil) {
        this.cil = cil;
    }

    @XmlTransient
    public List<Trasa> getStart() {
        return start;
    }

    public void setStart(List<Trasa> start) {
        this.start = start;
    }


    


    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.id_mesto, other.id_mesto)) {
            return false;
        }
        return true;
    }
    
    
    
    
    @Override
    public String toString() {
        return nazev;
    }



}
