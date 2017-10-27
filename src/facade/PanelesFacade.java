/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ArticuloJpaController;
import controladores.PanelesJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Paneles;
import entidades.articulo.Articulo;
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
public class PanelesFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);

    private static PanelesFacade instance = null;

    protected PanelesFacade() {
    }

    public static PanelesFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new PanelesFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(Paneles panel) {
        new PanelesJpaController(emf).create(panel);
    }

    public Paneles buscar(Long id) {
        return new PanelesJpaController(emf).findPaneles(id);
    }

    public void modificar(Paneles panel) {
        try {
            new PanelesJpaController(emf).edit(panel);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PanelesFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelesFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new PanelesJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PanelesFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Paneles> getTodos() {
        EntityManager em = emf.createEntityManager();
        Query qu = em.createQuery("SELECT s FROM Paneles s");
        return qu.getResultList();
    }

    

    }
