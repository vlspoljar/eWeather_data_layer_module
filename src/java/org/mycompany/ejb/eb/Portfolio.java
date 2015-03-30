/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ejb.eb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Branko
 */
@Entity
@Table(name = "PORTFOLIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"),
    @NamedQuery(name = "Portfolio.findByIdportfolio", query = "SELECT p FROM Portfolio p WHERE p.idportfolio = :idportfolio"),
    @NamedQuery(name = "Portfolio.findByPortfolio", query = "SELECT p FROM Portfolio p WHERE p.portfolio = :portfolio")})
public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPORTFOLIO")
    private Integer idportfolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PORTFOLIO")
    private String portfolio;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Eweatheruser iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idportfolio")
    private List<PortfolioHasAddress> portfolioHasAddressList;

    public Portfolio() {
    }

    public Portfolio(Integer idportfolio) {
        this.idportfolio = idportfolio;
    }

    public Portfolio(Integer idportfolio, String portfolio) {
        this.idportfolio = idportfolio;
        this.portfolio = portfolio;
    }

    public Integer getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(Integer idportfolio) {
        this.idportfolio = idportfolio;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public Eweatheruser getIduser() {
        return iduser;
    }

    public void setIduser(Eweatheruser iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public List<PortfolioHasAddress> getPortfolioHasAddressList() {
        return portfolioHasAddressList;
    }

    public void setPortfolioHasAddressList(List<PortfolioHasAddress> portfolioHasAddressList) {
        this.portfolioHasAddressList = portfolioHasAddressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idportfolio != null ? idportfolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.idportfolio == null && other.idportfolio != null) || (this.idportfolio != null && !this.idportfolio.equals(other.idportfolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mycompany.ejb.eb.Portfolio[ idportfolio=" + idportfolio + " ]";
    }
    
}
