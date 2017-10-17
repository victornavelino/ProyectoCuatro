/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cliente;

import entidades.Sucursal;
import entidades.cliente.Cliente;
import entidades.cliente.Organismo;
import entidades.cliente.Persona;
import entidades.empleado.Empleado;
import facade.ClienteFacade;
import facade.EmpleadoFacade;
import includes.Comunes;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hugo
 */
public class DiagClienteServer extends javax.swing.JDialog {

    /**
     * Creates new form DiagClienteGenerico
     */
    private String tipoOperacion;
    private javax.swing.JTextField jTextField;
    private ModeloTablaNoEditable modeloTablaPersonas;
    private ModeloTablaNoEditable modeloTablaOrganismo;
    private Sucursal sucursal;

    public DiagClienteServer(java.awt.Frame parent, boolean modal, String tipoOperacion, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.sucursal = sucursal;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        tfApellido = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbNuevoOrganismo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfRazonSocial = new javax.swing.JTextField();
        btnBuscarOrganismo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrganismos = new javax.swing.JTable();
        btnEditarOrganismo = new javax.swing.JButton();
        btnEliminarOrganismo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Apellido", "Nombre", "Documento"
            }
        ));
        jScrollPane1.setViewportView(tblPersonas);

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jLabel5.text")); // NOI18N

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        jbNuevo.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jbNuevo.text")); // NOI18N
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        jbBuscar.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jbBuscar.text")); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        jButton3.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addComponent(jbNuevo)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        jbNuevoOrganismo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        jbNuevoOrganismo.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jbNuevoOrganismo.text")); // NOI18N
        jbNuevoOrganismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoOrganismoActionPerformed(evt);
            }
        });

        jLabel6.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jLabel6.text")); // NOI18N

        tfRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRazonSocialActionPerformed(evt);
            }
        });

        btnBuscarOrganismo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btnBuscarOrganismo.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.btnBuscarOrganismo.text")); // NOI18N
        btnBuscarOrganismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrganismoActionPerformed(evt);
            }
        });

        tblOrganismos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Razon Social", "Cuil", "Domicilio"
            }
        ));
        jScrollPane2.setViewportView(tblOrganismos);

        btnEditarOrganismo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btnEditarOrganismo.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.btnEditarOrganismo.text")); // NOI18N
        btnEditarOrganismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOrganismoActionPerformed(evt);
            }
        });

        btnEliminarOrganismo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarOrganismo.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.btnEliminarOrganismo.text")); // NOI18N
        btnEliminarOrganismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarOrganismoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarOrganismo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNuevoOrganismo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditarOrganismo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarOrganismo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(tfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarOrganismo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jbNuevoOrganismo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnEditarOrganismo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarOrganismo)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        btnCerrar.setText(org.openide.util.NbBundle.getMessage(DiagClienteServer.class, "DiagClienteServer.btnCerrar.text")); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        agregarNuevaPersona();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbNuevoOrganismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoOrganismoActionPerformed
        agregarNuevoOrganismo();
        cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());
    }//GEN-LAST:event_jbNuevoOrganismoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (!tfApellido.getText().isEmpty()) {
            cargarTablaPersonas(ClienteFacade.getInstance().getPersonasPorApellido(tfApellido.getText().toUpperCase()));
        } else {
            cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modificarPersona();
        cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarPersona();
        cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBuscarOrganismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrganismoActionPerformed
        if (!tfRazonSocial.getText().isEmpty()) {
            cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismosPorRazonSocial(tfRazonSocial.getText().toUpperCase()));
        } else {
            cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());
        }
    }//GEN-LAST:event_btnBuscarOrganismoActionPerformed

    private void btnEditarOrganismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOrganismoActionPerformed
        modificarOrganismo();
        cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());
    }//GEN-LAST:event_btnEditarOrganismoActionPerformed

    private void btnEliminarOrganismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarOrganismoActionPerformed
        eliminarOrganismo();
        cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());
    }//GEN-LAST:event_btnEliminarOrganismoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed
        if (!tfApellido.getText().isEmpty()) {
            cargarTablaPersonas(ClienteFacade.getInstance().getPersonasPorApellido(tfApellido.getText().toUpperCase()));
        } else {
            cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());
        }
    }//GEN-LAST:event_tfApellidoActionPerformed

    private void tfRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRazonSocialActionPerformed
        // TODO add your handling code here:
        if (!tfRazonSocial.getText().isEmpty()) {
            cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismosPorRazonSocial(tfRazonSocial.getText().toUpperCase()));
        } else {
            cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());
        }
    }//GEN-LAST:event_tfRazonSocialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarOrganismo;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditarOrganismo;
    private javax.swing.JButton btnEliminarOrganismo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbNuevoOrganismo;
    private javax.swing.JTable tblOrganismos;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfRazonSocial;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Administracion de Clientes");
        cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());
        cargarTablaOrganismos(ClienteFacade.getInstance().getOrganismos());

    }

    private void agregarNuevaPersona() {
        DiagClientePersonaServer diagClientePersonaServer = new DiagClientePersonaServer(null, true, "Persona", "AltaPersona", sucursal);
        diagClientePersonaServer.setLocation(Comunes.centrarDialog(diagClientePersonaServer));
        diagClientePersonaServer.setVisible(true);
        cargarTablaPersonas(ClienteFacade.getInstance().getPersonas());
    }

    private void agregarNuevoOrganismo() {
        DiagClientePersona diagClientePersona = new DiagClientePersona(null, true, "Organismo", "AltaOrganismo", sucursal);
        diagClientePersona.setLocation(Comunes.centrarDialog(diagClientePersona));
        diagClientePersona.setVisible(true);
    }

    private void cargarTablaPersonas(List<Persona> personas) {
        modeloTablaPersonas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaPersonas(modeloTablaPersonas);
        configurarTabla(tblPersonas);
        try {
            cargarPersonas(personas);
        } catch (Exception ex) {
            Logger.getLogger(DiagClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarTablaOrganismos(List<Organismo> organismos) {
        modeloTablaOrganismo = new ModeloTablaNoEditable();
        cargarEncabezadosTablaOrganismos(modeloTablaOrganismo);
        configurarTabla(tblOrganismos);
        try {
            cargarOrganismos(organismos);
        } catch (Exception ex) {
            Logger.getLogger(DiagClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarEncabezadosTablaPersonas(ModeloTablaNoEditable modeloTablaPersonas) {
        modeloTablaPersonas.addColumn("Id");
        modeloTablaPersonas.addColumn("Apellido");
        modeloTablaPersonas.addColumn("Nombre");
        modeloTablaPersonas.addColumn("Documento");
        tblPersonas.setModel(modeloTablaPersonas);
    }

    private void cargarEncabezadosTablaOrganismos(ModeloTablaNoEditable modeloTablaOrganismos) {
        modeloTablaOrganismos.addColumn("Id");
        modeloTablaOrganismos.addColumn("Razon Social");
        modeloTablaOrganismos.addColumn("Cuil");
        modeloTablaOrganismos.addColumn("Domicilio");
        tblOrganismos.setModel(modeloTablaOrganismos);
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

    private void cargarPersonas(List<Persona> personas) {
        try {
            modeloTablaPersonas = new ModeloTablaNoEditable();
            cargarEncabezadosTablaPersonas(modeloTablaPersonas);
            for (Persona persona : personas) {
                cargarPersona(persona);
            }

            tblPersonas.setModel(modeloTablaPersonas);
            Comunes.setOcultarColumnasJTable(tblPersonas, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarOrganismos(List<Organismo> organismos) {
        try {
            modeloTablaOrganismo = new ModeloTablaNoEditable();
            cargarEncabezadosTablaOrganismos(modeloTablaOrganismo);
            for (Organismo organismo : organismos) {
                cargarOrganismo(organismo);
            }

            tblOrganismos.setModel(modeloTablaOrganismo);
            Comunes.setOcultarColumnasJTable(tblOrganismos, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagClienteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarPersona(Persona persona) {

        Object[] fila = new Object[4];
        fila[0] = persona.getId();
        fila[1] = persona.getApellido();
        fila[2] = persona.getNombre();
        fila[3] = persona.getDocumentoIdentidad();
        modeloTablaPersonas.addRow(fila);
    }

    private void cargarOrganismo(Organismo organismo) {

        Object[] fila = new Object[4];
        fila[0] = organismo.getId();
        fila[1] = organismo.getRazonSocial();
        fila[2] = organismo.getCUIT();
        fila[3] = organismo.getDomicilio();
        modeloTablaOrganismo.addRow(fila);
    }

    private void modificarPersona() {
        if (tblPersonas.getSelectedRow() != -1) {
            Persona persona = ClienteFacade.getInstance().getPersonasXId((Long) tblPersonas.getValueAt(tblPersonas.getSelectedRow(), 0));
            DiagClientePersonaServer diagClientePersona = new DiagClientePersonaServer(null, true, "Persona", "ModificaciónPersona", persona, sucursal);
            diagClientePersona.setLocation(Comunes.centrarDialog(diagClientePersona));
            diagClientePersona.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una persona");
        }

    }

    private void eliminarPersona() {
        if (tblPersonas.getSelectedRow() != -1) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el Registro seleccionado?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                //primero verificamos si el cliente es tambien un empleado asi borramos ambos
                Persona cliente = ClienteFacade.getInstance().getPersonasXId((Long) tblPersonas.getValueAt(tblPersonas.getSelectedRow(), 0));
                if (EmpleadoFacade.getInstance().existeEmpleadoCliente(cliente)) {
                    Empleado empleado = EmpleadoFacade.getInstance().getEmpleadoXDNI(cliente);
                    try {
                        empleado.setFechaBaja(Comunes.obtenerFechaActualDesdeDB());
                        EmpleadoFacade.getInstance().modificar(empleado);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Error al dar de baja el empleado");
                    }

                }
                try {
                    ClienteFacade.getInstance().eliminar((Long) tblPersonas.getValueAt(tblPersonas.getSelectedRow(), 0));
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "El cliente tiene asociadas una o mas ventas \n"
                            + "no puede eliminarse");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una persona");
        }
    }

    private void modificarOrganismo() {
        if (tblOrganismos.getSelectedRow() != -1) {
            Organismo organismo = ClienteFacade.getInstance().getOrganismoXId((Long) tblOrganismos.getValueAt(tblOrganismos.getSelectedRow(), 0));
            DiagClientePersona diagClientePersona = new DiagClientePersona(null, true, "Organismo", "ModificaciónOrganismo", organismo, sucursal);
            diagClientePersona.setLocation(Comunes.centrarDialog(diagClientePersona));
            diagClientePersona.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un organismo");
        }
    }

    private void eliminarOrganismo() {
        if (tblOrganismos.getSelectedRow() != -1) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el Registro seleccionado?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                ClienteFacade.getInstance().eliminar((Long) tblOrganismos.getValueAt(tblOrganismos.getSelectedRow(), 0));
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un organismo");
        }

    }
}
