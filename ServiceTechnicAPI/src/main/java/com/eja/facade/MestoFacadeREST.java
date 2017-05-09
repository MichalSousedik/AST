/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.facade;

import com.eja.integration.MestoDAO;
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
@Path("mesto")
public class MestoFacadeREST  {
  
    @Inject 
    MestoDAO mestoDAO;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Mesto entity) {
        mestoDAO.add(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        mestoDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Mesto find(@PathParam("id") Long id) {
       return mestoDAO.find(id);
    }
    


    @GET
    @Produces("application/json")
    public List<Mesto> findAll() {
        return mestoDAO.getMesto();
    }
 
 
    
}
