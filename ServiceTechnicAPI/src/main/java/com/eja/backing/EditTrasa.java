/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;


import com.eja.facade.TrasaFacadeREST;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Michal
 */
@Model
public class EditTrasa {

    @Inject
    TrasaFacadeREST trasaData;

    private Long trasaId;
    private Mesto startIdNew;
    private Mesto cilIdNew;
    private int casNew;

    public int getCasNew() {
        return casNew;
    }

    public void setCasNew(int casNew) {
        this.casNew = casNew;
    }
    
    public Long getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(Long trasaId) {
        this.trasaId = trasaId;
    }

    public Mesto getStartIdNew() {
        return startIdNew;
    }

    public void setStartIdNew(Mesto startIdNew) {
        this.startIdNew = startIdNew;
    }

    public Mesto getCilIdNew() {
        return cilIdNew;
    }

    public void setCilIdNew(Mesto cilIdNew) {
        this.cilIdNew = cilIdNew;
    }

  


    
    public Mesto getStartId() {
        return trasaData.find(trasaId).getIdStart();
    }

    public Mesto getCilId() {
        return trasaData.find(trasaId).getIdCil();
    }

    public int getCas() {
        return trasaData.find(trasaId).getCas();
    }

    public String edit() {
        if(startIdNew.equals(cilIdNew))return "startCil?faces-redirect=true";
        trasaData.edit(trasaId,new Trasa(cilIdNew, startIdNew, casNew));
        return "indexTrasa?faces-redirect=true";
    }

}
