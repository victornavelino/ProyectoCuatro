/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ValorCostoJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.articulo.costo.ListaCosto;
import entidades.articulo.costo.ValorCosto;
import static entidades.articulo.costo.ValorCosto_.listaCosto;
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
public class ValorCostoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    ValorCostoJpaController listaPrecioJpaController = new ValorCostoJpaController(emf);

    private static ValorCostoFacade instance = null;

    protected ValorCostoFacade() {
    }

    public static ValorCostoFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ValorCostoFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(ValorCosto listaPrecio) {
        new ValorCostoJpaController(emf).create(listaPrecio);
    }

    public ValorCosto buscar(Long id) {
        return new ValorCostoJpaController(emf).findValorCosto(id);
    }

    public void modificar(ValorCosto listaPrecio) {
        try {
            new ValorCostoJpaController(emf).edit(listaPrecio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ValorCosto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ValorCosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new ValorCostoJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ValorCosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ValorCosto> getTodos() {
        return new ValorCostoJpaController(emf).findValorCostoEntities();
    }

    public List<ValorCosto> buscarPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ValorCosto l WHERE l.descripcion LIKE :descripcion");
        qu.setParameter("descripcion", "%" + descripcion + "%");
        return qu.getResultList();
    }
    public List<ValorCosto> buscarPorid(ListaCosto valor) {
        Query qu = em.createQuery("SELECT l FROM ValorCosto l WHERE l.listaCosto =:valor");
        qu.setParameter("valor",valor);
        return qu.getResultList();
    }


    public List<ValorCosto> todosOrderByDescripcion (){
        Query qu = em.createQuery("SELECT l FROM ValorCosto l ORDER BY l.descripcion");
        
        return qu.getResultList();
    }
     public List<ValorCosto> todosOrderByListaCosto (){
        Query qu = em.createQuery("SELECT l FROM ValorCosto l ORDER BY l.listaCosto");
        
        return qu.getResultList();
    }
    public ValorCosto getPorDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ValorCosto l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (ValorCosto) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public ValorCosto getPorDescripcion(String descripcion, EntityManager ema) {
        Query qu = ema.createQuery("SELECT l FROM ValorCosto l WHERE l.descripcion=:descripcion");
        qu.setParameter("descripcion", descripcion);
        try {
            return (ValorCosto) qu.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean getExisteDescripcion(String descripcion) {
        Query qu = em.createQuery("SELECT l FROM ValorCosto l WHERE l.descripcion=:descripcion");
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
