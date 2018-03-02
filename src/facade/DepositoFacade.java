/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.DepositoJpaController;
import controladores.InventarioJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.stock.Deposito;
import entidades.inventario.Inventario;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class DepositoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    DepositoJpaController depositoJpaController = new DepositoJpaController(emf);

    private static DepositoFacade instance = null;

    protected DepositoFacade() {
    }

    public static DepositoFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new DepositoFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(Deposito deposito) {
        new DepositoJpaController(emf).create(deposito);
    }

    public Deposito buscar(Long id) {
        return new DepositoJpaController(emf).findDeposito(id);
    }

    public void modificar(Deposito deposito) {
        try {
            new DepositoJpaController(emf).edit(deposito);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(InventarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InventarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new DepositoJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DepositoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Deposito> getTodos() {
        return new DepositoJpaController(emf).findDepositoEntities();
    }

    public List<Deposito> buscarPorSucursal(Sucursal sucursal) {
        Query qu = em.createQuery("SELECT i FROM Deposito i WHERE i.sucursal =:sucursal");
        qu.setParameter("sucursal", sucursal);
        return qu.getResultList();
    }

    public List<Deposito> listarTodosDepositoOrdenados(Sucursal sucursal) {
        Query quBuscar = em.createQuery("SELECT i FROM Inventario i WHERE i.sucursal =:sucursal ORDER BY i.fecha ASC");
        quBuscar.setParameter("sucursal", sucursal);
        return quBuscar.getResultList();
    }

    public Long buscarUltimoDeposito() {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT MAX(i.id) FROM Deposito i");
        ema.getEntityManagerFactory().getCache().evictAll();
        return (Long) quBuscar.getSingleResult();
    }

}
