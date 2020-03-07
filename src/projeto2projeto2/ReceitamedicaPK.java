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
public class ReceitamedicaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_CONSULTA")
    private BigInteger idConsulta;
    @Basic(optional = false)
    @Column(name = "ID_TRATAMENTO")
    private BigInteger idTratamento;

    public ReceitamedicaPK() {
    }

    public ReceitamedicaPK(BigInteger idConsulta, BigInteger idTratamento) {
        this.idConsulta = idConsulta;
        this.idTratamento = idTratamento;
    }

    public BigInteger getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(BigInteger idConsulta) {
        this.idConsulta = idConsulta;
    }

    public BigInteger getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(BigInteger idTratamento) {
        this.idTratamento = idTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        hash += (idTratamento != null ? idTratamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceitamedicaPK)) {
            return false;
        }
        ReceitamedicaPK other = (ReceitamedicaPK) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        if ((this.idTratamento == null && other.idTratamento != null) || (this.idTratamento != null && !this.idTratamento.equals(other.idTratamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.ReceitamedicaPK[ idConsulta=" + idConsulta + ", idTratamento=" + idTratamento + " ]";
    }
    
}
