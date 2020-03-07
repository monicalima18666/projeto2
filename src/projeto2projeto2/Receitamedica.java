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
@Table(name = "RECEITAMEDICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receitamedica.findAll", query = "SELECT r FROM Receitamedica r")
    , @NamedQuery(name = "Receitamedica.findByNumreceita", query = "SELECT r FROM Receitamedica r WHERE r.numreceita = :numreceita")
    , @NamedQuery(name = "Receitamedica.findByDescdomedicamento", query = "SELECT r FROM Receitamedica r WHERE r.descdomedicamento = :descdomedicamento")
    , @NamedQuery(name = "Receitamedica.findByIdConsulta", query = "SELECT r FROM Receitamedica r WHERE r.receitamedicaPK.idConsulta = :idConsulta")
    , @NamedQuery(name = "Receitamedica.findByIdTratamento", query = "SELECT r FROM Receitamedica r WHERE r.receitamedicaPK.idTratamento = :idTratamento")})
public class Receitamedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceitamedicaPK receitamedicaPK;
    @Basic(optional = false)
    @Column(name = "NUMRECEITA")
    private BigInteger numreceita;
    @Basic(optional = false)
    @Column(name = "DESCDOMEDICAMENTO")
    private String descdomedicamento;
    @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consulta consulta;
    @JoinColumn(name = "ID_TRATAMENTO", referencedColumnName = "ID_TRATAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamento tratamento;

    public Receitamedica() {
    }

    public Receitamedica(ReceitamedicaPK receitamedicaPK) {
        this.receitamedicaPK = receitamedicaPK;
    }

    public Receitamedica(ReceitamedicaPK receitamedicaPK, BigInteger numreceita, String descdomedicamento) {
        this.receitamedicaPK = receitamedicaPK;
        this.numreceita = numreceita;
        this.descdomedicamento = descdomedicamento;
    }

    public Receitamedica(BigInteger idConsulta, BigInteger idTratamento) {
        this.receitamedicaPK = new ReceitamedicaPK(idConsulta, idTratamento);
    }

    public ReceitamedicaPK getReceitamedicaPK() {
        return receitamedicaPK;
    }

    public void setReceitamedicaPK(ReceitamedicaPK receitamedicaPK) {
        this.receitamedicaPK = receitamedicaPK;
    }

    public BigInteger getNumreceita() {
        return numreceita;
    }

    public void setNumreceita(BigInteger numreceita) {
        this.numreceita = numreceita;
    }

    public String getDescdomedicamento() {
        return descdomedicamento;
    }

    public void setDescdomedicamento(String descdomedicamento) {
        this.descdomedicamento = descdomedicamento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receitamedicaPK != null ? receitamedicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receitamedica)) {
            return false;
        }
        Receitamedica other = (Receitamedica) object;
        if ((this.receitamedicaPK == null && other.receitamedicaPK != null) || (this.receitamedicaPK != null && !this.receitamedicaPK.equals(other.receitamedicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Receitamedica[ receitamedicaPK=" + receitamedicaPK + " ]";
    }
    
}
