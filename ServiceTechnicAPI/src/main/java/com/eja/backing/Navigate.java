/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.facade.MestoFacadeREST;
import com.eja.facade.NavigovatFacadeREST;
import com.eja.model.Mesto;
import com.eja.model.Vyjezd;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


@ManagedBean
@SessionScoped
public class Navigate {

    
    
    private Mesto start;
    private Mesto cil;
    private List<Mesto> trasa;
    private double time;

    @Inject 
    NavigovatFacadeREST navigovatData;
    
    public boolean compare (String a){
        return a.equals(cil.getNazev());    
    }
    
    
      
    public boolean infinity (){
        return time == Double.POSITIVE_INFINITY;
    }  
    
    public String navigate(List<Vyjezd> src){
    
        cil = src.get(0).allIdMesto();
        
        
        
       try{ 
          trasa = navigovatData.navigate(start.getId_mesto(), cil.getId_mesto());
          time = navigovatData.countTime(start.getId_mesto(), cil.getId_mesto());
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());  
       }
        return "navigovat?faces-redirect=true";
    }

    public List<Mesto> getTrasa() {
        return trasa;
    }

    public void setTrasa(List<Mesto> trasa) {
        this.trasa = trasa;
    }

    public Mesto getStart() {
        return start;
    }

    public void setStart(Mesto start) {
        this.start = start;
    }

    public Mesto getCil() {
        return cil;
    }

    public void setCil(Mesto cil) {
        this.cil = cil;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    

   
    
    

}

