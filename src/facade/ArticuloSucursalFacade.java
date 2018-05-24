/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ArticuloDepositoJpaController;
import controladores.ArticuloSucursalJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.stock.ArticuloDeposito;
import entidades.articulo.stock.ArticuloSucursal;
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
public class ArticuloSucursalFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);

    ArticuloDepositoJpaController articuloDepositoJpa = new ArticuloDepositoJpaController(emf);

    Query quArticuloSucursal;
    List listArticuloSucursal;
    private static ArticuloSucursalFacade instance = null;

    protected ArticuloSucursalFacade() {
    }

    public static ArticuloSucursalFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ArticuloSucursalFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(ArticuloSucursal articuloDepositoSucursal) {
        new ArticuloSucursalJpaController(emf).create(articuloDepositoSucursal);
    }

    public void modificar(ArticuloSucursal articuloDepositoSucursal) {
        try {
            new ArticuloSucursalJpaController(emf).edit(articuloDepositoSucursal);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloSucursalFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ArticuloSucursalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Long id) {
        try {
            new ArticuloSucursalJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ArticuloSucursalFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArticuloSucursal buscar(long id) {
        return new ArticuloSucursalJpaController(emf).findArticuloSucursal(id);
    }

    public ArticuloSucursal buscar(Articulo articulo, Sucursal sucursal) {
        ArticuloSucursal articuloSucursal = new ArticuloSucursal();
        EntityManager em = emf.createEntityManager();
        quArticuloSucursal = em.createQuery("SELECT ad FROM ArticuloSucursal ad WHERE ad.articulo = :articulo AND ad.sucursal = :sucursal ");
        quArticuloSucursal.setParameter("articulo", articulo);
        quArticuloSucursal.setParameter("sucursal", sucursal);
           try {
            return (ArticuloSucursal) quArticuloSucursal.getResultList().get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    /*public void agregarArticulosAlSucursal(ArticuloSucursal articuloSucursal) {
     if (articuloSucursal.getId() != null) {
     articuloSucursal.setCantidad(articuloSucursal.getCantidad() + articuloSucursal.getCantidad());
     } else {
     alta(articuloSucursal);
     }
     }*/
    public void agregarArticulosAlSucursal(ArticuloSucursal articuloSucursal, long cantidad) {
        articuloSucursal.setCantidad(articuloSucursal.getCantidad() + cantidad);
        modificar(articuloSucursal);
    }

    public boolean eliminarArticulosAlSucursal(ArticuloSucursal articuloSucursal) {
        boolean flag = false;
        ArticuloSucursal articuloSucursalCompleto = buscar(articuloSucursal.getArticulo(), articuloSucursal.getSucursal());
        if (articuloSucursalCompleto.getId() != null) {
            articuloSucursalCompleto.setCantidad(articuloSucursalCompleto.getCantidad() - articuloSucursal.getCantidad());
            modificar(articuloSucursalCompleto);
            flag = true;
        } else {
            /* Si no existe, crea el articulo sucursal y le asigna la cantidad en deficit*/
            articuloSucursal.setCantidad(-articuloSucursal.getCantidad());
            alta(articuloSucursal);
        }

        return flag;
    }

    public void transferirArticuloDesdeDepositoASucursal(ArticuloDeposito articuloDepositoParam, Sucursal sucursal, Long cantidad) {
      
        ArticuloDeposito articuloDeposito = new ArticuloDepositoFacade().buscar(articuloDepositoParam.getArticulo(), articuloDepositoParam.getDeposito());
        if (articuloDeposito.getId() != null) {
            ArticuloSucursal articuloSucursal = buscar(articuloDeposito.getArticulo(), sucursal);
            
            if (articuloSucursal != null) {
                if (new ArticuloDepositoFacade().eliminarArticulosAlDeposito(articuloDeposito, cantidad)) {
                    agregarArticulosAlSucursal(articuloSucursal, cantidad);
                   // new ArticuloDepositoFacade().eliminarArticulosAlDeposito(articuloDeposito, cantidad);
                }
            } else {
                articuloSucursal = new ArticuloSucursal();
                
                articuloSucursal.setArticulo(articuloDeposito.getArticulo());
                articuloSucursal.setSucursal(sucursal);
                articuloSucursal.setCantidad(cantidad);
                alta(articuloSucursal);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe stock de "
                    + articuloDepositoParam.getArticulo() + " en el "
                    + articuloDepositoParam.getDeposito(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean diponibilidadParaVender(Articulo articulo, Sucursal sucursal, long cantidad) {
        boolean flag = false;
        ArticuloSucursal articuloSucursal = buscar(articulo, sucursal);
        if (articuloSucursal.getCantidad() >= cantidad) {
            flag = true;
        } else {
            long cantidadFaltante = cantidad - articuloSucursal.getCantidad();
            JOptionPane.showMessageDialog(null, "Se necesita solicitar "
                    + cantidadFaltante + " artículos de " + articulo.getDescripcion(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

//    public void restablecerStock(Recibo recibo, Sucursal sucursal) {
//        List<ReciboArticulo> articulos;
//        Articulo articulo;
//        EntityManager em = emf.createEntityManager();
//        Query quRecibo = em.createQuery("SELECT ra FROM " + "ReciboArticulo ra WHERE ra.recibo.id=" + recibo.getId());
//        articulos = quRecibo.getResultList();
//        for (int i = 0; i < articulos.size(); i++) {
//            ArticuloSucursalFacade articuloPF = new ArticuloSucursalFacade();
//            ArticuloFacade articuloF = new ArticuloFacade();
//            ArticuloSucursal articuloP;
//            articulo = articuloF.buscarArticulo(articulos.get(i).getArticulo().getId());
//            articuloP = articuloPF.buscar(articulo, sucursal);
//            articuloP.setCantidad(articuloP.getCantidad() + new Long(articulos.get(i).getCantidad()));
//            try {
//                new ArticuloSucursalJpaController(emf).edit(articuloP);
//            } catch (NonexistentEntityException ex) {
//                Logger.getLogger(ArticuloSucursalFacade.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(ArticuloSucursalFacade.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
       public List<ArticuloSucursal> getTodos() {
        return new ArticuloSucursalJpaController(emf).findArticuloSucursalEntities();
    }
}
