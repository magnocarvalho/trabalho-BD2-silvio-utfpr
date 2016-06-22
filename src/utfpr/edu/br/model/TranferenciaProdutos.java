/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magno
 */
@Entity
@Table(name = "tranferencia_produtos", catalog = "dbestoque", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TranferenciaProdutos.findAll", query = "SELECT t FROM TranferenciaProdutos t"),
    @NamedQuery(name = "TranferenciaProdutos.findById", query = "SELECT t FROM TranferenciaProdutos t WHERE t.id = :id"),
    @NamedQuery(name = "TranferenciaProdutos.findByData", query = "SELECT t FROM TranferenciaProdutos t WHERE t.data = :data"),
    @NamedQuery(name = "TranferenciaProdutos.findByFkProduto", query = "SELECT t FROM TranferenciaProdutos t WHERE t.fkProduto = :fkProduto"),
    @NamedQuery(name = "TranferenciaProdutos.findByQuantidade", query = "SELECT t FROM TranferenciaProdutos t WHERE t.quantidade = :quantidade"),
    @NamedQuery(name = "TranferenciaProdutos.findByFkOrigem", query = "SELECT t FROM TranferenciaProdutos t WHERE t.fkOrigem = :fkOrigem"),
    @NamedQuery(name = "TranferenciaProdutos.findByFkDestino", query = "SELECT t FROM TranferenciaProdutos t WHERE t.fkDestino = :fkDestino")})
public class TranferenciaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "fk_produto")
    private Integer fkProduto;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "fk_origem")
    private Integer fkOrigem;
    @Column(name = "fk_destino")
    private Integer fkDestino;

    public TranferenciaProdutos() {
    }

    public TranferenciaProdutos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Integer fkProduto) {
        this.fkProduto = fkProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getFkOrigem() {
        return fkOrigem;
    }

    public void setFkOrigem(Integer fkOrigem) {
        this.fkOrigem = fkOrigem;
    }

    public Integer getFkDestino() {
        return fkDestino;
    }

    public void setFkDestino(Integer fkDestino) {
        this.fkDestino = fkDestino;
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
        if (!(object instanceof TranferenciaProdutos)) {
            return false;
        }
        TranferenciaProdutos other = (TranferenciaProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.TranferenciaProdutos[ id=" + id + " ]";
    }
    
}
