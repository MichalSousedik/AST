/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;


import com.eja.facade.TrasaFacadeREST;
import com.eja.facade.VyjezdFacadeREST;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import com.eja.model.Trasa;
import com.eja.model.Vyjezd;
import java.sql.Date;
import java.sql.Time;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

/**
 *
 * @author Michal
 */
@ManagedBean(name = "edit") 
@SessionScoped
public class EditVyjezd {

    @Inject
    VyjezdFacadeREST vyjezdData;

    private Long vyjezdID;
    private Technik technik;
    private Mesto mesto;
    private String zakaznik;
    private String popis;
    private int cas;


    public String edit(Dispecer dispecer){
        for(Vyjezd x : vyjezdData.findAll()){
            if(x.getIdTechnik().equals(technik)){
                if((x.getHodina() == cas) && !(x.getIdVyjezd() == vyjezdID)){
                    return "casError?faces-redirect=true";
                }
            }
        }
        vyjezdData.remove(vyjezdID);
        vyjezdData.create(new Vyjezd(zakaznik, popis, dispecer, mesto, technik,cas));
        return "indexVyjezd?faces-redirect=true";
    }

    public int getCas() {
        
        return vyjezdData.find(vyjezdID).getHodina();
    }

    public void setCas(int cas) {
        this.cas = cas;
    }
    
    public Long getVyjezdID() {
        return vyjezdID;
    }

    public void setVyjezdID(Long vyjezdID) {
        this.vyjezdID = vyjezdID;
    }
    

    public Technik getTechnik() {
        return vyjezdData.find(vyjezdID).getIdTechnik();
    }

    public void setTechnik(Technik technik) {
        this.technik = technik;
    }

    public Mesto getMesto() {
        return vyjezdData.find(vyjezdID).allIdMesto();
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getZakaznik() {
        
         return vyjezdData.find(vyjezdID).getZakaznik();
    }

    public void setZakaznik(String zakaznik) {
        this.zakaznik = zakaznik;
    }

    public String getPopis() {
        return vyjezdData.find(vyjezdID).getPopis();
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }



}
