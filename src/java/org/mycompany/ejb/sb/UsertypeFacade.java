/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.mycompany.ejb.eb.Usertype;

/**
 *
 * @author Branko
 */
@Stateless
public class UsertypeFacade extends AbstractFacade<Usertype> {
    @PersistenceContext(unitName = "eWeather_data_layer_modulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsertypeFacade() {
        super(Usertype.class);
    }
    
    public Usertype getUsertype (int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Usertype.class);
        Root<Usertype> usertype = cq.from(Usertype.class);
        cq.where(cb.equal(usertype.get("idtype"), id));
        Query q = em.createQuery(cq);
        return (Usertype) q.getSingleResult();
    }
    
}
