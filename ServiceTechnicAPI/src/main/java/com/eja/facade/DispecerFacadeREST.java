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
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
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
@Path("dispecer")
public class DispecerFacadeREST  {
  
    @Inject 
    DispecerDAO dispecerDAO;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Dispecer entity) {
        dispecerDAO.add(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        dispecerDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Dispecer find(@PathParam("id") Long id) {
       return dispecerDAO.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Dispecer> findAll() {
        return dispecerDAO.getDispecer();
    }

 
    
}

