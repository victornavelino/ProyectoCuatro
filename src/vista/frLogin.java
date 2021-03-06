/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frLogin.java
 *
 * Created on 03/11/2009, 19:48:30
 */
package vista;

//import entidades.Usuarios;
import entidades.usuario.Usuario;
import facade.UsuarioFacade;
import includes.Comunes;
import includes.SuperFrame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author carlos
 */
public class frLogin extends SuperFrame {

    /**
     * Creates new form frLogin
     */
    public frLogin() {
        super("Autenticacion - Arco Iris Pinturería");
        try {

            //UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
            //UIManager.setLookAndFeel("org.fife.plaf.OfficeXP.OfficeXPLookAndFeel");
            // UIManager.setLookAndFeel("org.fife.plaf.VisualStudio2005.VisualStudio2005LookAndFeel");
            //    com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Error: " + e);
        } catch (UnsupportedLookAndFeelException ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.out.println("Error: " + e);
            }

        }
        initComponents();
        inicializarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        passContrasena = new javax.swing.JPasswordField();
        btIngresar = new javax.swing.JButton();
        jXBusyLabel1 = new org.jdesktop.swingx.JXBusyLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        lbUsuario.setText("Usuario");

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });

        lbContrasena.setText("Contraseña");

        passContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passContrasenaActionPerformed(evt);
            }
        });

        btIngresar.setBackground(new java.awt.Color(255, 102, 51));
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        jXBusyLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jXBusyLabel1.setText("Comprobando Nombre de Usuario y Contraseña");
        jXBusyLabel1.setBusy(true);
        jXBusyLabel1.setFont(new java.awt.Font("DejaVu Sans", 3, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXBusyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbUsuario)
                                .addGap(24, 24, 24)
                                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbContrasena)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsuario)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContrasena))
                .addGap(18, 18, 18)
                .addComponent(btIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jXBusyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArcoIrisLogin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        corroborarContrasena();
    }//GEN-LAST:event_btIngresarActionPerformed

    private void passContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passContrasenaActionPerformed
        corroborarContrasena();
    }//GEN-LAST:event_passContrasenaActionPerformed

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        passContrasena.requestFocus();
    }//GEN-LAST:event_tfUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXBusyLabel jXBusyLabel1;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField passContrasena;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    public void cargarPuesto() {
    }

    public void corroborarContrasena() {

        try {
            SwingWorker worker = new SwingWorker() {
                Usuario usuario = new Usuario();

                @Override
                protected Object doInBackground() throws Exception {
                    jXBusyLabel1.setVisible(true);
                    usuario.setNombreUsuario(tfUsuario.getText());

                    usuario.setContrasena(new String(passContrasena.getPassword()));
                    usuario = new UsuarioFacade().validar(usuario);
                    return null;
                }

                @Override
                protected void done() {
                    if (usuario.getId() != null) {
                        frPrincipal principal = new frPrincipal(usuario);
                        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        principal.setVisible(true);
                        cerrarVentana();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nombre de Usuario y/o "
                                + "Contraseña incorrecta",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    jXBusyLabel1.setVisible(false);
                }
            };
            worker.execute();
        } catch (DatabaseException ex) {
            JOptionPane.showMessageDialog(null, "No se puede establecer una "
                    + "conexión con el servidor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cerrarVentana() {
        this.dispose();
    }

    private void inicializarComponentes() {
        this.setLocationRelativeTo(null);
        cargarPuesto();
        jXBusyLabel1.setVisible(false);
    }

    private void limpiarTextFields() {
        passContrasena.setText("");
        tfUsuario.requestFocus();
        tfUsuario.selectAll();
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/LogoArcoIrisICONO.png"));


        return retValue;
    }
}
