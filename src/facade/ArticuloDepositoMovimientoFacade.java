/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ArticuloDepositoJpaController;
import controladores.ArticuloDepositoMovimientoJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.stock.ArticuloDeposito;
import entidades.articulo.stock.ArticuloDepositoMovimiento;
import entidades.articulo.stock.ArticuloSucursal;
import entidades.articulo.stock.Deposito;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author franco
 */
public class ArticuloDepositoMovimientoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);

    ArticuloDepositoMovimientoJpaController articuloDepositoJpa = new ArticuloDepositoMovimientoJpaController(emf);

    Query quArticuloDepositoMovimiento;
    List listArticuloDepositoMovimiento;

     private static ArticuloDepositoMovimientoFacade instance = null;

    protected ArticuloDepositoMovimientoFacade() {
    }

    public static ArticuloDepositoMovimientoFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ArticuloDepositoMovimientoFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

      public List<ArticuloDeposito> getTodos() {
        return new ArticuloDepositoJpaController(emf).findArticuloDepositoEntities();
    }
    
    public void alta(ArticuloDepositoMovimiento articuloDeposito) {
        articuloDepositoJpa.create(articuloDeposito);
    }

    public void modificar(ArticuloDepositoMovimiento articuloDeposito) {
        try {
            articuloDepositoJpa.edit(articuloDeposito);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloDepositoMovimientoFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDepositoMovimientoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Long id) {
        try {
            articuloDepositoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloDepositoMovimientoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArticuloDepositoMovimiento buscar(long id) {
        return articuloDepositoJpa.findArticuloDepositoMovimiento(id);
    }

    public ArticuloDepositoMovimiento buscar(Articulo articulo, Deposito deposito) {

        
        EntityManager em = emf.createEntityManager();
        ArticuloDeposito articuloDeposito = new ArticuloDeposito();
        quArticuloDepositoMovimiento = em.createQuery("SELECT ad FROM ArticuloDeposito ad WHERE ad.articulo = :articulo AND ad.deposito = :deposito");
        quArticuloDepositoMovimiento.setParameter("articulo", articulo);
        quArticuloDepositoMovimiento.setParameter("deposito", deposito);

        //ArticuloDeposito articuloDeposito= new ArticuloDeposito();
         //articuloDeposito = (ArticuloDeposito) qu.getSingleResult();

       
         
         try {
            return (ArticuloDepositoMovimiento) quArticuloDepositoMovimiento.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
       
    }

    public void agregarArticulosAlDeposito(ArticuloDepositoMovimiento articuloDeposito) {
        ArticuloDepositoMovimiento articuloDepositoCompleto = buscar(articuloDeposito.getArticulo(), articuloDeposito.getDeposito());
        if (articuloDepositoCompleto != null) {
            articuloDepositoCompleto.setCantidad(articuloDepositoCompleto.getCantidad() + articuloDeposito.getCantidad());
            modificar(articuloDepositoCompleto);
        } else {
            alta(articuloDeposito);
        }
        JOptionPane.showMessageDialog(null, "Se agregaron "
                + articuloDeposito.getCantidad() + " " + articuloDeposito.getArticulo()
                + " a " + articuloDeposito.getDeposito().getDescripcion());
    }

    public void agregarArticulosAlDeposito(Articulo articulo, Deposito deposito, Long cantidad) {
        ArticuloDepositoMovimiento articuloDepositoCompleto = buscar(articulo, deposito);
        if (articuloDepositoCompleto != null) {
            articuloDepositoCompleto.setCantidad(articuloDepositoCompleto.getCantidad() + cantidad);
        } else {
            ArticuloDepositoMovimiento articuloDeposito = new ArticuloDepositoMovimiento();
            articuloDeposito.setArticulo(articulo);
            articuloDeposito.setCantidad(cantidad);
            articuloDeposito.setDeposito(deposito);
            alta(articuloDeposito);
        }
    }
     public int getUltimoNumeroLote() {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU",ConexionFacade.PROPIEDADES);
        //EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoDosPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT MAX(a.numero) FROM ArticuloDepositoMovimiento a");
        quBuscar.setMaxResults(1);
        try {
            return (int) quBuscar.getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean eliminarArticulosAlDeposito(ArticuloDepositoMovimiento articuloDeposito, Long cantidadAquitar) {
        boolean flag = false;
       
        
        ArticuloDepositoMovimiento articuloDepositoCompleto = buscar(articuloDeposito.getArticulo(), articuloDeposito.getDeposito());
        if (articuloDepositoCompleto != null) {
            if (articuloDepositoCompleto.getCantidad() >= articuloDeposito.getCantidad()) {
                articuloDeposito.setCantidad(articuloDepositoCompleto.getCantidad() - cantidadAquitar);
                articuloDeposito.setId(articuloDepositoCompleto.getId());
                modificar(articuloDeposito);
                flag = true;
                JOptionPane.showMessageDialog(null, "Quedan "
                + articuloDeposito.getCantidad() + " " + articuloDeposito.getArticulo()
                + " a " + articuloDeposito.getDeposito().getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "No dispone del stock suficiente de "
                        + articuloDeposito.getArticulo().getDescripcion() + " en el "
                        + articuloDeposito.getDeposito().getDescripcion(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
             
        } else {
            JOptionPane.showMessageDialog(null, "No posee stock de "
                    + articuloDeposito.getArticulo().getDescripcion() + "en el "
                    + articuloDeposito.getDeposito().getDescripcion(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean eliminarArticulosAlDeposito(ArticuloDepositoMovimiento articuloDeposito, long cantidad) {
        boolean flag = false;
        if (articuloDeposito.getCantidad() >= cantidad) {
            articuloDeposito.setCantidad(articuloDeposito.getCantidad() - cantidad);
            modificar(articuloDeposito);
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "No dispone del stock suficiente de "
                    + articuloDeposito.getArticulo().getDescripcion() + " en el "
                    + articuloDeposito.getDeposito().getDescripcion(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public void transferirArticuloDesdeSucursalADeposito(Articulo articulo, Deposito deposito, Sucursal sucursal, Long cantidad) {
        ArticuloSucursalFacade articuloSucursalFacade = new ArticuloSucursalFacade();
        ArticuloSucursal articuloSucursal = articuloSucursalFacade.buscar(articulo, sucursal);
        if (articuloSucursalFacade.eliminarArticulosAlSucursal(articuloSucursal)) {
            agregarArticulosAlDeposito(articulo, deposito, cantidad);
        }
    }
}
