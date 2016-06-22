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
import utfpr.edu.br.model.TranferenciaProdutos;

/**
 *
 * @author aluno
 */
public class TranferenciaProdutosJpaController implements Serializable {

    public TranferenciaProdutosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TranferenciaProdutos tranferenciaProdutos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tranferenciaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTranferenciaProdutos(tranferenciaProdutos.getId()) != null) {
                throw new PreexistingEntityException("TranferenciaProdutos " + tranferenciaProdutos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TranferenciaProdutos tranferenciaProdutos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tranferenciaProdutos = em.merge(tranferenciaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tranferenciaProdutos.getId();
                if (findTranferenciaProdutos(id) == null) {
                    throw new NonexistentEntityException("The tranferenciaProdutos with id " + id + " no longer exists.");
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
            TranferenciaProdutos tranferenciaProdutos;
            try {
                tranferenciaProdutos = em.getReference(TranferenciaProdutos.class, id);
                tranferenciaProdutos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tranferenciaProdutos with id " + id + " no longer exists.", enfe);
            }
            em.remove(tranferenciaProdutos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TranferenciaProdutos> findTranferenciaProdutosEntities() {
        return findTranferenciaProdutosEntities(true, -1, -1);
    }

    public List<TranferenciaProdutos> findTranferenciaProdutosEntities(int maxResults, int firstResult) {
        return findTranferenciaProdutosEntities(false, maxResults, firstResult);
    }

    private List<TranferenciaProdutos> findTranferenciaProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TranferenciaProdutos.class));
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

    public TranferenciaProdutos findTranferenciaProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TranferenciaProdutos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTranferenciaProdutosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TranferenciaProdutos> rt = cq.from(TranferenciaProdutos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
