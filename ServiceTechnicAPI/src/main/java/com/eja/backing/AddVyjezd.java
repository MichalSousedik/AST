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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class AddVyjezd {
    private Mesto mesto;
    private Technik technik;
    private Dispecer dispecer;
    private String zakaznik;
    private String popis;
    private int cas;
    @Inject
    VyjezdFacadeREST vyjezdData;
    
    public String add(Dispecer disp) {
        for(Vyjezd x : vyjezdData.findAll()){
            if(x.getIdTechnik().equals(technik)){
                if(x.getHodina() == cas){
                    return "casError?faces-redirect=true";
                }
            }
        }
        Vyjezd c = new Vyjezd(zakaznik, popis, disp, mesto, technik, cas);
        vyjezdData.create(c);
        return "indexVyjezd?faces-redirect=true";
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public Technik getTechnik() {
        return technik;
    }

    public void setTechnik(Technik technik) {
        this.technik = technik;
    }

    public Dispecer getDispecer() {
        return dispecer;
    }

    public void setDispecer(Dispecer dispecer) {
        this.dispecer = dispecer;
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


}
