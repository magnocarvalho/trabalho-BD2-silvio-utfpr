/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import utfpr.edu.br.exceptions.NonexistentEntityException;
import utfpr.edu.br.exceptions.PreexistingEntityException;
import utfpr.edu.br.model.TipoMovimentacao;

/**
 *
 * @author aluno
 */
public class TipoMovimentacaoJpaController implements Serializable {

    public TipoMovimentacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoMovimentacao tipoMovimentacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoMovimentacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoMovimentacao(tipoMovimentacao.getId()) != null) {
                throw new PreexistingEntityException("TipoMovimentacao " + tipoMovimentacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoMovimentacao tipoMovimentacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoMovimentacao = em.merge(tipoMovimentacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoMovimentacao.getId();
                if (findTipoMovimentacao(id) == null) {
                    throw new NonexistentEntityException("The tipoMovimentacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoMovimentacao tipoMovimentacao;
            try {
                tipoMovimentacao = em.getReference(TipoMovimentacao.class, id);
                tipoMovimentacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoMovimentacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoMovimentacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoMovimentacao> findTipoMovimentacaoEntities() {
        return findTipoMovimentacaoEntities(true, -1, -1);
    }

    public List<TipoMovimentacao> findTipoMovimentacaoEntities(int maxResults, int firstResult) {
        return findTipoMovimentacaoEntities(false, maxResults, firstResult);
    }

    private List<TipoMovimentacao> findTipoMovimentacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoMovimentacao.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoMovimentacao findTipoMovimentacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoMovimentacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoMovimentacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoMovimentacao> rt = cq.from(TipoMovimentacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
