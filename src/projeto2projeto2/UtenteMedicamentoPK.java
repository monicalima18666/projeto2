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
import javax.persistence.Embeddable;

/**
 *
 * @author Monica
 */
@Embeddable
public class UtenteMedicamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_ANIMAL")
    private BigInteger idAnimal;
    @Basic(optional = false)
    @Column(name = "ID_MEDICAMENTO")
    private BigInteger idMedicamento;

    public UtenteMedicamentoPK() {
    }

    public UtenteMedicamentoPK(BigInteger idAnimal, BigInteger idMedicamento) {
        this.idAnimal = idAnimal;
        this.idMedicamento = idMedicamento;
    }

    public BigInteger getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(BigInteger idAnimal) {
        this.idAnimal = idAnimal;
    }

    public BigInteger getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(BigInteger idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtenteMedicamentoPK)) {
            return false;
        }
        UtenteMedicamentoPK other = (UtenteMedicamentoPK) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.UtenteMedicamentoPK[ idAnimal=" + idAnimal + ", idMedicamento=" + idMedicamento + " ]";
    }
    
}
