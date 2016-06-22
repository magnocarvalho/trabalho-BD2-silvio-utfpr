/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import java.util.List;
import org.hibernate.Query;
import utfpr.edu.br.model.MovimentacaoEstoque;

/**
 *
 * @author aluno
 */
public class DaoMovimentacaoEstoque extends DaoGenerics<MovimentacaoEstoque> {

    public DaoMovimentacaoEstoque() {
        super.alvo = MovimentacaoEstoque.class;
    }
    
    

    public MovimentacaoEstoque obterId(Integer id) {
        MovimentacaoEstoque objeto = null;
        if (id != null) {
            objeto = (MovimentacaoEstoque) session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where id = '" + id + "'").uniqueResult();
        }
        return objeto;
    }
    public List<String> obterProduto()
    {
    List<String> lista = null;


        Query query = session.createQuery("From "
                + alvo.getSimpleName()
                );
        lista = query.list();

    return lista;
    }
}
