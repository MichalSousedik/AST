/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.MestoFacadeREST;
import com.eja.model.Mesto;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class AddMesto {
    private String name;
    
    @Inject
    MestoFacadeREST mestoData;

    public String add() {
        Mesto c = new Mesto(name);
        try{
        mestoData.create(c);
        }
        catch(Exception ex){
            
            return "alreadyExist?faces-redirect=true";
        }
        return "indexMesto?faces-redirect=true";
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
