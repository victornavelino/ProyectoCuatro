/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.listacosto;

import vista.articulos.*;
import entidades.articulo.Articulo;
import entidades.articulo.PrecioArticulo;
import entidades.articulo.costo.ListaCosto;
import entidades.articulo.costo.ValorCosto;
import facade.ArticuloFacade;
import facade.PrecioArticuloFacade;
import facade.SubCategoriaFacade;
import facade.UnidadMedidaFacade;
import facade.ValorCostoFacade;
import includes.Comunes;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author hugo
 */
public class DiagAdminValorCosto extends javax.swing.JDialog {

    /**
     * Creates new form DiagClienteGenerico
     */
    private String tipoOperacion;
    private javax.swing.JTextField jTextField;
    private ModeloTablaNoEditable modeloTablaArticulos;
    private Vector headers = new Vector();
    private Vector data = new Vector();
    private ValorCosto valorCosto;

    public DiagAdminValorCosto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarComponentes();
    }

    public DiagAdminValorCosto(java.awt.Frame parent, boolean modal, String tipoOperacion) {
        super(parent, modal);
        initComponents();
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

        bgCodDesc = new javax.swing.ButtonGroup();
        btnCerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArticulos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        tfArticulo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbDescripcion = new javax.swing.JRadioButton();
        rbListaCosto = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnCerrar.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.btnCerrar.text")); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jPanel3.border.title"))); // NOI18N

        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Descripción", "Lista de Costo", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblArticulos);
        if (tblArticulos.getColumnModel().getColumnCount() > 0) {
            tblArticulos.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.tblArticulos.columnModel.title0")); // NOI18N
            tblArticulos.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.tblArticulos.columnModel.title2")); // NOI18N
            tblArticulos.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.tblArticulos.columnModel.title3")); // NOI18N
            tblArticulos.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.tblArticulos.columnModel.title4")); // NOI18N
        }

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jLabel5.text")); // NOI18N

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        jbNuevo.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jbNuevo.text")); // NOI18N
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        jButton3.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jPanel1.border.title"))); // NOI18N

        bgCodDesc.add(rbDescripcion);
        rbDescripcion.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.rbDescripcion.text")); // NOI18N
        rbDescripcion.setLabel(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.rbDescripcion.label")); // NOI18N
        rbDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescripcionActionPerformed(evt);
            }
        });

        bgCodDesc.add(rbListaCosto);
        rbListaCosto.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.rbListaCosto.text")); // NOI18N
        rbListaCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListaCostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbListaCosto)
                    .addComponent(rbDescripcion))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbListaCosto))
        );

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        jbBuscar.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.jbBuscar.text_1")); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jbBuscar))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jbBuscar))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jbNuevo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        btnGuardarCambios.setText(org.openide.util.NbBundle.getMessage(DiagAdminValorCosto.class, "DiagAdminValorCosto.btnGuardarCambios.text")); // NOI18N
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarArticluo();
        cargarTablaValorCosto(ValorCostoFacade.getInstance().getTodos());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modificarArticulo();
        cargarTablaValorCosto(ValorCostoFacade.getInstance().getTodos());

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        agregarNuevoValorCosto();
        //cargarTablaArticulos(ArticuloFacade.getInstance().getTodos());
       
        if (rbDescripcion.isSelected()) {
            cargarTablaValorCosto(ValorCostoFacade.getInstance().todosOrderByDescripcion());
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void rbDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescripcionActionPerformed
        cargarTablaValorCosto(ValorCostoFacade.getInstance().todosOrderByDescripcion());
    }//GEN-LAST:event_rbDescripcionActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        guardarArticulos();
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void rbListaCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListaCostoActionPerformed
        cargarTablaValorCosto(ValorCostoFacade.getInstance().todosOrderByListaCosto());
    }//GEN-LAST:event_rbListaCostoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
       if (!tfArticulo.getText().isEmpty()) {
            cargarTablaValorCosto(ValorCostoFacade.getInstance().buscarPorDescripcion(tfArticulo.getText()));
        } else {
            cargarTablaValorCosto(ValorCostoFacade.getInstance().getTodos());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(DiagAdminValorCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagAdminValorCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagAdminValorCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagAdminValorCosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagAdminValorCosto dialog = new DiagAdminValorCosto(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgCodDesc;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JRadioButton rbDescripcion;
    private javax.swing.JRadioButton rbListaCosto;
    private javax.swing.JTable tblArticulos;
    private javax.swing.JTextField tfArticulo;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Administracion de Valores de Costo");
        
        cargarTablaValorCosto(ValorCostoFacade.getInstance().getTodos());

    }

    private void cargarTablaValorCosto(List<ValorCosto> valorCosto) {
        modeloTablaArticulos = new ModeloTablaNoEditable();
        cargarEncabezadosTablaArticulos(modeloTablaArticulos);
        configurarTabla(tblArticulos);
        try {
            cargarValorCosto(valorCosto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }
    }

    private void cargarEncabezadosTablaArticulos(ModeloTablaNoEditable modeloTablaArticulos) {
        modeloTablaArticulos.addColumn("Id");
     
        modeloTablaArticulos.addColumn("Descripcion");
        modeloTablaArticulos.addColumn("Lista de Costo");
        modeloTablaArticulos.addColumn("Valor");
        tblArticulos.setModel(modeloTablaArticulos);
    }

    private void configurarTabla(JTable tbl) {
        JViewport scroll = (JViewport) tbl.getParent();
        int ancho = scroll.getWidth();
        int anchoColumna = 0;
        TableColumnModel modeloColumna = tbl.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch (i) {
                case 0:
                    anchoColumna = (1 * ancho) / 100;
                    break;
                case 1:
                    anchoColumna = (20 * ancho) / 100;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    anchoColumna = (5 * ancho) / 100;
                    break;
            }
            columnaTabla.setPreferredWidth(anchoColumna);
            tbl.setColumnModel(modeloColumna);
        }
        tbl.getTableHeader().setFont(new java.awt.Font("Dialog",
                java.awt.Font.PLAIN, 10));
        tbl.getTableHeader().setBackground(java.awt.Color.WHITE);
        tbl.getTableHeader().setForeground(Color.BLACK);
        //Si le queremos cambiar el tamaño a la tablita
        tbl.setFont(new java.awt.Font("Dialog",
                java.awt.Font.PLAIN, 10));
    }

    private void cargarValorCosto(List<ValorCosto> valorCostos) {
        try {
            modeloTablaArticulos = new ModeloTablaNoEditable();
            cargarEncabezadosTablaArticulos(modeloTablaArticulos);
            for (ValorCosto valorCosto : valorCostos) {
                cargarValorCosto(valorCosto);
            }

            tblArticulos.setModel(modeloTablaArticulos);
            Comunes.setOcultarColumnasJTable(tblArticulos, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagAdminValorCosto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarValorCosto(ValorCosto valorCosto) {

        Object[] fila = new Object[4];
        fila[0] = valorCosto.getId();
        fila[1] = valorCosto.getDescripcion();
        fila[2] = valorCosto.getListaCosto();
        fila[3] = valorCosto.getValor();
        
        modeloTablaArticulos.addRow(fila);
    }

    private void modificarArticulo() {
        if (tblArticulos.getSelectedRow() != -1) {
            ValorCosto valorCosto = ValorCostoFacade.getInstance().buscar((Long) tblArticulos.getValueAt(tblArticulos.getSelectedRow(), 0));
            System.out.println("*****+++**-/*--*++6-++6>>>>>" + valorCosto);
            DiagValorCosto diagvalorCosto = new DiagValorCosto(null, true, "Modificación", valorCosto);
            diagvalorCosto.setLocation(Comunes.centrarDialog(diagvalorCosto));
            diagvalorCosto.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        }

    }

    private void eliminarArticluo() {
        if (tblArticulos.getSelectedRow() != -1) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el Registro seleccionado?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                try {
                    ValorCosto valorCosto = ValorCostoFacade.getInstance().buscar((Long) tblArticulos.getValueAt(tblArticulos.getSelectedRow(), 0));

                 
                    ValorCostoFacade.getInstance().eliminar((Long) tblArticulos.getValueAt(tblArticulos.getSelectedRow(), 0));
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e +" :valor en uso, no se puede eliminar ");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        }
    }

    private void agregarNuevoValorCosto() {
        DiagValorCosto diagValorCosto = new DiagValorCosto(null, true, "Alta");
        diagValorCosto.setLocation(Comunes.centrarDialog(diagValorCosto));
        diagValorCosto.setVisible(true);
    }

    private void Exportar() {
        new ExportarExcel().crearExcelJtable(tblArticulos, "Listado de Articulos");
    }

    private void Importar() {
        JFileChooser jChooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");
        jChooser.setFileFilter(filter);
        jChooser.showOpenDialog(this);
        File file = jChooser.getSelectedFile();
        if (file == null || !file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            leerDatosExcel(file);
            List<Integer> columnasNoEditables = new ArrayList<>();
            columnasNoEditables.add(0);
            columnasNoEditables.add(1);
            columnasNoEditables.add(2);
            columnasNoEditables.add(3);
            columnasNoEditables.add(4);
            columnasNoEditables.add(5);
            ModeloTablaNoEditable model = new ModeloTablaNoEditable(data, headers, columnasNoEditables);
            tblArticulos.setModel(model);
        }
    }

    void leerDatosExcel(File file) {
        Workbook workbook = null;
        try {
            try {
                workbook = Workbook.getWorkbook(file);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
            Sheet sheet = workbook.getSheet(0);
            headers.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                headers.add(cell1.getContents());
            }
            data.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    d.add(cell.getContents());
                }
                d.add("\n");
                data.add(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private void guardar() {

        int reply = JOptionPane.showConfirmDialog(null,
                "¿Desea guardar los cambios?", "Atualizar Clientes",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                guardarArticulos();
                JOptionPane.showMessageDialog(null, "Clientes actualizados correctamente");
                this.dispose();
            } catch (java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se han guardado los cambios \n"
                        + "Es posible que haya ingresado un valor incorrecto",
                        "Error Guardando", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se han guardado los cambios");
            this.dispose();
        }

    }

    private void guardarArticulos() {
        try {
            for (int i = 0; i < tblArticulos.getRowCount(); i++) {

                if (!ValorCostoFacade.getInstance().getExisteDescripcion( tblArticulos.getValueAt(i, 1).toString())) {

                    valorCosto = new ValorCosto();

                    
                    valorCosto.setDescripcion(tblArticulos.getValueAt(i,1).toString());
                    valorCosto.setListaCosto((ListaCosto) tblArticulos.getValueAt(i, 2));
                    valorCosto.setValor((BigDecimal)tblArticulos.getValueAt(i,3));
            

                    ValorCostoFacade.getInstance().alta(valorCosto);

                } else {

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

    }

}
