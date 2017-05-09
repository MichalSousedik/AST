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
import com.eja.integration.TrasaDAO;
import com.eja.business.*;
import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Trasa;
import com.eja.business.*;
import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Michal
 */
@Stateless
@Path("navigovat")
public class NavigovatFacadeREST {

    @Inject
    MestoDAO mestoDAO;

    @GET
    @Path("/time")
    @Produces({MediaType.TEXT_PLAIN})
    public double countTime(@QueryParam("start") Long startId,
            @QueryParam("cil") Long cilId) {
        Mesto start = mestoDAO.find(startId);
        Mesto cil = mestoDAO.find(cilId);
        List<Mesto> mesta = mestoDAO.getMesto();
        return shortestPathTime(mesta, start, cil);

    }

    @GET
    @Produces("application/json")
    public List<Mesto> navigate(@QueryParam("start") Long startId,
            @QueryParam("cil") Long cilId) {
        System.out.println(startId + " " + cilId);
        Mesto start = mestoDAO.find(startId);
        Mesto cil = mestoDAO.find(cilId);
        
        System.out.println(start + " -> " + cil);
        List<Mesto> mesta = mestoDAO.getMesto();
        List<Mesto> dst = shortestPath(mesta, start, cil);

        return dst;
    }

    private List<Mesto> shortestPath(List<Mesto> mesta, Mesto start, Mesto cil) {
        List<Vertex> vertex = new ArrayList<>();
        for (Mesto x : mesta) {
            Vertex tmp = new Vertex(x.getNazev());
            vertex.add(tmp);
        }

        for (int i = 0; i < mesta.size(); i++) {
            // System.out.println("Start: " + mesta.get(i) + " -> ");
            for (Trasa x : mesta.get(i).getStart()) {
                //  System.out.println(x + " ,");
                int k;
                for (k = 0; k < vertex.size(); k++) {
                    if (vertex.get(k).name.equals(x.getIdCil().getNazev())) {
                        break;
                    }

                }
                vertex.get(i).adjacencies.add(new Edge(vertex.get(k), x.getCas()));
            }

        }
        int s;
        for (s = 0; s < vertex.size(); s++) {
            if (vertex.get(s).name.equals(start.getNazev())) {
                break;
            }

        }

        int c;
        for (c = 0; c < vertex.size(); c++) {
            if (vertex.get(c).name.equals(cil.getNazev())) {
                break;
            }

        }

        Dijkstra solution = new Dijkstra();
        solution.computePaths(vertex.get(s));

        /* for(Vertex x : vertex){
         System.out.print(x.name + "->");
         for(Edge y : x.adjacencies){
         System.out.print(" " + y.target + ", ");
         }
         System.out.println("");
         }
         */
        List<Vertex> path = solution.getShortestPathTo(vertex.get(c));
        List<Mesto> dst = new ArrayList<>();

        for (Vertex y : path) {
            for (Mesto x : mesta) {
                if (x.getNazev().equals(y.name)) {
                    dst.add(x);
                }

            }
        }

        return dst;
    }

    private double shortestPathTime(List<Mesto> mesta, Mesto start, Mesto cil) {
       List<Vertex> vertex = new ArrayList<>();
        for (Mesto x : mesta) {
            Vertex tmp = new Vertex(x.getNazev());
            vertex.add(tmp);
        }

        for (int i = 0; i < mesta.size(); i++) {
            // System.out.println("Start: " + mesta.get(i) + " -> ");
            for (Trasa x : mesta.get(i).getStart()) {
                //  System.out.println(x + " ,");
                int k;
                for (k = 0; k < vertex.size(); k++) {
                    if (vertex.get(k).name.equals(x.getIdCil().getNazev())) {
                        break;
                    }

                }
                vertex.get(i).adjacencies.add(new Edge(vertex.get(k), x.getCas()));
            }

        }
        int s;
        for (s = 0; s < vertex.size(); s++) {
            if (vertex.get(s).name.equals(start.getNazev())) {
                break;
            }

        }

        int c;
        for (c = 0; c < vertex.size(); c++) {
            if (vertex.get(c).name.equals(cil.getNazev())) {
                break;
            }

        }

        Dijkstra solution = new Dijkstra();
        solution.computePaths(vertex.get(s));

        return vertex.get(c).minDistance;
    
    }

}
