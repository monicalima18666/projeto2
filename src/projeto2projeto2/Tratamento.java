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
import javax.persistence.ManyToMany;
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
@Table(name = "TRATAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamento.findAll", query = "SELECT t FROM Tratamento t")
    , @NamedQuery(name = "Tratamento.findByIdTratamento", query = "SELECT t FROM Tratamento t WHERE t.idTratamento = :idTratamento")
    , @NamedQuery(name = "Tratamento.findByTipotratamento", query = "SELECT t FROM Tratamento t WHERE t.tipotratamento = :tipotratamento")})
public class Tratamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRATAMENTO")
    private BigDecimal idTratamento;
    @Basic(optional = false)
    @Column(name = "TIPOTRATAMENTO")
    private String tipotratamento;
    @ManyToMany(mappedBy = "tratamentoCollection")
    private Collection<Consulta> consultaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tratamento")
    private Collection<Receitamedica> receitamedicaCollection;

    public Tratamento() {
    }

    public Tratamento(BigDecimal idTratamento) {
        this.idTratamento = idTratamento;
    }

    public Tratamento(BigDecimal idTratamento, String tipotratamento) {
        this.idTratamento = idTratamento;
        this.tipotratamento = tipotratamento;
    }

    public BigDecimal getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(BigDecimal idTratamento) {
        this.idTratamento = idTratamento;
    }

    public String getTipotratamento() {
        return tipotratamento;
    }

    public void setTipotratamento(String tipotratamento) {
        this.tipotratamento = tipotratamento;
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }

    @XmlTransient
    public Collection<Receitamedica> getReceitamedicaCollection() {
        return receitamedicaCollection;
    }

    public void setReceitamedicaCollection(Collection<Receitamedica> receitamedicaCollection) {
        this.receitamedicaCollection = receitamedicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamento != null ? idTratamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamento)) {
            return false;
        }
        Tratamento other = (Tratamento) object;
        if ((this.idTratamento == null && other.idTratamento != null) || (this.idTratamento != null && !this.idTratamento.equals(other.idTratamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Tratamento[ idTratamento=" + idTratamento + " ]";
    }
    
}
