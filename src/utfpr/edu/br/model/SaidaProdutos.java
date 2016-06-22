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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magno
 */
@Entity
@Table(name = "saida_produtos", catalog = "dbestoque", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaidaProdutos.findAll", query = "SELECT s FROM SaidaProdutos s"),
    @NamedQuery(name = "SaidaProdutos.findById", query = "SELECT s FROM SaidaProdutos s WHERE s.id = :id"),
    @NamedQuery(name = "SaidaProdutos.findByData", query = "SELECT s FROM SaidaProdutos s WHERE s.data = :data"),
    @NamedQuery(name = "SaidaProdutos.findByFkSetor", query = "SELECT s FROM SaidaProdutos s WHERE s.fkSetor = :fkSetor"),
    @NamedQuery(name = "SaidaProdutos.findByFkProduto", query = "SELECT s FROM SaidaProdutos s WHERE s.fkProduto = :fkProduto"),
    @NamedQuery(name = "SaidaProdutos.findByQuantidade", query = "SELECT s FROM SaidaProdutos s WHERE s.quantidade = :quantidade")})
public class SaidaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "data")
    private Serializable data;
    @Column(name = "fk_setor")
    private Integer fkSetor;
    @Column(name = "fk_produto")
    private Integer fkProduto;
    @Column(name = "quantidade")
    private Integer quantidade;

    public SaidaProdutos() {
    }

    public SaidaProdutos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public Integer getFkSetor() {
        return fkSetor;
    }

    public void setFkSetor(Integer fkSetor) {
        this.fkSetor = fkSetor;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaidaProdutos)) {
            return false;
        }
        SaidaProdutos other = (SaidaProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.SaidaProdutos[ id=" + id + " ]";
    }
    
}
