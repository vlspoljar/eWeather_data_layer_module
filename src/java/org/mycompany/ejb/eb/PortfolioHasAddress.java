/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.eb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Branko
 */
@Entity
@Table(name = "PORTFOLIO_HAS_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PortfolioHasAddress.findAll", query = "SELECT p FROM PortfolioHasAddress p"),
    @NamedQuery(name = "PortfolioHasAddress.findByIdporfolioHasAddress", query = "SELECT p FROM PortfolioHasAddress p WHERE p.idporfolioHasAddress = :idporfolioHasAddress")})
public class PortfolioHasAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPORFOLIO_HAS_ADDRESS")
    private Integer idporfolioHasAddress;
    @JoinColumn(name = "IDPORTFOLIO", referencedColumnName = "IDPORTFOLIO")
    @ManyToOne(optional = false)
    private Portfolio idportfolio;
    @JoinColumn(name = "IDADDRESS", referencedColumnName = "IDADDRESS")
    @ManyToOne(optional = false)
    private Address idaddress;

    public PortfolioHasAddress() {
    }

    public PortfolioHasAddress(Integer idporfolioHasAddress) {
        this.idporfolioHasAddress = idporfolioHasAddress;
    }

    public Integer getIdporfolioHasAddress() {
        return idporfolioHasAddress;
    }

    public void setIdporfolioHasAddress(Integer idporfolioHasAddress) {
        this.idporfolioHasAddress = idporfolioHasAddress;
    }

    public Portfolio getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(Portfolio idportfolio) {
        this.idportfolio = idportfolio;
    }

    public Address getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Address idaddress) {
        this.idaddress = idaddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idporfolioHasAddress != null ? idporfolioHasAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PortfolioHasAddress)) {
            return false;
        }
        PortfolioHasAddress other = (PortfolioHasAddress) object;
        if ((this.idporfolioHasAddress == null && other.idporfolioHasAddress != null) || (this.idporfolioHasAddress != null && !this.idporfolioHasAddress.equals(other.idporfolioHasAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mycompany.ejb.eb.PortfolioHasAddress[ idporfolioHasAddress=" + idporfolioHasAddress + " ]";
    }
    
}
