/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.sb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.mycompany.ejb.eb.Eweatheruser;

/**
 *
 * @author Branko
 */
@Stateless
public class EweatheruserFacade extends AbstractFacade<Eweatheruser> {
    @PersistenceContext(unitName = "eWeather_data_layer_modulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EweatheruserFacade() {
        super(Eweatheruser.class);
    }
    
    public void registerUser (Eweatheruser ewu) {
        this.create(ewu);
    }
    
    public List<Eweatheruser> checkUser (String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Eweatheruser.class);
        Root<Eweatheruser> korisnici = cq.from(Eweatheruser.class);
        cq.where(cb.and(cb.equal(korisnici.get("username"), username), cb.equal(korisnici.get("password"), password)));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
}
