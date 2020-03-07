/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2projeto2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "PAGAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
    , @NamedQuery(name = "Pagamento.findByNumpagamento", query = "SELECT p FROM Pagamento p WHERE p.numpagamento = :numpagamento")
    , @NamedQuery(name = "Pagamento.findByValortotal", query = "SELECT p FROM Pagamento p WHERE p.valortotal = :valortotal")
    , @NamedQuery(name = "Pagamento.findByNumfatura", query = "SELECT p FROM Pagamento p WHERE p.numfatura = :numfatura")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMPAGAMENTO")
    private BigDecimal numpagamento;
    @Basic(optional = false)
    @Column(name = "VALORTOTAL")
    private BigInteger valortotal;
    @Basic(optional = false)
    @Column(name = "NUMFATURA")
    private BigInteger numfatura;
    @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA")
    @ManyToOne(optional = false)
    private Consulta idConsulta;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL")
    @ManyToOne(optional = false)
    private Utente idAnimal;

    public Pagamento() {
    }

    public Pagamento(BigDecimal numpagamento) {
        this.numpagamento = numpagamento;
    }

    public Pagamento(BigDecimal numpagamento, BigInteger valortotal, BigInteger numfatura) {
        this.numpagamento = numpagamento;
        this.valortotal = valortotal;
        this.numfatura = numfatura;
    }

    public BigDecimal getNumpagamento() {
        return numpagamento;
    }

    public void setNumpagamento(BigDecimal numpagamento) {
        this.numpagamento = numpagamento;
    }

    public BigInteger getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigInteger valortotal) {
        this.valortotal = valortotal;
    }

    public BigInteger getNumfatura() {
        return numfatura;
    }

    public void setNumfatura(BigInteger numfatura) {
        this.numfatura = numfatura;
    }

    public Consulta getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consulta idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Utente getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Utente idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numpagamento != null ? numpagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.numpagamento == null && other.numpagamento != null) || (this.numpagamento != null && !this.numpagamento.equals(other.numpagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Pagamento[ numpagamento=" + numpagamento + " ]";
    }
    
}
