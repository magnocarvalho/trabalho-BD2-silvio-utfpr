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
import utfpr.edu.br.model.SaidaProdutos;

/**
 *
 * @author aluno
 */
public class SaidaProdutosJpaController implements Serializable {

    public SaidaProdutosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SaidaProdutos saidaProdutos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(saidaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSaidaProdutos(saidaProdutos.getId()) != null) {
                throw new PreexistingEntityException("SaidaProdutos " + saidaProdutos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SaidaProdutos saidaProdutos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            saidaProdutos = em.merge(saidaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = saidaProdutos.getId();
                if (findSaidaProdutos(id) == null) {
                    throw new NonexistentEntityException("The saidaProdutos with id " + id + " no longer exists.");
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
            SaidaProdutos saidaProdutos;
            try {
                saidaProdutos = em.getReference(SaidaProdutos.class, id);
                saidaProdutos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The saidaProdutos with id " + id + " no longer exists.", enfe);
            }
            em.remove(saidaProdutos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SaidaProdutos> findSaidaProdutosEntities() {
        return findSaidaProdutosEntities(true, -1, -1);
    }

    public List<SaidaProdutos> findSaidaProdutosEntities(int maxResults, int firstResult) {
        return findSaidaProdutosEntities(false, maxResults, firstResult);
    }

    private List<SaidaProdutos> findSaidaProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SaidaProdutos.class));
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

    public SaidaProdutos findSaidaProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SaidaProdutos.class, id);
        } finally {
            em.close();
        }
    }

    public int getSaidaProdutosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SaidaProdutos> rt = cq.from(SaidaProdutos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
