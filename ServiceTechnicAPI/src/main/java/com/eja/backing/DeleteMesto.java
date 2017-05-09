/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.MestoFacadeREST;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Michal
 */
@Model
public class DeleteMesto {

    @Inject
    MestoFacadeREST mestoData;
    
    
    private Long mestoId;
    
    public Long getMestoId() {
        return mestoId;
    }

    public void setMestoId(Long mestoId) {
        this.mestoId = mestoId;
    }

//    public Customer getCustomer() {
//        return customer;
//    }

    public String getName() {
        return mestoData.find(mestoId).getNazev();
    }


    public String delete() {
        mestoData.remove(mestoId);
        return "indexMesto?faces-redirect=true";
    }

}

