/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.integration;

import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Technik;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class TechnikDAO {
    @PersistenceContext
    EntityManager em;

    public List<Technik> getTechnik() {
        Query q = em.createNamedQuery("Technik.all");
        return q.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void add(Technik c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Technik c = find(id);
        em.remove(c);

    }

    public Technik find(Long id) {
       return em.find(Technik.class, id);
    }
    
 
}
