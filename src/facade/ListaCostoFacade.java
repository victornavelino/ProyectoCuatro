/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ListaCostoJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.costo.ListaCosto;
import entidades.articulo.PrecioArticulo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
public class ListaCostoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    ListaCostoJpaController listaPrecioJpaController = new ListaCostoJpaController(emf);

    private static ListaCostoFacade instance = null;

    protected ListaCostoFacade() {
    }

    public static ListaCostoFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ListaCostoFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(ListaCosto listaPrecio) {
        new ListaCostoJpaController(emf).create(listaPrecio);
    }

    public ListaCosto buscar(Long id) {
        return new ListaCostoJpaController(emf).findListaCosto(id);
    }

    public void modificar(ListaCosto listaPrecio) {
        try {
            new ListaCostoJpaController(emf).edit(listaPrecio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ListaCostoFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ListaCostoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new ListaCostoJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ListaCostoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ListaCosto> getTodos() {
        return new ListaCostoJpaController(emf).findListaCostoEntities();
    }

    public List<ListaCosto> buscarPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ListaCosto l WHERE l.descripcion LIKE :descripcion");
        qu.setParameter("descripcion", "%" + descripcion + "%");
        return qu.getResultList();
    }

    public ListaCosto getPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ListaCosto l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (ListaCosto) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public ListaCosto getPorDescripcion(String descripcion, EntityManager ema) {
        Query qu = ema.createQuery("SELECT l FROM ListaCosto l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (ListaCosto) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean getExisteDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ListaCosto l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            if (qu.getSingleResult() != null) {
            }
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }


}
