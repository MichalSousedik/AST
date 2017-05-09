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
import com.eja.integration.TechnikDAO;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Technik;
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
import javax.ws.rs.core.Response;

@Stateless
@Path("technik")
public class TechnikFacadeREST {

    @Inject
    TechnikDAO technikDAO;

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    public Response create(Technik entity) {
        for (Technik x : findAll()) {
            if (x.getPrezdivka().equals(entity.getPrezdivka())) {
                return Response.status(201).entity("Prezdivka existuje").build();
            }

        }
        technikDAO.add(entity);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        technikDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Technik find(@PathParam("id") Long id) {
        return technikDAO.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<Technik> findAll() {
        return technikDAO.getTechnik();
    }

    @PUT
    @Consumes({"application/json"})
    public void update(Technik entity) {
        Technik tmp = technikDAO.getEm().find(Technik.class, entity.getIdDispecer());

        tmp.setJmeno(entity.getJmeno());

        tmp.setPrezdivka(entity.getPrezdivka());

        tmp.setPrijmeni(entity.getPrijmeni());
        technikDAO.getEm().merge(tmp);

    }

    @GET
    @Path("/log/{name}")
    @Consumes("application/json")
    @Produces("application/json")
    public Technik logIn(@PathParam("name") String name) {
        for (Technik x : findAll()) {
            if (x.getPrezdivka().equals(name)) {
                return x;
            }
        }
        return new Technik();
    }
}

/*          <dependency>
 <groupId>org.primefaces</groupId>
 <artifactId>primefaces</artifactId>
 <version>5.3</version>
 </dependency>*/
