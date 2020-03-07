/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2projeto2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "CPOSTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cpostal.findAll", query = "SELECT c FROM Cpostal c")
    , @NamedQuery(name = "Cpostal.findByCodpostal", query = "SELECT c FROM Cpostal c WHERE c.codpostal = :codpostal")
    , @NamedQuery(name = "Cpostal.findByLocalidade", query = "SELECT c FROM Cpostal c WHERE c.localidade = :localidade")})
public class Cpostal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODPOSTAL")
    private BigDecimal codpostal;
    @Basic(optional = false)
    @Column(name = "LOCALIDADE")
    private String localidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpostal")
    private Collection<Utente> utenteCollection;

    public Cpostal() {
    }

    public Cpostal(BigDecimal codpostal) {
        this.codpostal = codpostal;
    }

    public Cpostal(BigDecimal codpostal, String localidade) {
        this.codpostal = codpostal;
        this.localidade = localidade;
    }

    public BigDecimal getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(BigDecimal codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @XmlTransient
    public Collection<Utente> getUtenteCollection() {
        return utenteCollection;
    }

    public void setUtenteCollection(Collection<Utente> utenteCollection) {
        this.utenteCollection = utenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpostal != null ? codpostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpostal)) {
            return false;
        }
        Cpostal other = (Cpostal) object;
        if ((this.codpostal == null && other.codpostal != null) || (this.codpostal != null && !this.codpostal.equals(other.codpostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Cpostal[ codpostal=" + codpostal + " ]";
    }
    
}
