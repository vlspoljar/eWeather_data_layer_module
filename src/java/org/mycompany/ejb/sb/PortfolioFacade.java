/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mycompany.ejb.eb.Portfolio;

/**
 *
 * @author Branko
 */
@Stateless
public class PortfolioFacade extends AbstractFacade<Portfolio> {
    @PersistenceContext(unitName = "eWeather_data_layer_modulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PortfolioFacade() {
        super(Portfolio.class);
    }
    
}
