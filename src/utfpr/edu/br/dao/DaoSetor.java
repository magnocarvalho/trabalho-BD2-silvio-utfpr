/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import utfpr.edu.br.model.Setor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Magno
 */
public class DaoSetor extends DaoGenerics<Setor> {

    public DaoSetor() {
        super.alvo = Setor.class;
    }

    public List<Setor> obterNome(String descricao) {
        List<Setor> lista = null;
        if (descricao != null || !"".equals(descricao)) {

            Query query = session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where descricao LIKE '%"
                    + descricao + "%'");
            lista = query.list();
        }
        return lista;
    }
   
}
