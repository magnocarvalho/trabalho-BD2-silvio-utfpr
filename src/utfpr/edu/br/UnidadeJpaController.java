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
import utfpr.edu.br.model.Unidade;

/**
 *
 * @author aluno
 */
public class UnidadeJpaController implements Serializable {

    public UnidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Unidade unidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(unidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUnidade(unidade.getId()) != null) {
                throw new PreexistingEntityException("Unidade " + unidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Unidade unidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            unidade = em.merge(unidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = unidade.getId();
                if (findUnidade(id) == null) {
                    throw new NonexistentEntityException("The unidade with id " + id + " no longer exists.");
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
            Unidade unidade;
            try {
                unidade = em.getReference(Unidade.class, id);
                unidade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidade with id " + id + " no longer exists.", enfe);
            }
            em.remove(unidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Unidade> findUnidadeEntities() {
        return findUnidadeEntities(true, -1, -1);
    }

    public List<Unidade> findUnidadeEntities(int maxResults, int firstResult) {
        return findUnidadeEntities(false, maxResults, firstResult);
    }

    private List<Unidade> findUnidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Unidade.class));
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

    public Unidade findUnidade(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Unidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Unidade> rt = cq.from(Unidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
