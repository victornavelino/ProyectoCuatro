/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.costo.ListaCosto;
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
public class ListaCostoJpaController implements Serializable {

    public ListaCostoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ListaCosto listaCosto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listaCosto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ListaCosto listaCosto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listaCosto = em.merge(listaCosto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = listaCosto.getId();
                if (findListaCosto(id) == null) {
                    throw new NonexistentEntityException("The listaCosto with id " + id + " no longer exists.");
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
            ListaCosto listaCosto;
            try {
                listaCosto = em.getReference(ListaCosto.class, id);
                listaCosto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listaCosto with id " + id + " no longer exists.", enfe);
            }
            em.remove(listaCosto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ListaCosto> findListaCostoEntities() {
        return findListaCostoEntities(true, -1, -1);
    }

    public List<ListaCosto> findListaCostoEntities(int maxResults, int firstResult) {
        return findListaCostoEntities(false, maxResults, firstResult);
    }

    private List<ListaCosto> findListaCostoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ListaCosto.class));
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

    public ListaCosto findListaCosto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ListaCosto.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaCostoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ListaCosto> rt = cq.from(ListaCosto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
