/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.TrasaFacadeREST;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class AddTrasa {
    private Mesto start;
    private Mesto cil;
    private int cas;
    
    @Inject
    TrasaFacadeREST trasaData;
    
    public String add() {
        
        if(start.equals(cil))return "startCil?faces-redirect=true";
        Trasa c = new Trasa(cil,start,cas);
        trasaData.create(c);
        return "indexTrasa?faces-redirect=true";
    }

    public Mesto getStart() {
        return start;
    }
    
    
//


    public void setStart(Mesto start) {
        this.start = start;
    }

    public Mesto getCil() {
        return cil;
    }

    public void setCil(Mesto cil) {
        this.cil = cil;
    }

    

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }


}
