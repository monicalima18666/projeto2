/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2projeto2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdMedicamento", query = "SELECT m FROM Medicamento m WHERE m.idMedicamento = :idMedicamento")
    , @NamedQuery(name = "Medicamento.findByTipomedicamento", query = "SELECT m FROM Medicamento m WHERE m.tipomedicamento = :tipomedicamento")
    , @NamedQuery(name = "Medicamento.findByDescricao", query = "SELECT m FROM Medicamento m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Medicamento.findByPreco", query = "SELECT m FROM Medicamento m WHERE m.preco = :preco")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MEDICAMENTO")
    private BigDecimal idMedicamento;
    @Basic(optional = false)
    @Column(name = "TIPOMEDICAMENTO")
    private String tipomedicamento;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "PRECO")
    private BigInteger preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamento")
    private Collection<UtenteMedicamento> utenteMedicamentoCollection;

    public Medicamento() {
    }

    public Medicamento(BigDecimal idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento(BigDecimal idMedicamento, String tipomedicamento, String descricao) {
        this.idMedicamento = idMedicamento;
        this.tipomedicamento = tipomedicamento;
        this.descricao = descricao;
    }

    public BigDecimal getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(BigDecimal idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getTipomedicamento() {
        return tipomedicamento;
    }

    public void setTipomedicamento(String tipomedicamento) {
        this.tipomedicamento = tipomedicamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigInteger getPreco() {
        return preco;
    }

    public void setPreco(BigInteger preco) {
        this.preco = preco;
    }

    @XmlTransient
    public Collection<UtenteMedicamento> getUtenteMedicamentoCollection() {
        return utenteMedicamentoCollection;
    }

    public void setUtenteMedicamentoCollection(Collection<UtenteMedicamento> utenteMedicamentoCollection) {
        this.utenteMedicamentoCollection = utenteMedicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
