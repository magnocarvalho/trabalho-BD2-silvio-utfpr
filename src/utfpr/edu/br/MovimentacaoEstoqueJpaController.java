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
import utfpr.edu.br.model.MovimentacaoEstoque;

/**
 *
 * @author aluno
 */
public class MovimentacaoEstoqueJpaController implements Serializable {

    public MovimentacaoEstoqueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MovimentacaoEstoque movimentacaoEstoque) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimentacaoEstoque);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentacaoEstoque(movimentacaoEstoque.getId()) != null) {
                throw new PreexistingEntityException("MovimentacaoEstoque " + movimentacaoEstoque + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MovimentacaoEstoque movimentacaoEstoque) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimentacaoEstoque = em.merge(movimentacaoEstoque);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movimentacaoEstoque.getId();
                if (findMovimentacaoEstoque(id) == null) {
                    throw new NonexistentEntityException("The movimentacaoEstoque with id " + id + " no longer exists.");
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
            MovimentacaoEstoque movimentacaoEstoque;
            try {
                movimentacaoEstoque = em.getReference(MovimentacaoEstoque.class, id);
                movimentacaoEstoque.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentacaoEstoque with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimentacaoEstoque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MovimentacaoEstoque> findMovimentacaoEstoqueEntities() {
        return findMovimentacaoEstoqueEntities(true, -1, -1);
    }

    public List<MovimentacaoEstoque> findMovimentacaoEstoqueEntities(int maxResults, int firstResult) {
        return findMovimentacaoEstoqueEntities(false, maxResults, firstResult);
    }

    private List<MovimentacaoEstoque> findMovimentacaoEstoqueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MovimentacaoEstoque.class));
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

    public MovimentacaoEstoque findMovimentacaoEstoque(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MovimentacaoEstoque.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentacaoEstoqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MovimentacaoEstoque> rt = cq.from(MovimentacaoEstoque.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
