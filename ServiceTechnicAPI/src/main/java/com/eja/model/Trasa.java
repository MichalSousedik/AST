/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michal
 */
@Entity
@Table(name = "TRASA")
@XmlRootElement
    @NamedQuery(name = "Trasa.all", query = "SELECT t FROM Trasa t")
public class Trasa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)  
    private Long id_Trasa;

    
    private int cas;
    
    @JoinColumn(name = "ID_CIL", referencedColumnName = "ID_MESTO")
    @ManyToOne(optional = false)
    private Mesto idCil;
    
    @JoinColumn(name = "ID_START", referencedColumnName = "ID_MESTO")
    @ManyToOne(optional = false)
    private Mesto idStart;

    public Trasa() {
    }

    public Trasa(Long idTrasa) {
        this.id_Trasa = idTrasa;
    }

    public Trasa(Long idTrasa, int cas) {
        this.id_Trasa = idTrasa;
        this.cas = cas;
    }

    public Trasa( Mesto idCil, Mesto idStart, int cas) {
        this.cas = cas;
        this.idCil = idCil;
        this.idStart = idStart;
    }

    public Trasa(Long id_Trasa, int cas, Mesto idCil, Mesto idStart) {
        this.id_Trasa = id_Trasa;
        this.cas = cas;
        this.idCil = idCil;
        this.idStart = idStart;
    }

    
    
    public Long getId_Trasa() {
        return id_Trasa;
    }

    public void setId_Trasa(Long id_Trasa) {
        this.id_Trasa = id_Trasa;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public Mesto getIdCil() {
        return idCil;
    }

    public void setIdCil(Mesto idCil) {
        this.idCil = idCil;
    }

    public Mesto getIdStart() {
        return idStart;
    }

    public void setIdStart(Mesto idStart) {
        this.idStart = idStart;
    }

    @Override
    public String toString() {
        return  "" + idCil ;
    }
    
    

 
    
}
