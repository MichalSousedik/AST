/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.facade;

import com.eja.integration.DispecerDAO;
import com.eja.integration.MestoDAO;
import com.eja.integration.VyjezdDAO;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
import com.eja.model.Vyjezd;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Michal
 */
@Stateless
@Path("vyjezd")
public class VyjezdFacadeREST  {
  
    @Inject 
    VyjezdDAO vyjezdDAO;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Vyjezd entity) {
        vyjezdDAO.add(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        vyjezdDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Vyjezd find(@PathParam("id") Long id) {
       return vyjezdDAO.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Vyjezd> findAll() {
        return vyjezdDAO.getVyjezd();
    }
    
    @GET
    @Path("/technik/{id}")
    @Produces({"application/xml", "application/json"})
    public Vyjezd findVyjezdByID(@PathParam("id") Long id) {
       return vyjezdDAO.find(id);
    }
    
    
    /*@GET
    @Produces({"application/xml", "application/json"})
    public List<Vyjezd> findAllSorted() {
        List<Vyjezd> sorted = vyjezdDAO.getVyjezd();
        Collections.sort(sorted, Vyjezd.getCompByTime());
        return sorted;
    }*/
    

 
    
}

