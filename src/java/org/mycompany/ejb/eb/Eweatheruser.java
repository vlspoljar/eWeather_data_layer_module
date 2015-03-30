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
@Table(name = "EWEATHERUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eweatheruser.findAll", query = "SELECT e FROM Eweatheruser e"),
    @NamedQuery(name = "Eweatheruser.findByIduser", query = "SELECT e FROM Eweatheruser e WHERE e.iduser = :iduser"),
    @NamedQuery(name = "Eweatheruser.findByFirstname", query = "SELECT e FROM Eweatheruser e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Eweatheruser.findBySurname", query = "SELECT e FROM Eweatheruser e WHERE e.surname = :surname"),
    @NamedQuery(name = "Eweatheruser.findByUsername", query = "SELECT e FROM Eweatheruser e WHERE e.username = :username"),
    @NamedQuery(name = "Eweatheruser.findByPassword", query = "SELECT e FROM Eweatheruser e WHERE e.password = :password"),
    @NamedQuery(name = "Eweatheruser.findByEmail", query = "SELECT e FROM Eweatheruser e WHERE e.email = :email"),
    @NamedQuery(name = "Eweatheruser.findByGender", query = "SELECT e FROM Eweatheruser e WHERE e.gender = :gender"),
    @NamedQuery(name = "Eweatheruser.findByDateofbirth", query = "SELECT e FROM Eweatheruser e WHERE e.dateofbirth = :dateofbirth")})
public class Eweatheruser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Integer iduser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SURNAME")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DATEOFBIRTH")
    private String dateofbirth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Portfolio> portfolioList;
    @JoinColumn(name = "IDTYPE", referencedColumnName = "IDTYPE")
    @ManyToOne
    private Usertype idtype;

    public Eweatheruser() {
    }

    public Eweatheruser(Integer iduser) {
        this.iduser = iduser;
    }

    public Eweatheruser(Integer iduser, String firstname, String surname, String username, String password, String email, String gender, String dateofbirth) {
        this.iduser = iduser;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @XmlTransient
    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void setPortfolioList(List<Portfolio> portfolioList) {
        this.portfolioList = portfolioList;
    }

    public Usertype getIdtype() {
        return idtype;
    }

    public void setIdtype(Usertype idtype) {
        this.idtype = idtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eweatheruser)) {
            return false;
        }
        Eweatheruser other = (Eweatheruser) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mycompany.ejb.eb.Eweatheruser[ iduser=" + iduser + " ]";
    }
    
}
