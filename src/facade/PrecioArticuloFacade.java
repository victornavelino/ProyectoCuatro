/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controladores.ArticuloJpaController;
import controladores.CategoriaJpaController;
import controladores.ListaPrecioJpaController;
import controladores.PrecioArticuloJpaController;
import controladores.SucursalJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.Categoria;
import entidades.articulo.ListaPrecio;
import entidades.articulo.PrecioArticulo;
import entidades.articulo.SubCategoria;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * @author hugo
 */
public class PrecioArticuloFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
    EntityManager em = emf.createEntityManager();
    PrecioArticuloJpaController precioArticuloJpaController = new PrecioArticuloJpaController(emf);

    private static PrecioArticuloFacade instance = null;

    protected PrecioArticuloFacade() {
    }

    public static PrecioArticuloFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new PrecioArticuloFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(PrecioArticulo precioArticulo) {
        new PrecioArticuloJpaController(emf).create(precioArticulo);
    }

    public PrecioArticulo buscar(Long id) {
        return new PrecioArticuloJpaController(emf).findPrecioArticulo(id);
    }

    public void modificar(PrecioArticulo precioArticulo) {
        try {
            new PrecioArticuloJpaController(emf).edit(precioArticulo);
            emf.getCache().evictAll();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PrecioArticuloFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PrecioArticuloFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            new PrecioArticuloJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PrecioArticuloFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PrecioArticulo> getTodos() {
        return new PrecioArticuloJpaController(emf).findPrecioArticuloEntities();
    }

    public PrecioArticulo get(Articulo articulo, ListaPrecio listaPrecio, Sucursal sucursal) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        ema.getEntityManagerFactory().getCache().evictAll();
        Query quBuscar = ema.createQuery("SELECT p FROM PrecioArticulo p where p.articulo = :articulo "
                + "and p.listaPrecio = :listaPrecio and p.sucursal = :sucursal");
        quBuscar.setParameter("articulo", articulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("sucursal", sucursal);
        ema.getEntityManagerFactory().getCache().evictAll();
        try {
            return (PrecioArticulo) quBuscar.getResultList().get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    public PrecioArticulo getComun(Articulo articulo, Sucursal sucursal) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo = :articulo "
                + "and LOWER(p.listaPrecio.descripcion)='comun' and p.sucursal = :sucursal");
        quBuscar.setParameter("articulo", articulo);
        quBuscar.setParameter("sucursal", sucursal);

        try {
            return (PrecioArticulo) quBuscar.getResultList().get(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: Articulo no tiene precio!");
            return null;
        }
    }

    public List<PrecioArticulo> get(ListaPrecio listaPrecio, Sucursal sucursal) {

        EntityManager ema = emf.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM PrecioArticulo p where p.listaPrecio = :listaPrecio "
                + "and p.sucursal = :sucursal");
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("sucursal", sucursal);
        ema.getEntityManagerFactory().getCache().evictAll();

        try {
            return (List<PrecioArticulo>) quBuscar.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<PrecioArticulo> getTodosActual() {

        EntityManager ema = emf.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM PrecioArticulo p");

        ema.getEntityManagerFactory().getCache().evictAll();

        try {
            return (List<PrecioArticulo>) quBuscar.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean existePrecio(ListaPrecio listaPrecio, Sucursal sucursal, Articulo articulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo = :articulo "
                + "and p.listaPrecio = :listaPrecio and p.sucursal = :sucursal");
        quBuscar.setParameter("articulo", articulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("sucursal", sucursal);
        em.getEntityManagerFactory().getCache().evictAll();

        try {
            if (!quBuscar.getResultList().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean existePrecio(String listaPrecio, String codigo, String articulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo.descripcion = :articulo "
                + "and p.listaPrecio.descripcion = :listaPrecio and p.sucursal.codigo = :codigo");
        quBuscar.setParameter("articulo", articulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("codigo", codigo);
        try {
            if (!quBuscar.getResultList().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean existePrecioArticulo(String listaPrecio, String codigo, String codigoArticulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo.codigoBarra = :codigoArticulo "
                + "and p.listaPrecio.descripcion = :listaPrecio and p.sucursal.codigo = :codigo");
        quBuscar.setParameter("codigoArticulo", codigoArticulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("codigo", codigo);
        try {
            if (!quBuscar.getResultList().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public PrecioArticulo getPrecioArticuloPorCodigo(String listaPrecio, String codigo, String codigoArticulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo.codigoBarra = :codigoArticulo "
                + "and p.listaPrecio.descripcion = :listaPrecio and p.sucursal.codigo = :codigo");
        quBuscar.setParameter("codigoArticulo", codigoArticulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("codigo", codigo);
        try {
            return (PrecioArticulo) quBuscar.getResultList().get(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return null;
        }
    }

    public PrecioArticulo getPrecioArticulo(String listaPrecio, String codigo, String articulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo.descripcion = :articulo "
                + "and p.listaPrecio.descripcion = :listaPrecio and p.sucursal.codigo = :codigo");
        quBuscar.setParameter("articulo", articulo);
        quBuscar.setParameter("listaPrecio", listaPrecio);
        quBuscar.setParameter("codigo", codigo);
        try {
            return (PrecioArticulo) quBuscar.getResultList().get(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            return null;
        }
    }

    public PrecioArticulo get(Articulo articulo, Sucursal sucursal) {
        ListaPrecio lista = ListaPrecioFacade.getInstance().buscar(1L);
        return get(articulo, lista, sucursal);
    }

    public void borrarPrecioArticulos() {
        System.out.println("entro borrado PrecioArticulos");
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        em.getTransaction().begin();
        int qua = em.createQuery("DELETE FROM PrecioArticulo ap").executeUpdate();
        System.out.println("borrado PrecioArticulo " + qua);
        em.getTransaction().commit();
    }

    public List<PrecioArticulo> getPreciosArticulo(Articulo articulo) {
        Query quBuscar = em.createQuery("SELECT p FROM PrecioArticulo p where p.articulo = :articulo ");
        quBuscar.setParameter("articulo", articulo);
        try {
            return (List<PrecioArticulo>) quBuscar.getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public List<PrecioArticulo> buscarPoridArticulo(long articulo) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        ema.getEntityManagerFactory().getCache().evictAll();
        Query quBuscar = ema.createQuery("SELECT p FROM PrecioArticulo p where p.articulo.id  =:articulo order by p.sucursal.nombre asc");
        quBuscar.setParameter("articulo", articulo);

        ema.getEntityManagerFactory().getCache().evictAll();
        try {
            return (List<PrecioArticulo>) quBuscar.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<PrecioArticulo> buscarPorDescDescCortayCodigo(String descripcion) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        Query qu = em.createQuery("SELECT p FROM PrecioArticulo p WHERE "
                + "p.articulo.descripcionReducida LIKE :descripcion OR "
                + "p.articulo.codigoBarra LIKE :descripcion OR "
                + "p.articulo.descripcion LIKE :descripcion ORDER BY p.articulo.descripcion ASC");
        qu.setParameter("descripcion", "%" + descripcion.toUpperCase() + "%");
        em.getEntityManagerFactory().getCache().evictAll();
        return qu.getResultList();
    }

    public void actualizarPreciosCategoria(BigDecimal porcentaje, Categoria categoria, ListaPrecio listaprecios, Sucursal sucursal, boolean todasListas) {
        System.out.println("entro actualizar PrecioArticulos");
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        em.getTransaction().begin();
        Query q = null;
        if (!todasListas) {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.listaPrecio=:listaprecio and p.articulo.subCategoria.categoria=:categoria and p.sucursal=:sucursal");
            q.setParameter("listaprecio", listaprecios);
            
        } else {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.articulo.subCategoria.categoria=:categoria and p.sucursal=:sucursal");
           System.out.println("entro por todas las listasssssssssssssssssssssss..........++++++++++++");
        }
        q.setParameter("porcentaje", porcentaje);
        q.setParameter("categoria", categoria);

        q.setParameter("sucursal", sucursal);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void actualizarPreciosSubCategoria(BigDecimal porcentaje, SubCategoria subCategoria, ListaPrecio listaprecios, Sucursal sucursal, boolean todasListas) {
        System.out.println("entro actualizar PrecioArticulos");
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        em.getTransaction().begin();
        Query q = null;
        if (!todasListas) {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.listaPrecio=:listaprecio and p.articulo.subCategoria=:subCategoria  and p.sucursal=:sucursal");
            q.setParameter("listaprecio", listaprecios);
           
        } else {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.articulo.subCategoria=:subCategoria  and p.sucursal=:sucursal");
 System.out.println("entro por todas las listasssssssssssssssssssssss..........++++++++++++");
        }
        q.setParameter("porcentaje", porcentaje);
        q.setParameter("subCategoria", subCategoria);

        q.setParameter("sucursal", sucursal);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void actualizarPreciosArticuloPorPorcentaje(BigDecimal porcentaje, Articulo articulo, ListaPrecio listaprecios, Sucursal sucursal, boolean todasListas) {
        System.out.println("entro actualizar PrecioArticulos");
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        em.getTransaction().begin();
        Query q = null;
        if (!todasListas) {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.listaPrecio=:listaprecio and p.articulo=:articulo  and p.sucursal=:sucursal");
            q.setParameter("listaprecio", listaprecios);
            
        } else {
            q = em.createQuery("UPDATE PrecioArticulo p SET p.precio = p.precio +(p.precio *:porcentaje) WHERE p.articulo=:articulo  and p.sucursal=:sucursal");
            System.out.println("entro por todas las listasssssssssssssssssssssss..........++++++++++++");
        }
        q.setParameter("porcentaje", porcentaje);
        q.setParameter("articulo", articulo);

        q.setParameter("sucursal", sucursal);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void actualizarPreciosArticuloPorPrecio(BigDecimal precio, Articulo articulo, ListaPrecio listaprecios, Sucursal sucursal) {
        System.out.println("entro actualizar PrecioArticulos");
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager em = emfa.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE PrecioArticulo p SET p.precio =:precio WHERE p.listaPrecio=:listaprecio and p.articulo=:articulo  and p.sucursal=:sucursal");
        q.setParameter("precio", precio);
        q.setParameter("articulo", articulo);
        q.setParameter("listaprecio", listaprecios);
        q.setParameter("sucursal", sucursal);
        q.executeUpdate();

        em.getTransaction().commit();
    }
}
