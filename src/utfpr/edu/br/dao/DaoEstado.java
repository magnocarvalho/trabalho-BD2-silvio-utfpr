/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import utfpr.edu.br.model.Estado;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Magno
 */
public class DaoEstado extends DaoGenerics<Estado> {

    public DaoEstado() {
        super.alvo = Estado.class;
    }
    
    

    public Estado obterId(Integer id) {
        Estado objeto = null;
        if (id != null) {
            objeto = (Estado) session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where id = '" + id + "'").uniqueResult();
        }
        return objeto;
    }
}
