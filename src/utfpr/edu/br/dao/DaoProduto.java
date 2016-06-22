/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import java.util.List;
import org.hibernate.Query;
import utfpr.edu.br.model.Produto;

/**
 *
 * @author Magno carvalho
 */
public class DaoProduto extends DaoGenerics<Produto>
{
    public DaoProduto()
    {
        super.alvo = Produto.class;
    }   
        public List<Produto> obterProduto()
        {
        List<Produto> lista = null;
       

            Query query = session.createQuery("descricao From "
                    + alvo.getSimpleName()
                    );
            lista = query.list();
        
        return lista;
        
        }
}
    

