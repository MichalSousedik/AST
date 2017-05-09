/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.backing;

import com.eja.integration.MestoDAO;
import com.eja.integration.TechnikDAO;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import java.lang.annotation.Annotation;
import java.math.BigInteger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ManagedBean(name = "technikConverterBean") 
@FacesConverter(value = "technikConverter")
public class ConverterTechnik implements Converter{

     @Inject 
     TechnikDAO technikDAO;  

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
      // This will return the actual object representation
      // of your Category using the value (in your case 52) 
      // returned from the client side
      return technikDAO.getEm().find(Technik.class, new Long (value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        //This will return view-friendly output for the dropdown menu
        return ((Technik) o).getIdDispecer().toString(); 
    }


}
