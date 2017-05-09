/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eja.integration;


import com.eja.model.Trasa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class TrasaDAO {
    @PersistenceContext
    EntityManager em;

    public List<Trasa> getTrasa() {
        Query q = em.createNamedQuery("Trasa.all");
        return q.getResultList();
    }

    public void add(Trasa c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Trasa c = find(id);
        em.remove(c);

    }

    public Trasa find(Long id) {
       return em.find(Trasa.class, id);
    }
}
