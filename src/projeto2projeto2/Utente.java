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
@Table(name = "UTENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
    , @NamedQuery(name = "Utente.findByIdAnimal", query = "SELECT u FROM Utente u WHERE u.idAnimal = :idAnimal")
    , @NamedQuery(name = "Utente.findByNomedono", query = "SELECT u FROM Utente u WHERE u.nomedono = :nomedono")
    , @NamedQuery(name = "Utente.findByNomeanimal", query = "SELECT u FROM Utente u WHERE u.nomeanimal = :nomeanimal")
    , @NamedQuery(name = "Utente.findByDatanascimento", query = "SELECT u FROM Utente u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Utente.findByNporta", query = "SELECT u FROM Utente u WHERE u.nporta = :nporta")
    , @NamedQuery(name = "Utente.findByRua", query = "SELECT u FROM Utente u WHERE u.rua = :rua")
    , @NamedQuery(name = "Utente.findByNifdono", query = "SELECT u FROM Utente u WHERE u.nifdono = :nifdono")
    , @NamedQuery(name = "Utente.findByRaca", query = "SELECT u FROM Utente u WHERE u.raca = :raca")
    , @NamedQuery(name = "Utente.findByEspecie", query = "SELECT u FROM Utente u WHERE u.especie = :especie")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ANIMAL")
    private BigDecimal idAnimal;
    @Basic(optional = false)
    @Column(name = "NOMEDONO")
    private String nomedono;
    @Basic(optional = false)
    @Column(name = "NOMEANIMAL")
    private String nomeanimal;
    @Basic(optional = false)
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    @Column(name = "NPORTA")
    private BigInteger nporta;
    @Basic(optional = false)
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NIFDONO")
    private BigInteger nifdono;
    @Basic(optional = false)
    @Column(name = "RACA")
    private String raca;
    @Basic(optional = false)
    @Column(name = "ESPECIE")
    private String especie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnimal")
    private Collection<Pagamento> pagamentoCollection;
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL")
    @ManyToOne(optional = false)
    private Cpostal codpostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnimal")
    private Collection<Consulta> consultaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    private Collection<UtenteMedicamento> utenteMedicamentoCollection;

    public Utente() {
    }

    public Utente(BigDecimal idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Utente(BigDecimal idAnimal, String nomedono, String nomeanimal, Date datanascimento, String rua, String raca, String especie) {
        this.idAnimal = idAnimal;
        this.nomedono = nomedono;
        this.nomeanimal = nomeanimal;
        this.datanascimento = datanascimento;
        this.rua = rua;
        this.raca = raca;
        this.especie = especie;
    }

    public BigDecimal getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(BigDecimal idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomedono() {
        return nomedono;
    }

    public void setNomedono(String nomedono) {
        this.nomedono = nomedono;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public BigInteger getNporta() {
        return nporta;
    }

    public void setNporta(BigInteger nporta) {
        this.nporta = nporta;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public BigInteger getNifdono() {
        return nifdono;
    }

    public void setNifdono(BigInteger nifdono) {
        this.nifdono = nifdono;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    public Cpostal getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Cpostal codpostal) {
        this.codpostal = codpostal;
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
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
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeto2projeto2.Utente[ idAnimal=" + idAnimal + " ]";
    }
    
}
