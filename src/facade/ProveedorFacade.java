/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ProveedorJpaController;
import controladores.InventarioJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;

import entidades.inventario.Inventario;
import entidades.proveedor.Proveedor;
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
public class ProveedorFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    ProveedorJpaController proveedorJpaController = new ProveedorJpaController(emf);

    private static ProveedorFacade instance = null;

    protected ProveedorFacade() {
    }

    public static ProveedorFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ProveedorFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(Proveedor proveedor) {
        new ProveedorJpaController(emf).create(proveedor);
    }

    public Proveedor buscar(Long id) {
        return new ProveedorJpaController(emf).findProveedor(id);
    }

    public void modificar(Proveedor proveedor) {
        try {
            new ProveedorJpaController(emf).edit(proveedor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(InventarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InventarioFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new ProveedorJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProveedorFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Proveedor> getTodos() {
        return new ProveedorJpaController(emf).findProveedorEntities();
    }

    public List<Proveedor> buscarPorSucursal(Sucursal sucursal) {
        Query qu = em.createQuery("SELECT i FROM Proveedor i WHERE i.sucursal =:sucursal");
        qu.setParameter("sucursal", sucursal);
        return qu.getResultList();
    }

    public List<Proveedor> listarTodosProveedorOrdenados(Sucursal sucursal) {
        Query quBuscar = em.createQuery("SELECT i FROM Inventario i WHERE i.sucursal =:sucursal ORDER BY i.fecha ASC");
        quBuscar.setParameter("sucursal", sucursal);
        return quBuscar.getResultList();
    }

    public Long buscarUltimoProveedor() {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT MAX(i.id) FROM Proveedor i");
        ema.getEntityManagerFactory().getCache().evictAll();
        return (Long) quBuscar.getSingleResult();
    }

}
