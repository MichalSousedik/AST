/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Comparator;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michal
 */
@Entity
@Table(name = "VYJEZD")
@XmlRootElement
@NamedQuery(name = "Vyjezd.all", query = "SELECT v FROM Vyjezd v")
public class Vyjezd implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id_vyjezd;
    private String zakaznik;
    private String popis;
    @JoinColumn(name = "ID_DISPECER", referencedColumnName = "ID_DISPECER")
    @ManyToOne(optional = false)
    private Dispecer idDispecer;

    @JoinColumn(name = "ID_MESTO", referencedColumnName = "ID_MESTO")
    @ManyToOne(optional = false)
    private Mesto idMesto;

    @JoinColumn(name = "ID_TECHNIK", referencedColumnName = "ID_DISPECER")
    @ManyToOne(optional = false)
    private Technik id_technik;

    private int hodina;

    public int getHodina() {
        return hodina;
    }

    public void setHodina(int hodina) {
        this.hodina = hodina;
    }

    public Vyjezd() {
    }

    public Vyjezd(Long idVyjezd) {
        this.id_vyjezd = idVyjezd;
    }

    public Vyjezd(Long idVyjezd, String zakaznik) {
        this.id_vyjezd = idVyjezd;
        this.zakaznik = zakaznik;
    }

    public Vyjezd(String zakaznik, String popis, Dispecer idDispecer, Mesto idMesto, Technik idTechnik, int hodina) {
        this.zakaznik = zakaznik;
        this.popis = popis;
        this.idDispecer = idDispecer;
        this.idMesto = idMesto;
        this.id_technik = idTechnik;
        this.hodina = hodina;
    }

    public static Comparator<Vyjezd> getCompByTime() {
        Comparator comp = new Comparator<Vyjezd>() {
            @Override
            public int compare(Vyjezd v1, Vyjezd v2) {
                if (v1.hodina == v2.hodina) {
                    return 0;
                }
                if (v1.hodina > v2.hodina) {
                    return 1;
                }
                return -1;
            }
        };
        return comp;
    }



    public Long getIdVyjezd() {
        return id_vyjezd;
    }

    public void setIdVyjezd(Long idVyjezd) {
        this.id_vyjezd = idVyjezd;
    }

    public String getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(String zakaznik) {
        this.zakaznik = zakaznik;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Dispecer allIdDispecer() {
        return idDispecer;
    }

    public void setIdDispecer(Dispecer idDispecer) {
        this.idDispecer = idDispecer;
    }

    public Mesto allIdMesto() {
        return idMesto;
    }



    public void setIdMesto(Mesto idMesto) {
        this.idMesto = idMesto;
    }

    public Technik getIdTechnik() {
        return id_technik;
    }

    public Dispecer getIdDispecer() {
        return idDispecer;
    }

    public Mesto getIdMesto() {
        return idMesto;
    }

    public Technik getId_technik() {
        return id_technik;
    }


    
    

    public void setIdTechnik(Technik idTechnik) {
        this.id_technik = idTechnik;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vyjezd)) {
            return false;
        }
        Vyjezd other = (Vyjezd) object;
        if ((this.id_vyjezd == null && other.id_vyjezd != null) || (this.id_vyjezd != null && !this.id_vyjezd.equals(other.id_vyjezd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id_vyjezd;
    }

}
