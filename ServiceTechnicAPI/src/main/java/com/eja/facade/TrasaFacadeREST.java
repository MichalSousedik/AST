/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.facade;

import com.eja.integration.MestoDAO;
import com.eja.integration.TrasaDAO;
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
@Path("trasa")
public class TrasaFacadeREST {
    @Inject 
    TrasaDAO trasaDAO;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Trasa entity) {
        trasaDAO.add(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Trasa entity) {
       trasaDAO.delete(id);
       trasaDAO.add(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        trasaDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Trasa find(@PathParam("id") Long id) {
        return trasaDAO.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Trasa> findAll() {
        return trasaDAO.getTrasa();
    }


    
}
