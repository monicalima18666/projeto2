/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2projeto2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "UTENTE_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtenteMedicamento.findAll", query = "SELECT u FROM UtenteMedicamento u")
    , @NamedQuery(name = "UtenteMedicamento.findByQuantidade", query = "SELECT u FROM UtenteMedicamento u WHERE u.quantidade = :quantidade")
    , @NamedQuery(name = "UtenteMedicamento.findByIdAnimal", query = "SELECT u FROM UtenteMedicamento u WHERE u.utenteMedicamentoPK.idAnimal = :idAnimal")
    , @NamedQuery(name = "UtenteMedicamento.findByIdMedicamento", query = "SELECT u FROM UtenteMedicamento u WHERE u.utenteMedicamentoPK.idMedicamento = :idMedicamento")})
public class UtenteMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UtenteMedicamentoPK utenteMedicamentoPK;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigInteger quantidade;
    @JoinColumn(name = "ID_MEDICAMENTO", referencedColumnName = "ID_MEDICAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utente utente;

    public UtenteMedicamento() {
    }

    public UtenteMedicamento(UtenteMedicamentoPK utenteMedicamentoPK) {
        this.utenteMedicamentoPK = utenteMedicamentoPK;
    }

    public UtenteMedicamento(UtenteMedicamentoPK utenteMedicamentoPK, BigInteger quantidade) {
        this.utenteMedicamentoPK = utenteMedicamentoPK;
        this.quantidade = quantidade;
    }

    public UtenteMedicamento(BigInteger idAnimal, BigInteger idMedicamento) {
        this.utenteMedicamentoPK = new UtenteMedicamentoPK(idAnimal, idMedicamento);
    }

    public UtenteMedicamentoPK getUtenteMedicamentoPK() {
        return utenteMedicamentoPK;
    }

    public void setUtenteMedicamentoPK(UtenteMedicamentoPK utenteMedicamentoPK) {
        this.utenteMedicamentoPK = utenteMedicamentoPK;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utenteMedicamentoPK != null ? utenteMedicamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtenteMedicamento)) {
            return false;
        }
        UtenteMedicamento other = (UtenteMedicamento) object;
        if ((this.utenteMedicamentoPK == null && other.utenteMedicamentoPK != null) || (this.utenteMedicamentoPK != null && !this.utenteMedicamentoPK.equals(other.utenteMedicamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.UtenteMedicamento[ utenteMedicamentoPK=" + utenteMedicamentoPK + " ]";
    }
    
}
