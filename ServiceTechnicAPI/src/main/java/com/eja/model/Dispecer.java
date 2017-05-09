/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "DISPECER")
@XmlRootElement

@NamedQuery(name = "Dispecer.all", query = "SELECT d FROM Dispecer d WHERE d.dtype='Dispecer'")
public class Dispecer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id_dispecer;

    
    private String dtype;
    
    protected String jmeno;

    protected String prijmeni;

    protected String prezdivka;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDispecer")
    private List<Vyjezd> vyjezdList;

        @XmlTransient
    public List<Vyjezd> getVyjezdList() {
        return vyjezdList;
    }

    public void setVyjezdList(List<Vyjezd> vyjezdList) {
        this.vyjezdList = vyjezdList;
    }

   
    
    public Dispecer() {
    }

    public Dispecer(Long idDispecer) {
        this.id_dispecer = idDispecer;
    }

    public Dispecer(Long idDispecer, String jmeno, String prijmeni, String prezdivka) {
        this.id_dispecer = idDispecer;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.prezdivka = prezdivka;
    }

    public Dispecer(String prezdivka, String prijmeni, String jmeno ) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.prezdivka = prezdivka;
    }

    
    public Long getIdDispecer() {
        return id_dispecer;
    }

    public void setIdDispecer(Long idDispecer) {
        this.id_dispecer = idDispecer;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        this.prezdivka = prezdivka;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dispecer)) {
            return false;
        }
        Dispecer other = (Dispecer) object;
        if ((this.id_dispecer == null && other.id_dispecer != null) || (this.id_dispecer != null && !this.id_dispecer.equals(other.id_dispecer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + prezdivka;
    }

}
