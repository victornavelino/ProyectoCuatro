/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.persistence.platform.database.MySQLPlatform;
import org.eclipse.persistence.platform.database.PostgreSQLPlatform;

/**
 *
 * @author franco
 */
public class ConexionFacade {

    public static final Map PROPIEDADES = new HashMap<String, String>() {
        {

            put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/carniceria");
            put("javax.persistence.jdbc.password", "123654");
            put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            put("javax.persistence.jdbc.user","postgres");

        }
    };
    public static final Map CONEXIONCLIENTES = new HashMap<String, String>() {
        {

            put("javax.persistence.jdbc.url", "jdbc:postgresql://latradicioncentral.ddns.net:5432/carniceria");
            put("javax.persistence.jdbc.password", "123654");
            put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            put("javax.persistence.jdbc.user",
                    new String(new char[]{
                        'p', 'o', 's', 't', 'g', 'r', 'e', 's'}));

        }
    };
    public static final Map CONEXION222 = new HashMap<String, String>() {
        {

            put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/carniceriaprueba");
            put("javax.persistence.jdbc.password", "123654");
            put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            put("javax.persistence.jdbc.user",
                    new String(new char[]{
                        'p', 'o', 's', 't', 'g', 'r', 'e', 's'}));

        }
    };

}
