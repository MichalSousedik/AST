/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.integration;

import com.eja.model.Mesto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class MestoDAO {
    @PersistenceContext
    EntityManager em;

    public List<Mesto> getMesto() {
        Query q = em.createNamedQuery("Mesto.all");
        return q.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void add(Mesto c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Mesto c = find(id);
        em.remove(c);

    }

    public Mesto find(Long id) {
       return em.find(Mesto.class, id);
    }
}
