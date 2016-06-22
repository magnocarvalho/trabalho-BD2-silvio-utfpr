/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.dao;

import utfpr.edu.br.model.Unidade;

/**
 *
 * @author Magno carvalho
 */
public class DaoUnidade extends DaoGenerics<Unidade>
{
    public DaoUnidade()
    {
        super.alvo = Unidade.class;
    }
    public Unidade obterId(Integer id) {
        Unidade objeto = null;
        if (id != null) {
            objeto = (Unidade) session.createQuery("From "
                    + alvo.getSimpleName()
                    + " where id = '" + id + "'").uniqueResult();
        }
        return objeto;
    }
    
}
