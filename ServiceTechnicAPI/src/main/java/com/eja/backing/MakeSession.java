/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.model.Dispecer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class MakeSession {

    private String jmeno;
    private String prijmeni;
    private String prezdivka;
    private Long  id;
    private Dispecer dispecer;

    public Dispecer getDispecer() {
        return dispecer;
    }

    public void setDispecer(Dispecer dispecer) {
        this.dispecer = dispecer;
    }
    
    public String doLogin(Dispecer dispecer){
         jmeno=dispecer.getJmeno();
         prijmeni=dispecer.getPrijmeni();
         prezdivka=dispecer.getPrezdivka();
         id=dispecer.getIdDispecer();
         this.dispecer = dispecer;
         HttpSession hs = Util.getSession();
          return "indexDispecer?faces-redirect=true";
    }

    public String doLogout(){
    
        HttpSession hs = Util.getSession();
        hs.invalidate();    
        return "/index?faces-redirect=true";
    }
    
    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public Long getId() {
        return id;
    }
    
}
