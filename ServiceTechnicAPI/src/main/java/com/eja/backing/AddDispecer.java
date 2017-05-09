/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.DispecerFacadeREST;
import com.eja.model.Dispecer;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class AddDispecer {
     private String id;
    private String username;
    private String lastname;
    private String firstname;
    @Inject
    DispecerFacadeREST dispecerData;

    public String add() {
        Dispecer c = new Dispecer(username,lastname,firstname);
        try {
            dispecerData.create(c);
        } catch (Exception ex) {

            return "alreadyExist?faces-redirect=true";
        }
        return "loginDispecer?faces-redirect=true";
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
