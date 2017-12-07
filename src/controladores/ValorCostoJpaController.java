/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.costo.ValorCosto;
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
public class ValorCostoJpaController implements Serializable {

    public ValorCostoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ValorCosto valorCosto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(valorCosto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ValorCosto valorCosto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            valorCosto = em.merge(valorCosto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = valorCosto.getId();
                if (findValorCosto(id) == null) {
                    throw new NonexistentEntityException("The valorCosto with id " + id + " no longer exists.");
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
            ValorCosto valorCosto;
            try {
                valorCosto = em.getReference(ValorCosto.class, id);
                valorCosto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The valorCosto with id " + id + " no longer exists.", enfe);
            }
            em.remove(valorCosto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ValorCosto> findValorCostoEntities() {
        return findValorCostoEntities(true, -1, -1);
    }

    public List<ValorCosto> findValorCostoEntities(int maxResults, int firstResult) {
        return findValorCostoEntities(false, maxResults, firstResult);
    }

    private List<ValorCosto> findValorCostoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ValorCosto.class));
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

    public ValorCosto findValorCosto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ValorCosto.class, id);
        } finally {
            em.close();
        }
    }

    public int getValorCostoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ValorCosto> rt = cq.from(ValorCosto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
