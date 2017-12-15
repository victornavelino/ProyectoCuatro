/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.stock.ArticuloSucursal;
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
public class ArticuloSucursalJpaController implements Serializable {

    public ArticuloSucursalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArticuloSucursal articuloSucursal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(articuloSucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArticuloSucursal articuloSucursal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            articuloSucursal = em.merge(articuloSucursal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = articuloSucursal.getId();
                if (findArticuloSucursal(id) == null) {
                    throw new NonexistentEntityException("The articuloSucursal with id " + id + " no longer exists.");
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
            ArticuloSucursal articuloSucursal;
            try {
                articuloSucursal = em.getReference(ArticuloSucursal.class, id);
                articuloSucursal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articuloSucursal with id " + id + " no longer exists.", enfe);
            }
            em.remove(articuloSucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArticuloSucursal> findArticuloSucursalEntities() {
        return findArticuloSucursalEntities(true, -1, -1);
    }

    public List<ArticuloSucursal> findArticuloSucursalEntities(int maxResults, int firstResult) {
        return findArticuloSucursalEntities(false, maxResults, firstResult);
    }

    private List<ArticuloSucursal> findArticuloSucursalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArticuloSucursal.class));
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

    public ArticuloSucursal findArticuloSucursal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArticuloSucursal.class, id);
        } finally {
            em.close();
        }
    }

    public int getArticuloSucursalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArticuloSucursal> rt = cq.from(ArticuloSucursal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
