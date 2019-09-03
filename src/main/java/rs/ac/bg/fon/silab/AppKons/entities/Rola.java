/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "ROLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rola.findAll", query = "SELECT r FROM Rola r")
    , @NamedQuery(name = "Rola.findByIdRole", query = "SELECT r FROM Rola r WHERE r.idRole = :idRole")
    , @NamedQuery(name = "Rola.findByNazivRole", query = "SELECT r FROM Rola r WHERE r.nazivRole = ?1")})
public class Rola implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAZIV_ROLE")
    private String nazivRole;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROLE")
    private BigDecimal idRole;

    public Rola() {
    }

    public Rola(BigDecimal idRole) {
        this.idRole = idRole;
    }

    public Rola(BigDecimal idRole, String nazivRole) {
        this.idRole = idRole;
        this.nazivRole = nazivRole;
    }

    public BigDecimal getIdRole() {
        return idRole;
    }

    public void setIdRole(BigDecimal idRole) {
        this.idRole = idRole;
    }

    public String getNazivRole() {
        return nazivRole;
    }

    public void setNazivRole(String nazivRole) {
        this.nazivRole = nazivRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rola)) {
            return false;
        }
        Rola other = (Rola) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.silab.AppKons.entities.Rola[ idRole=" + idRole + " ]";
    }

}
