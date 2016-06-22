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
import utfpr.edu.br.model.EntradaProdutos;

/**
 *
 * @author aluno
 */
public class EntradaProdutosJpaController implements Serializable {

    public EntradaProdutosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EntradaProdutos entradaProdutos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entradaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntradaProdutos(entradaProdutos.getId()) != null) {
                throw new PreexistingEntityException("EntradaProdutos " + entradaProdutos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EntradaProdutos entradaProdutos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entradaProdutos = em.merge(entradaProdutos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entradaProdutos.getId();
                if (findEntradaProdutos(id) == null) {
                    throw new NonexistentEntityException("The entradaProdutos with id " + id + " no longer exists.");
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
            EntradaProdutos entradaProdutos;
            try {
                entradaProdutos = em.getReference(EntradaProdutos.class, id);
                entradaProdutos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entradaProdutos with id " + id + " no longer exists.", enfe);
            }
            em.remove(entradaProdutos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EntradaProdutos> findEntradaProdutosEntities() {
        return findEntradaProdutosEntities(true, -1, -1);
    }

    public List<EntradaProdutos> findEntradaProdutosEntities(int maxResults, int firstResult) {
        return findEntradaProdutosEntities(false, maxResults, firstResult);
    }

    private List<EntradaProdutos> findEntradaProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EntradaProdutos.class));
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

    public EntradaProdutos findEntradaProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EntradaProdutos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntradaProdutosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EntradaProdutos> rt = cq.from(EntradaProdutos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
