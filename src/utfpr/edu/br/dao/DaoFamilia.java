/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utfpr.edu.br.model.Familia;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import utfpr.edu.br.conexao.Conexao;

/**
 *
 * @author Magno
 */
public class DaoFamilia extends DaoGenerics<Familia> {

    public DaoFamilia() {
        super.alvo = Familia.class;
    }
    
    

    public Familia obterId(Integer id) {
        Familia objeto = null;
        if (id != null) {
            objeto = (Familia) session.createQuery("From "
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
