/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;


import java.util.List;
import org.hibernate.Query;
import utfpr.edu.br.model.Fornecedor;
/**
 *
 * @author Magno
 */
public class DaoFornecedor extends DaoGenerics<Fornecedor> {

    public DaoFornecedor() {
        super.alvo = Fornecedor.class;
    }

    public List<Fornecedor> obterNome(String descricao) {
        List<Fornecedor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where razao_social LIKE '%"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
    public List<Fornecedor> obterCnpj(String descricao) {
        List<Fornecedor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where cnpj LIKE '"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
   
}

