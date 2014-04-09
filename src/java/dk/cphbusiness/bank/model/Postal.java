/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Saleh
 */
@Entity
@Table(name = "POSTALS")
@NamedQueries({
    @NamedQuery(name = "Postal.findAll", query = "SELECT p FROM Postal p")})
public class Postal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTALCODE")
    private Integer postalcode;
    @Size(max = 40)
    @Column(name = "POSTALDISTRICT")
    private String postaldistrict;
    @OneToMany(mappedBy = "postal")
    private Collection<Person> personCollection;

    public Postal() {
    }

    public Postal(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getPostaldistrict() {
        return postaldistrict;
    }

    public void setPostaldistrict(String postaldistrict) {
        this.postaldistrict = postaldistrict;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postalcode != null ? postalcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postal)) {
            return false;
        }
        Postal other = (Postal) object;
        if ((this.postalcode == null && other.postalcode != null) || (this.postalcode != null && !this.postalcode.equals(other.postalcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.bank.model.Postal[ postalcode=" + postalcode + " ]";
    }
    
}
