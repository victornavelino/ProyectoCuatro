/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.stock.ArticuloDeposito;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author franco
 */
public class ArticuloDepositoJpaController implements Serializable {

    public ArticuloDepositoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArticuloDeposito articuloDeposito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(articuloDeposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArticuloDeposito articuloDeposito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            articuloDeposito = em.merge(articuloDeposito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = articuloDeposito.getId();
                if (findArticuloDeposito(id) == null) {
                    throw new NonexistentEntityException("The articuloDeposito with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArticuloDeposito articuloDeposito;
            try {
                articuloDeposito = em.getReference(ArticuloDeposito.class, id);
                articuloDeposito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articuloDeposito with id " + id + " no longer exists.", enfe);
            }
            em.remove(articuloDeposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArticuloDeposito> findArticuloDepositoEntities() {
        return findArticuloDepositoEntities(true, -1, -1);
    }

    public List<ArticuloDeposito> findArticuloDepositoEntities(int maxResults, int firstResult) {
        return findArticuloDepositoEntities(false, maxResults, firstResult);
    }

    private List<ArticuloDeposito> findArticuloDepositoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArticuloDeposito.class));
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

    public ArticuloDeposito findArticuloDeposito(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArticuloDeposito.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloDepositoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArticuloDeposito> rt = cq.from(ArticuloDeposito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
