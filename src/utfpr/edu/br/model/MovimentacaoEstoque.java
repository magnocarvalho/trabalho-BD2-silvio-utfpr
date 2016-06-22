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
@Table(name = "movimentacao_estoque", catalog = "dbestoque", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentacaoEstoque.findAll", query = "SELECT m FROM MovimentacaoEstoque m"),
    @NamedQuery(name = "MovimentacaoEstoque.findById", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.id = :id"),
    @NamedQuery(name = "MovimentacaoEstoque.findByFkSetor", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.fkSetor = :fkSetor"),
    @NamedQuery(name = "MovimentacaoEstoque.findByOperacao", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.operacao = :operacao"),
    @NamedQuery(name = "MovimentacaoEstoque.findByDt", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.dt = :dt"),
    @NamedQuery(name = "MovimentacaoEstoque.findByFkProduto", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.fkProduto = :fkProduto"),
    @NamedQuery(name = "MovimentacaoEstoque.findByQuantidade", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "MovimentacaoEstoque.findByFkTipo", query = "SELECT m FROM MovimentacaoEstoque m WHERE m.fkTipo = :fkTipo")})
public class MovimentacaoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fk_setor")
    private Integer fkSetor;
    @Column(name = "operacao")
    private Boolean operacao;
    @Column(name = "dt")
    private Serializable dt;
    @Column(name = "fk_produto")
    private Integer fkProduto;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "fk_tipo")
    private Integer fkTipo;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkSetor() {
        return fkSetor;
    }

    public void setFkSetor(Integer fkSetor) {
        this.fkSetor = fkSetor;
    }

    public Boolean getOperacao() {
        return operacao;
    }

    public void setOperacao(Boolean operacao) {
        this.operacao = operacao;
    }

    public Serializable getDt() {
        return dt;
    }

    public void setDt(Serializable dt) {
        this.dt = dt;
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

    public Integer getFkTipo() {
        return fkTipo;
    }

    public void setFkTipo(Integer fkTipo) {
        this.fkTipo = fkTipo;
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
        if (!(object instanceof MovimentacaoEstoque)) {
            return false;
        }
        MovimentacaoEstoque other = (MovimentacaoEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.MovimentacaoEstoque[ id=" + id + " ]";
    }
    
}
