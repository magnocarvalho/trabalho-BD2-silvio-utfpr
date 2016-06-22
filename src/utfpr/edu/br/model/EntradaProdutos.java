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
@Table(name = "entrada_produtos", catalog = "dbestoque", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaProdutos.findAll", query = "SELECT e FROM EntradaProdutos e"),
    @NamedQuery(name = "EntradaProdutos.findById", query = "SELECT e FROM EntradaProdutos e WHERE e.id = :id"),
    @NamedQuery(name = "EntradaProdutos.findByFkFornecedor", query = "SELECT e FROM EntradaProdutos e WHERE e.fkFornecedor = :fkFornecedor"),
    @NamedQuery(name = "EntradaProdutos.findByData", query = "SELECT e FROM EntradaProdutos e WHERE e.data = :data"),
    @NamedQuery(name = "EntradaProdutos.findByFkProduto", query = "SELECT e FROM EntradaProdutos e WHERE e.fkProduto = :fkProduto"),
    @NamedQuery(name = "EntradaProdutos.findByQuantidde", query = "SELECT e FROM EntradaProdutos e WHERE e.quantidde = :quantidde"),
    @NamedQuery(name = "EntradaProdutos.findByValor", query = "SELECT e FROM EntradaProdutos e WHERE e.valor = :valor")})
public class EntradaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fk_fornecedor", length = 18)
    private String fkFornecedor;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "fk_produto")
    private Integer fkProduto;
    @Column(name = "quantidde")
    private Integer quantidde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor", precision = 2147483647, scale = 0)
    private Double valor;

    public EntradaProdutos() {
    }

    public EntradaProdutos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkFornecedor() {
        return fkFornecedor;
    }

    public void setFkFornecedor(String fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
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

    public Integer getQuantidde() {
        return quantidde;
    }

    public void setQuantidde(Integer quantidde) {
        this.quantidde = quantidde;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        if (!(object instanceof EntradaProdutos)) {
            return false;
        }
        EntradaProdutos other = (EntradaProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.EntradaProdutos[ id=" + id + " ]";
    }
    
}
