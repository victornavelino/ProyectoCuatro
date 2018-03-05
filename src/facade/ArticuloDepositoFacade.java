/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ArticuloDepositoJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.stock.ArticuloDeposito;
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
public class ArticuloDepositoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);

    ArticuloDepositoJpaController articuloDepositoJpa = new ArticuloDepositoJpaController(emf);

    Query quArticuloDeposito;
    List listArticuloDeposito;

     private static ArticuloDepositoFacade instance = null;

    protected ArticuloDepositoFacade() {
    }

    public static ArticuloDepositoFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ArticuloDepositoFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    
    public void alta(ArticuloDeposito articuloDeposito) {
        articuloDepositoJpa.create(articuloDeposito);
    }

    public void modificar(ArticuloDeposito articuloDeposito) {
        try {
            articuloDepositoJpa.edit(articuloDeposito);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloDepositoFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ArticuloDepositoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Long id) {
        try {
            articuloDepositoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloDepositoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArticuloDeposito buscar(long id) {
        return articuloDepositoJpa.findArticuloDeposito(id);
    }

    public ArticuloDeposito buscar(Articulo articulo, Deposito deposito) {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++" +articulo.getId() + "¿¿¿¿¿¿¿¿¿¿¿¿¿" +deposito.getId());
        EntityManager em = emf.createEntityManager();
        ArticuloDeposito articuloDeposito = new ArticuloDeposito();
        quArticuloDeposito = em.createQuery("SELECT ad FROM ArticuloDeposito ad WHERE ad.articulo = :articulo AND ad.deposito = :deposito");
        quArticuloDeposito.setParameter("articulo", articulo);
        quArticuloDeposito.setParameter("deposito", deposito);

        //ArticuloDeposito articuloDeposito= new ArticuloDeposito();
         //articuloDeposito = (ArticuloDeposito) qu.getSingleResult();


         
         try {
            return (ArticuloDeposito) quArticuloDeposito.getResultList().get(0);
        } catch (Exception ex) {
            return null;
        }
       
    }

    public void agregarArticulosAlDeposito(ArticuloDeposito articuloDeposito) {
        ArticuloDeposito articuloDepositoCompleto = buscar(articuloDeposito.getArticulo(), articuloDeposito.getDeposito());
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
        ArticuloDeposito articuloDepositoCompleto = buscar(articulo, deposito);
        if (articuloDepositoCompleto != null) {
            articuloDepositoCompleto.setCantidad(articuloDepositoCompleto.getCantidad() + cantidad);
        } else {
            ArticuloDeposito articuloDeposito = new ArticuloDeposito();
            articuloDeposito.setArticulo(articulo);
            articuloDeposito.setCantidad(cantidad);
            articuloDeposito.setDeposito(deposito);
            alta(articuloDeposito);
        }
    }

    public boolean eliminarArticulosAlDeposito(ArticuloDeposito articuloDeposito) {
        boolean flag = false;
        ArticuloDeposito articuloDepositoCompleto = buscar(articuloDeposito.getArticulo(), articuloDeposito.getDeposito());
        if (articuloDepositoCompleto.getId() != null) {
            if (articuloDepositoCompleto.getCantidad() >= articuloDeposito.getCantidad()) {
                articuloDeposito.setCantidad(articuloDepositoCompleto.getCantidad() - articuloDeposito.getCantidad());
                flag = true;
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

    public boolean eliminarArticulosAlDeposito(ArticuloDeposito articuloDeposito, long cantidad) {
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
