/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.articulos.stock;

import vista.Caja.*;
import entidades.articulo.Articulo;

import entidades.caja.PlanTarjeta;
import entidades.caja.TarjetaDeCredito;
import entidades.proveedor.Proveedor;
import facade.ProveedorFacade;
import facade.PlanTarjetaFacade;
import facade.SubCategoriaFacade;
import facade.TarjetaDeCreditoFacade;
import facade.UnidadMedidaFacade;
import includes.Comunes;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author vouilloz
 */
public class DiagProveedor extends javax.swing.JDialog {

    private String tipoOperacion;
   
    private Proveedor proveedor;

    /**
     * Creates new form DiagPlanTarjeta
     */
    public DiagProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DiagProveedor(java.awt.Frame parent, boolean modal, String tipoOperacion) {
        super(parent, modal);
        initComponents();
        this.tipoOperacion = tipoOperacion;
        inicializarComponentes();
    }

    public DiagProveedor(java.awt.Frame parent, boolean modal, String tipoOperacion, Proveedor proveedor) {
        super(parent, modal);
        initComponents();
        this.proveedor = proveedor;
        this.tipoOperacion = tipoOperacion;
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
        jLabel2 = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagProveedor.class, "DiagProveedor.jPanel1.border.title"))); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DiagProveedor.class, "DiagProveedor.jLabel2.text")); // NOI18N

        tfDescripcion.setText(org.openide.util.NbBundle.getMessage(DiagProveedor.class, "DiagProveedor.tfDescripcion.text")); // NOI18N

        jButton1.setText(org.openide.util.NbBundle.getMessage(DiagProveedor.class, "DiagProveedor.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        aceptar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiagProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagProveedor dialog = new DiagProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfDescripcion;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Plan");
        
        if (tipoOperacion.equals("Modificación")) {
            cargarDatosPlan();
        }
    }

    private void cargarDatosPlan() {
        try {
            tfDescripcion.setText(proveedor.getDescripcion());
        } catch (Exception e) {

        }
    
    }

    private void aceptar() {
        if (tipoOperacion.equals("Alta")) {
             if (validarProveedor()) {
            try {
                Proveedor proveedor = new Proveedor();
                
                proveedor.setDescripcion(tfDescripcion.getText().toUpperCase());
                
                ProveedorFacade.getInstance().alta(proveedor);
                JOptionPane.showMessageDialog(null, "El Proveedor se ha dado de alta");

                limpiarTextFields();
           
                tfDescripcion.requestFocus();
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el Proveedor");
            }
        }

        } else if (tipoOperacion.equals("Modificación")) {
            if (validarProveedor()) {
                proveedor.setDescripcion(tfDescripcion.getText().toUpperCase());
                
                ProveedorFacade.getInstance().modificar(proveedor);
                JOptionPane.showMessageDialog(this, "Proveedor Modificado!");
                this.dispose();

            }
        }
    }

    private boolean validarProveedor() {
     
        if(tfDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe escribir un nombre a el proveedor","Mensaje",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
      public void limpiarTextFields() {
       
        tfDescripcion.setText("");
       
    }
}
