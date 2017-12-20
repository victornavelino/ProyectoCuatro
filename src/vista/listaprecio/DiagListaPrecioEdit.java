/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.listaprecio;

import entidades.articulo.TipoIva;
import facade.GenericoFacade;
import static includes.Comunes.redondear;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author AFerSor
 */
public class DiagListaPrecioEdit<T> extends javax.swing.JDialog {

    private String sLabelButton;
    private int iTipoOp;
    private Boolean rstOperacion;
    private String descripcion;
    private Class<T> entidad;

    /**
     * Creates new form dgAtributoEdit
     */
    public DiagListaPrecioEdit(java.awt.Dialog parent, boolean modal, String titulo, String subTitulo, Class<T> entidad) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        initComponents();
        this.initComponentes();

        this.setTitle(titulo);
        this.jlSubTitulo.setText(subTitulo);
        this.entidad = entidad;

    }

    private void initComponentes() {
        this.jtfId.setEditable(Boolean.FALSE);
    }//fin initComponentes

    public Boolean getRstOperacion() {
        return rstOperacion;
    }

    public void setRstOperacion(Boolean rstOperacion) {
        this.rstOperacion = rstOperacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlSubTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jbAction = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tmargen = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 1, true));

        jlSubTitulo.setFont(new java.awt.Font("Vrinda", 0, 24)); // NOI18N
        jlSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlSubTitulo.setText("titulo");
        jlSubTitulo.setToolTipText("");
        jlSubTitulo.setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray, 2, true));

        jLabel2.setText("Código:");

        jtfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jbAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        jbAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Margen:");

        tmargen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmargenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jlSubTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbAction, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tmargen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlSubTitulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tmargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jbAction))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdActionPerformed

    private void jbActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionActionPerformed
        this.action();
    }//GEN-LAST:event_jbActionActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void tmargenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmargenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmargenActionPerformed

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
            java.util.logging.Logger.getLogger(DiagListaPrecioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagListaPrecioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagListaPrecioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagListaPrecioEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*DiagGenericoEdit dialog = new DiagGenericoEdit(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);*/
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAction;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlSubTitulo;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField tmargen;
    // End of variables declaration//GEN-END:variables

    private void action() {

        switch (iTipoOp) {
            case 0:
                this.guardar();
                break;
            case 1:
                this.modificar();
                break;
            case 2:
                this.eliminar();
                break;
        }//fin switch
    }//fin action

    private void guardar() {

        System.out.println("Entro al guardar");
        String sMensaje = "";
        int iTipoMsg = JOptionPane.INFORMATION_MESSAGE;
        try {

            //campos
            /*System.out.println("Entidad: " + entidad);
            TipoIva ti = new TipoIva();

            Method[] methods = ti.getClass().getDeclaredMethods();
            
            System.out.println("cant campos: " + methods.length);
            
            for(int i=0; i < methods.length; i++){
                System.out.println("Nombre del campo: " + 
                        methods[i].getName());
            }//fin for*/
            //nombre del campo
            Class[] cArg = new Class[1];

            cArg[0] = String.class;
            Method campo = null;
            campo = entidad.getDeclaredMethod("setDescripcion", cArg);

            //inyecto el valor del campo
            Object o = entidad.newInstance();
            campo.invoke(o, jtfNombre.getText().trim().toUpperCase());

            cArg[0] = BigDecimal.class;
            campo = entidad.getDeclaredMethod("setMargen", cArg);

            campo.invoke(o, redondear(new BigDecimal(tmargen.getText())));

            System.out.println("paso: " + o.toString());

            GenericoFacade.getInstance().alta(o);

            sMensaje = "El dato fue guardado";
            jtfNombre.setText("");
            this.setRstOperacion(Boolean.TRUE);
        } catch (Exception e) {
            this.setRstOperacion(Boolean.FALSE);
            sMensaje = "Error: " + e.getMessage();
            iTipoMsg = JOptionPane.ERROR_MESSAGE;
        } finally {
            JOptionPane.showMessageDialog(this, sMensaje, "Mensaje", iTipoMsg);
        }
    }//fin guardar

    private void modificar() {

        System.out.println("entro al modificar");

        String sMensaje = "";
        int iTipoMsg = JOptionPane.INFORMATION_MESSAGE;
        try {

            Class[] cArg = new Class[1];
            Method campo = null;

            //id
            cArg[0] = Long.class;
            campo = entidad.getDeclaredMethod("setId", cArg);

            Object o = entidad.newInstance();
            campo.invoke(o, Long.parseLong(jtfId.getText().trim()));

            //Descripcion
            cArg[0] = String.class;
            campo = entidad.getDeclaredMethod("setDescripcion", cArg);

            campo.invoke(o, jtfNombre.getText().toUpperCase().trim());
            
            //Margen
            cArg[0] = BigDecimal.class;
            campo = entidad.getDeclaredMethod("setMargen", cArg);
             campo.invoke(o, redondear(new BigDecimal(tmargen.getText())));
          //  campo.invoke(o, tmargen.getText().toUpperCase().trim());

            System.out.println("Antes de modificar");
            GenericoFacade.getInstance().modificar(o);

            sMensaje = "El dato fue modificado";
            this.setRstOperacion(Boolean.TRUE);
        } catch (Exception e) {
            this.setRstOperacion(Boolean.FALSE);
            sMensaje = "Error: " + e.getMessage();
            iTipoMsg = JOptionPane.ERROR_MESSAGE;
        } finally {
            JOptionPane.showMessageDialog(this, sMensaje, "Mensaje", iTipoMsg);
        }
    }//fin modificar

    private void eliminar() {
        String sMensaje = "";
        int iTipoMsg = JOptionPane.INFORMATION_MESSAGE;
        try {
            Class[] cArg = new Class[1];
            Method campo = null;

            //id
            cArg[0] = Long.class;
            campo = entidad.getDeclaredMethod("setId", cArg);

            Object o = entidad.newInstance();
            campo.invoke(o, Long.parseLong(jtfId.getText().trim()));

            //Descripcion
            cArg[0] = String.class;
            campo = entidad.getDeclaredMethod("setDescripcion", cArg);

            campo.invoke(o, jtfNombre.getText().toUpperCase().trim());
            //Margen
            cArg[0] = BigDecimal.class;
            campo = entidad.getDeclaredMethod("setMargen", cArg);
             campo.invoke(o, redondear(new BigDecimal(tmargen.getText())));

            GenericoFacade.getInstance().eliminar(o);

            sMensaje = "El dato fue eliminado";
            jtfNombre.setText("");
            tmargen.setText("");
            this.setRstOperacion(Boolean.TRUE);
        } catch (Exception e) {
            this.setRstOperacion(Boolean.FALSE);
            sMensaje = "Error:  No se puede eliminar el Registro porque se esta utilizando";
            iTipoMsg = JOptionPane.ERROR_MESSAGE;
        } finally {
            JOptionPane.showMessageDialog(this, sMensaje, "Mensaje", iTipoMsg);
        }
    }//fin eliminar

    public void definirOperacion(int op) {

        switch (op) {
            case 0:
                this.sLabelButton = "Guardar";
                break;
            case 1:
                this.sLabelButton = "Modificar";
                //this.jtfId.setText(String.valueOf(an.getId()));
                //this.jtfNombre.setText(an.getNombre());

                break;
            case 2:
                this.sLabelButton = "Eliminar";
                //this.jtfId.setText(String.valueOf(an.getId()));
                //this.jtfNombre.setText(an.getNombre());

                break;

        }//fin switch

        iTipoOp = op;
        this.jbAction.setText(sLabelButton);

    }//fin 

    public void cargarCampos(String id, String descripcion,String margen) {

        this.jtfId.setText(id);
        this.jtfNombre.setText(descripcion);
        this.tmargen.setText(margen);

    }//fin cargarCampos

}
