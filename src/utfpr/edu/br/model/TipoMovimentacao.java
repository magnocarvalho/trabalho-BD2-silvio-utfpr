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
@Table(name = "tipo_movimentacao", catalog = "dbestoque", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimentacao.findAll", query = "SELECT t FROM TipoMovimentacao t"),
    @NamedQuery(name = "TipoMovimentacao.findById", query = "SELECT t FROM TipoMovimentacao t WHERE t.id = :id"),
    @NamedQuery(name = "TipoMovimentacao.findByTipo", query = "SELECT t FROM TipoMovimentacao t WHERE t.tipo = :tipo")})
public class TipoMovimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "tipo", length = 20)
    private String tipo;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof TipoMovimentacao)) {
            return false;
        }
        TipoMovimentacao other = (TipoMovimentacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.model.TipoMovimentacao[ id=" + id + " ]";
    }
    
}
