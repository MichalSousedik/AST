/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.integration;

import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class DispecerDAO {
    @PersistenceContext
    EntityManager em;

    public List<Dispecer> getDispecer() {
        Query q = em.createNamedQuery("Dispecer.all");
        return q.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void add(Dispecer c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Dispecer c = find(id);
        em.remove(c);

    }

    public Dispecer find(Long id) {
       return em.find(Dispecer.class, id);
    }
}
