/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author aluno
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByPesoBruto", query = "SELECT p FROM Produto p WHERE p.pesoBruto = :pesoBruto"),
    @NamedQuery(name = "Produto.findByPesoLiquido", query = "SELECT p FROM Produto p WHERE p.pesoLiquido = :pesoLiquido"),
    @NamedQuery(name = "Produto.findByFkFamilia", query = "SELECT p FROM Produto p WHERE p.fkFamilia = :fkFamilia"),
    @NamedQuery(name = "Produto.findByEstoqueMinino", query = "SELECT p FROM Produto p WHERE p.estoqueMinino = :estoqueMinino"),
    @NamedQuery(name = "Produto.findByFkUnidade", query = "SELECT p FROM Produto p WHERE p.fkUnidade = :fkUnidade"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByCodigoBarras", query = "SELECT p FROM Produto p WHERE p.codigoBarras = :codigoBarras")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_bruto")
    private BigDecimal pesoBruto;
    @Column(name = "peso_liquido")
    private BigDecimal pesoLiquido;
    @Column(name = "fk_familia")
    private Integer fkFamilia;
    @Column(name = "estoque_minino")
    private Integer estoqueMinino;
    @Column(name = "fk_unidade")
    private Integer fkUnidade;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "codigo_barras")
    private String codigoBarras;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Integer getFkFamilia() {
        return fkFamilia;
    }

    public void setFkFamilia(Integer fkFamilia) {
        this.fkFamilia = fkFamilia;
    }

    public Integer getEstoqueMinino() {
        return estoqueMinino;
    }

    public void setEstoqueMinino(Integer estoqueMinino) {
        this.estoqueMinino = estoqueMinino;
    }

    public Integer getFkUnidade() {
        return fkUnidade;
    }

    public void setFkUnidade(Integer fkUnidade) {
        this.fkUnidade = fkUnidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.Produto[ id=" + id + " ]";
    }
    
}
