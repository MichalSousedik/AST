/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.DispecerFacadeREST;
import com.eja.facade.MestoFacadeREST;
import com.eja.facade.TechnikFacadeREST;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AddTechnik {
    private String id;
    private String username;
    private String lastname;
    private String firstname;
    
    @Inject
    TechnikFacadeREST technikData;

    @Inject
    MestoFacadeREST m;
    
    
    public String add() {

        Technik c = new Technik(username,lastname,firstname);
        try {
            technikData.create(c);
        } catch (Exception ex) {

            return "alreadyExist?faces-redirect=true";
        }
        return "loginTechnik?faces-redirect=true";
    }


    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


}
