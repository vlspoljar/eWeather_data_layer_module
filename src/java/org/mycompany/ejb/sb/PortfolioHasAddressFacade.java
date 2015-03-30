/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.sb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mycompany.ejb.eb.PortfolioHasAddress;

/**
 *
 * @author Branko
 */
@Stateless
public class PortfolioHasAddressFacade extends AbstractFacade<PortfolioHasAddress> {
    @PersistenceContext(unitName = "eWeather_data_layer_modulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PortfolioHasAddressFacade() {
        super(PortfolioHasAddress.class);
    }
    
}
