/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import controladores.ClienteJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.cliente.Cliente;
import entidades.persona.CorreoElectronico;
import entidades.venta.Venta;
import includes.Comunes;
import includes.SesionUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.eclipse.persistence.platform.database.PostgreSQLPlatform;
import vista.frPrincipal;

/**
 *
 * @author hugo
 */
public class ClienteFacade {

    private static ClienteFacade instance = null;

    protected ClienteFacade() {
    }

    public static ClienteFacade getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple

    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new ClienteFacade();
        }
    }

//El metodo "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void alta(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        new ClienteJpaController(emf).create(cliente);
    }

    public void altaCentral(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        new ClienteJpaController(emf).create(cliente);
    }

    public Cliente buscar(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        return new ClienteJpaController(emf).findCliente(id);
    }

    public void modificar(Cliente cliente) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            new ClienteJpaController(emf).edit(cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarCentral(Cliente cliente) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            new ClienteJpaController(emf).edit(cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            new ClienteJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCentral(long id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            new ClienteJpaController(emf).destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> getTodos() {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscarCliente = ema.createQuery("SELECT c FROM Cliente c ");
        return quBuscarCliente.getResultList();
    }

    public List<Cliente> buscar(String descripcion) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscarCliente = ema.createQuery("SELECT c FROM Cliente c "
                + "WHERE TYPE(c) = Organismo and c.razonSocial like :descripcion ");
        quBuscarCliente.setParameter("descripcion", "%" + descripcion + "%");
        return quBuscarCliente.getResultList();
    }

    

    public List<Cliente> getPersonas() {
        /*EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
         EntityManager ema = emfa.createEntityManager();
         Query quBuscar = ema.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = Persona");
         return quBuscar.getResultList();*/
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p ORDER BY p.apellido");
        ema.getEntityManagerFactory().getCache().evictAll();
        return quBuscar.getResultList();
    }

    public List<Cliente> getPersonasCentral() {
        /*EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
         EntityManager ema = emfa.createEntityManager();
         Query quBuscar = ema.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = Persona");
         return quBuscar.getResultList();*/
        EntityManagerFactory emfa = null;
        emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
        //emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p ORDER BY p.apellido");
        ema.getEntityManagerFactory().getCache().evictAll();
        return quBuscar.getResultList();
    }

    public List<Cliente> getPersonasXDni(String dni) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero=:dni");
        quBuscar.setParameter("dni", dni);
        return quBuscar.getResultList();
    }

    public List<Cliente> buscarPersonas(String descripcion) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero LIKE :descripcion "
                + "OR p.apellido LIKE :descripcion");
        quBuscar.setParameter("descripcion", "%" + descripcion.toUpperCase() + "%");
        return quBuscar.getResultList();
    }

    public Cliente getPersonaXDni(String dni) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero=:dni");
        quBuscar.setParameter("dni", dni);
        quBuscar.setMaxResults(1);

        try {
            return (Cliente) quBuscar.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public boolean getPersonaDni(String dni) {
        boolean flag = false;
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero=:dni");
        quBuscar.setParameter("dni", dni);
        try {
            if (quBuscar.getResultList().isEmpty()) {
                flag = false;
            } else {
                flag = true;
            }
            return flag;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salio por el catch");
            return false;
        }

    }

    public Cliente getPersonasXId(Long id) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.id=:id");
        quBuscar.setParameter("id", id);
        quBuscar.setMaxResults(1);

        return (Cliente) quBuscar.getSingleResult();
    }

    public Cliente getPersonasXIdCentral(Long id) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
        //EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.id=:id");
        quBuscar.setParameter("id", id);
        quBuscar.setMaxResults(1);

        return (Cliente) quBuscar.getSingleResult();
    }



    public List<Cliente> getPersonasPorApellido(String apellido) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.apellido LIKE :apellido");
        quBuscar.setParameter("apellido", "%" + apellido + "%");
        ema.getEntityManagerFactory().getCache().evictAll();
        return quBuscar.getResultList();
    }

    public List<Cliente> getPersonasPorApellidoCentral(String apellido) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
        //EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("SELECT p FROM Cliente p WHERE p.apellido LIKE :apellido");
        quBuscar.setParameter("apellido", "%" + apellido + "%");
        ema.getEntityManagerFactory().getCache().evictAll();
        return quBuscar.getResultList();
    }

    public boolean buscarDniPersona(String dni) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            EntityManager em = emf.createEntityManager();
            Query qu = em.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero=:dni");
            qu.setParameter("dni", dni);
            qu.setMaxResults(1);

            qu.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean buscarDniPersonaCentral(String dni) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.CONEXIONCLIENTES);
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
            EntityManager em = emf.createEntityManager();
            Query qu = em.createQuery("SELECT p FROM Cliente p WHERE p.documentoIdentidad.numero=:dni");
            qu.setParameter("dni", dni);
            qu.setMaxResults(1);

            qu.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Cliente buscarTipoCliente(Long id) {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscarCliente = ema.createQuery("SELECT c FROM Cliente c WHERE c.id =:id");
        quBuscarCliente.setParameter("id", id);
        return (Cliente) quBuscarCliente.getSingleResult();
    }

    public List<Cliente> getPersonasDuplicadas() {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoCuatroPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();
        Query quBuscar = ema.createQuery("Select MIN(pa.fechaAlta) as fecha From Cliente pa where (select COUNT(p.documentoIdentidad.numero) FROM Cliente p WHERE p.documentoIdentidad.numero = pa.documentoIdentidad.numero ) > 1 GROUP BY pa.documentoIdentidad.numero");
        ema.getEntityManagerFactory().getCache().evictAll();
        return quBuscar.getResultList();
    }

    public void verificarConexion() throws Exception {
        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoDosAddClientesPU", ConexionFacade.CONEXIONCLIENTES);
        //EntityManagerFactory emfa = Persistence.createEntityManagerFactory("ProyectoDosAddClientesPU", ConexionFacade.PROPIEDADES);
        EntityManager ema = emfa.createEntityManager();

    }

    public void probarConexionALaCentral() throws Exception {

        Comunes.ventanaCargando(this, "probarConexion", "Conectando con el servidor", null);
    }

    public void probarConexion() throws JSchException   {
        String usuario = "root";
        String servidor = "latradicioncentral.ddns.net";
        Integer puerto = 22;
        String clave = "latradicion.7319";

        JSch jSSH = new JSch();
        Session session = jSSH.getSession(usuario, servidor, puerto);
        UserInfo ui = new SesionUsuario(clave, null);

        session.setUserInfo(ui);

        session.setPassword(clave);

        session.connect();
        session.disconnect();
        frPrincipal.conectadoALaCentral=true;
        
    }


}
