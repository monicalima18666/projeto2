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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CONSULTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")
    , @NamedQuery(name = "Consulta.findByIdConsulta", query = "SELECT c FROM Consulta c WHERE c.idConsulta = :idConsulta")
    , @NamedQuery(name = "Consulta.findByDatainicio", query = "SELECT c FROM Consulta c WHERE c.datainicio = :datainicio")
    , @NamedQuery(name = "Consulta.findByDatafim", query = "SELECT c FROM Consulta c WHERE c.datafim = :datafim")
    , @NamedQuery(name = "Consulta.findByNconsultorio", query = "SELECT c FROM Consulta c WHERE c.nconsultorio = :nconsultorio")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONSULTA")
    private BigDecimal idConsulta;
    @Basic(optional = false)
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Basic(optional = false)
    @Column(name = "DATAFIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Basic(optional = false)
    @Column(name = "NCONSULTORIO")
    private BigInteger nconsultorio;
    @JoinTable(name = "CONSULTA_EXAME", joinColumns = {
        @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA")}, inverseJoinColumns = {
        @JoinColumn(name = "NUMEXAME", referencedColumnName = "NUMEXAME")})
    @ManyToMany
    private Collection<Exame> exameCollection;
    @JoinTable(name = "CONSULTA_TRATAMENTO", joinColumns = {
        @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TRATAMENTO", referencedColumnName = "ID_TRATAMENTO")})
    @ManyToMany
    private Collection<Tratamento> tratamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
    private Collection<Receitamedica> receitamedicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsulta")
    private Collection<Pagamento> pagamentoCollection;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "ID_MEDICO", referencedColumnName = "ID_MEDICO")
    @ManyToOne(optional = false)
    private Medico idMedico;
    @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL")
    @ManyToOne(optional = false)
    private Utente idAnimal;

    public Consulta() {
    }

    public Consulta(BigDecimal idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consulta(BigDecimal idConsulta, Date datainicio, Date datafim, BigInteger nconsultorio) {
        this.idConsulta = idConsulta;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.nconsultorio = nconsultorio;
    }

    public BigDecimal getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(BigDecimal idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public BigInteger getNconsultorio() {
        return nconsultorio;
    }

    public void setNconsultorio(BigInteger nconsultorio) {
        this.nconsultorio = nconsultorio;
    }

    @XmlTransient
    public Collection<Exame> getExameCollection() {
        return exameCollection;
    }

    public void setExameCollection(Collection<Exame> exameCollection) {
        this.exameCollection = exameCollection;
    }

    @XmlTransient
    public Collection<Tratamento> getTratamentoCollection() {
        return tratamentoCollection;
    }

    public void setTratamentoCollection(Collection<Tratamento> tratamentoCollection) {
        this.tratamentoCollection = tratamentoCollection;
    }

    @XmlTransient
    public Collection<Receitamedica> getReceitamedicaCollection() {
        return receitamedicaCollection;
    }

    public void setReceitamedicaCollection(Collection<Receitamedica> receitamedicaCollection) {
        this.receitamedicaCollection = receitamedicaCollection;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
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
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Consulta[ idConsulta=" + idConsulta + " ]";
    }
    
}
