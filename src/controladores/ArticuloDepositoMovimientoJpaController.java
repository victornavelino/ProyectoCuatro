/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.stock.ArticuloDepositoMovimiento;
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
 * @author alumno
 */
public class ArticuloDepositoMovimientoJpaController implements Serializable {

    public ArticuloDepositoMovimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArticuloDepositoMovimiento articuloDepositoMovimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(articuloDepositoMovimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArticuloDepositoMovimiento articuloDepositoMovimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            articuloDepositoMovimiento = em.merge(articuloDepositoMovimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = articuloDepositoMovimiento.getId();
                if (findArticuloDepositoMovimiento(id) == null) {
                    throw new NonexistentEntityException("The articuloDepositoMovimiento with id " + id + " no longer exists.");
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
            ArticuloDepositoMovimiento articuloDepositoMovimiento;
            try {
                articuloDepositoMovimiento = em.getReference(ArticuloDepositoMovimiento.class, id);
                articuloDepositoMovimiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articuloDepositoMovimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(articuloDepositoMovimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArticuloDepositoMovimiento> findArticuloDepositoMovimientoEntities() {
        return findArticuloDepositoMovimientoEntities(true, -1, -1);
    }

    public List<ArticuloDepositoMovimiento> findArticuloDepositoMovimientoEntities(int maxResults, int firstResult) {
        return findArticuloDepositoMovimientoEntities(false, maxResults, firstResult);
    }

    private List<ArticuloDepositoMovimiento> findArticuloDepositoMovimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArticuloDepositoMovimiento.class));
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

    public ArticuloDepositoMovimiento findArticuloDepositoMovimiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArticuloDepositoMovimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloDepositoMovimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArticuloDepositoMovimiento> rt = cq.from(ArticuloDepositoMovimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
