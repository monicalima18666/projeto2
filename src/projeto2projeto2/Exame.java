/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2projeto2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "EXAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")
    , @NamedQuery(name = "Exame.findByNumexame", query = "SELECT e FROM Exame e WHERE e.numexame = :numexame")
    , @NamedQuery(name = "Exame.findByTipoexame", query = "SELECT e FROM Exame e WHERE e.tipoexame = :tipoexame")
    , @NamedQuery(name = "Exame.findByDdata", query = "SELECT e FROM Exame e WHERE e.ddata = :ddata")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMEXAME")
    private BigDecimal numexame;
    @Basic(optional = false)
    @Column(name = "TIPOEXAME")
    private String tipoexame;
    @Basic(optional = false)
    @Column(name = "DDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddata;
    @ManyToMany(mappedBy = "exameCollection")
    private Collection<Consulta> consultaCollection;

    public Exame() {
    }

    public Exame(BigDecimal numexame) {
        this.numexame = numexame;
    }

    public Exame(BigDecimal numexame, String tipoexame, Date ddata) {
        this.numexame = numexame;
        this.tipoexame = tipoexame;
        this.ddata = ddata;
    }

    public BigDecimal getNumexame() {
        return numexame;
    }

    public void setNumexame(BigDecimal numexame) {
        this.numexame = numexame;
    }

    public String getTipoexame() {
        return tipoexame;
    }

    public void setTipoexame(String tipoexame) {
        this.tipoexame = tipoexame;
    }

    public Date getDdata() {
        return ddata;
    }

    public void setDdata(Date ddata) {
        this.ddata = ddata;
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numexame != null ? numexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.numexame == null && other.numexame != null) || (this.numexame != null && !this.numexame.equals(other.numexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Exame[ numexame=" + numexame + " ]";
    }
    
}
