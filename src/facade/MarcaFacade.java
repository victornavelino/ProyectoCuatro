/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.MarcaJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.marca.Marca;
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
public class MarcaFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    MarcaJpaController listaPrecioJpaController = new MarcaJpaController(emf);

    private static MarcaFacade instance = null;

    protected MarcaFacade() {
    }

    public static MarcaFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new MarcaFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(Marca listaPrecio) {
        new MarcaJpaController(emf).create(listaPrecio);
    }

    public Marca buscar(Long id) {
        return new MarcaJpaController(emf).findMarca(id);
    }

    public void modificar(Marca listaPrecio) {
        try {
            new MarcaJpaController(emf).edit(listaPrecio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new MarcaJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Marca> getTodos() {
        return new MarcaJpaController(emf).findMarcaEntities();
    }

    public List<Marca> buscarPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM Marca l WHERE l.descripcion LIKE :descripcion");
        qu.setParameter("descripcion", "%" + descripcion + "%");
        return qu.getResultList();
    }

    public Marca getPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM Marca l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (Marca) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public Marca getPorDescripcion(String descripcion, EntityManager ema) {
        Query qu = ema.createQuery("SELECT l FROM Marca l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (Marca) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean getExisteDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM Marca l WHERE l.descripcion=:descripcion");
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
