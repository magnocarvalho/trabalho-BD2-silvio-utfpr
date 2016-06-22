/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByRazaoSocial", query = "SELECT f FROM Fornecedor f WHERE f.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Fornecedor.findByLogradouro", query = "SELECT f FROM Fornecedor f WHERE f.logradouro = :logradouro"),
    @NamedQuery(name = "Fornecedor.findByNumero", query = "SELECT f FROM Fornecedor f WHERE f.numero = :numero"),
    @NamedQuery(name = "Fornecedor.findByCep", query = "SELECT f FROM Fornecedor f WHERE f.cep = :cep"),
    @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Fornecedor.findByCidade", query = "SELECT f FROM Fornecedor f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Fornecedor.findByFkEstado", query = "SELECT f FROM Fornecedor f WHERE f.fkEstado = :fkEstado"),
    @NamedQuery(name = "Fornecedor.findByRegistro", query = "SELECT f FROM Fornecedor f WHERE f.registro = :registro"),
    @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT f FROM Fornecedor f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedor.findById", query = "SELECT f FROM Fornecedor f WHERE f.id = :id")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "cep")
    private String cep;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "fk_estado")
    private Integer fkEstado;
    @Column(name = "registro")
    private Boolean registro;
    @Column(name = "telefone")
    private String telefone;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Fornecedor() {
    }

    public Fornecedor(Integer id) {
        this.id = id;
    }

    public Fornecedor(Integer id, String cnpj) {
        this.id = id;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(Integer fkEstado) {
        this.fkEstado = fkEstado;
    }

    public Boolean getRegistro() {
        return registro;
    }

    public void setRegistro(Boolean registro) {
        this.registro = registro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.Fornecedor[ id=" + id + " ]";
    }
    
}
