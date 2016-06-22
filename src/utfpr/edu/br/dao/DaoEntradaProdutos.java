/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;


import utfpr.edu.br.model.EntradaProdutos;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author Magno
 */
public class DaoEntradaProdutos extends DaoGenerics<EntradaProdutos> {

    public DaoEntradaProdutos() {
        super.alvo = EntradaProdutos.class;
    }
    
    

    public EntradaProdutos obterId(Integer id) {
        EntradaProdutos objeto = null;
        if (id != null) {
            objeto = (EntradaProdutos) session.createQuery("From "
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
