/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.integration;

import com.eja.model.Dispecer;
import com.eja.model.Mesto;
import com.eja.model.Vyjezd;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class VyjezdDAO {
    @PersistenceContext
    EntityManager em;

    public List<Vyjezd> getVyjezd() {
        Query q = em.createNamedQuery("Vyjezd.all");
        return q.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void add(Vyjezd c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Vyjezd c = find(id);
        em.remove(c);

    }

    public Vyjezd find(Long id) {
       return em.find(Vyjezd.class, id);
    }
}
