/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Caja;

import entidades.Sucursal;
import entidades.caja.Caja;
import entidades.caja.CobroVenta;
import entidades.caja.CuentaCorriente;
import entidades.caja.CuponTarjeta;
import facade.CuentaCorrienteFacade;
import facade.CuponTarjetaFacade;
import facade.MovimientoCajaFacade;
import includes.Comunes;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author root
 */
public class DiagListadoCobroTarjeta extends javax.swing.JDialog {

    private final Caja caja;
    private Sucursal sucursal;
    private List<CuponTarjeta> listaCuponesTarjeta;
    private ModeloTablaNoEditable modeloTablaTarjetas;
    private ModeloTablaNoEditable modeloTablaCobroVenta;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private ModeloTablaNoEditable modeloTablaCuentaCorriente;

    /**
     * Creates new form DiagListadoCobroTarjeta
     *
     * @param parent
     * @param modal
     * @param caja
     */
    public DiagListadoCobroTarjeta(java.awt.Frame parent, boolean modal, Caja caja) {
        super(parent, modal);
        initComponents();
        this.caja = caja;
        inicialicarComponentes();
    }

    public DiagListadoCobroTarjeta(java.awt.Frame parent, boolean modal, Caja caja, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.caja = caja;
        this.sucursal = sucursal;
        inicialicarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTarjeta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEfectivo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCuentaC = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.jPanel1.border.title"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.jPanel2.border.title"))); // NOI18N

        tblTarjeta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTarjeta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.jPanel4.border.title"))); // NOI18N

        tblEfectivo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblEfectivo);
        if (tblEfectivo.getColumnModel().getColumnCount() > 0) {
            tblEfectivo.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title0")); // NOI18N
            tblEfectivo.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title1")); // NOI18N
            tblEfectivo.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title2")); // NOI18N
            tblEfectivo.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.jPanel5.border.title"))); // NOI18N

        tblCuentaC.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblCuentaC);
        if (tblCuentaC.getColumnModel().getColumnCount() > 0) {
            tblCuentaC.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title0")); // NOI18N
            tblCuentaC.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title1")); // NOI18N
            tblCuentaC.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title2")); // NOI18N
            tblCuentaC.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DiagListadoCobroTarjeta.class, "DiagListadoCobroTarjeta.tblEfectivoCC.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagListadoCobroTarjeta dialog = new DiagListadoCobroTarjeta(new javax.swing.JFrame(), true, new Caja());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblCuentaC;
    private javax.swing.JTable tblEfectivo;
    private javax.swing.JTable tblTarjeta;
    // End of variables declaration//GEN-END:variables

    private void inicialicarComponentes() {
        this.setTitle("Listado de Cobros de Tickets");
        listaCuponesTarjeta = new ArrayList<>();
        //CARGAMOS LAS TARJETAS
        for (CuponTarjeta cuponTarjeta : MovimientoCajaFacade.getInstance().getCuponesTarjetaDesdeFecha(caja.getFechaInicio())) {
            listaCuponesTarjeta.add(cuponTarjeta);
        }
        cargarTablaTarjetas(listaCuponesTarjeta);

        //CARGAMOS TODO
        cargarTablaEfectivo(MovimientoCajaFacade.getInstance().getVentasEnEfectivo(caja.getFechaInicio(), sucursal));

        //CARGAR TABLA CUENTACORRIENTE
        cargarTablaCuentaCorriente(CuentaCorrienteFacade.getInstance().getCuentasCCaja(caja.getFechaInicio()));
    }

    private void cargarTablaTarjetas(List<CuponTarjeta> listaCuponesTarjeta) {
        modeloTablaTarjetas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaTarjeta(modeloTablaTarjetas);
        configurarTabla(tblTarjeta);
        try {
            cargarTarjetas(listaCuponesTarjeta);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }

    }

    private void cargarTablaEfectivo(List<CobroVenta> listaCobroVentas) {
        modeloTablaCobroVenta = new ModeloTablaNoEditable();
        cargarEncabezadosTablaCobroVenta(modeloTablaCobroVenta);
        configurarTabla(tblEfectivo);
        try {
            cargarCobroVentas(listaCobroVentas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }

    }

    private void cargarTablaCuentaCorriente(List<CuentaCorriente> listaCuentaCorriente) {
        modeloTablaCuentaCorriente = new ModeloTablaNoEditable();
        cargarEncabezadosTablaCuentaCorriente(modeloTablaCuentaCorriente);
        configurarTabla(tblCuentaC);
        try {
            cargarCuentaCorrientes(listaCuentaCorriente);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }

    }

    private void cargarEncabezadosTablaTarjeta(ModeloTablaNoEditable modeloTablaTarjetas) {
        modeloTablaTarjetas.addColumn("Id");
        modeloTablaTarjetas.addColumn("Cliente");
        modeloTablaTarjetas.addColumn("PlanTarjeta");
        modeloTablaTarjetas.addColumn("Cupon");
        modeloTablaTarjetas.addColumn("Importe");
        modeloTablaTarjetas.addColumn("Nro Venta");
        modeloTablaTarjetas.addColumn("Fecha");
        tblTarjeta.setModel(modeloTablaTarjetas);
    }

    private void cargarEncabezadosTablaCobroVenta(ModeloTablaNoEditable modeloTablaCobroVenta) {
        modeloTablaCobroVenta.addColumn("Id");
        modeloTablaCobroVenta.addColumn("Sucursal");
        modeloTablaCobroVenta.addColumn("Total Efectivo");
        modeloTablaCobroVenta.addColumn("Total Tarjeta");
        modeloTablaCobroVenta.addColumn("Total Cuenta C");
        modeloTablaCobroVenta.addColumn("Nor Ticket");
        modeloTablaCobroVenta.addColumn("Cliente");
        modeloTablaCobroVenta.addColumn("Fecha");
        tblEfectivo.setModel(modeloTablaCobroVenta);
    }

    private void cargarEncabezadosTablaCuentaCorriente(ModeloTablaNoEditable modeloTablaCC) {
        modeloTablaCC.addColumn("Id");
        modeloTablaCC.addColumn("Sucursal");
        modeloTablaCC.addColumn("Importe");
        modeloTablaCC.addColumn("Nor Ticket");
        modeloTablaCC.addColumn("Cliente");
        modeloTablaCC.addColumn("Fecha");
        tblCuentaC.setModel(modeloTablaCC);
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

    private void cargarTarjetas(List<CuponTarjeta> listaCuponesTarjeta) {
        try {
            modeloTablaTarjetas = new ModeloTablaNoEditable();
            cargarEncabezadosTablaTarjeta(modeloTablaTarjetas);
            for (CuponTarjeta cuponTarjeta : listaCuponesTarjeta) {
                cargarTarjeta(cuponTarjeta);
            }

            tblTarjeta.setModel(modeloTablaTarjetas);
            Comunes.setOcultarColumnasJTable(tblTarjeta, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarCobroVentas(List<CobroVenta> listaCobroVentas) {
        try {
            modeloTablaCobroVenta = new ModeloTablaNoEditable();
            cargarEncabezadosTablaCobroVenta(modeloTablaCobroVenta);
            for (CobroVenta cobroVenta : listaCobroVentas) {
                  cargarCobroVenta(cobroVenta);
              
            }

            tblEfectivo.setModel(modeloTablaCobroVenta);
            Comunes.setOcultarColumnasJTable(tblEfectivo, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarCuentaCorrientes(List<CuentaCorriente> listaCuentaC) {
        try {
            modeloTablaCuentaCorriente = new ModeloTablaNoEditable();
            cargarEncabezadosTablaCuentaCorriente(modeloTablaCuentaCorriente);
            for (CuentaCorriente cc : listaCuentaC) {
                cargarCuentaCorriente(cc);
            }

            tblCuentaC.setModel(modeloTablaCuentaCorriente);
            Comunes.setOcultarColumnasJTable(tblCuentaC, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagListadoCobroTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarTarjeta(CuponTarjeta cuponTarjeta) {
        Object[] fila = new Object[7];
        fila[0] = cuponTarjeta.getId();
        fila[1] = cuponTarjeta.getCliente();
        fila[2] = cuponTarjeta.getPlanTarjeta();
        try {
            fila[3] = cuponTarjeta.getNroCupon();
        } catch (Exception e) {
            fila[3] = "";
        }

        fila[4] = cuponTarjeta.getImporteCuponConRecargo();
        try {
            fila[5] = cuponTarjeta.getVenta().getNumeroTicket();
        } catch (Exception e) {
        }

        try {
            fila[6] = formato.format(cuponTarjeta.getFecha());
        } catch (Exception e) {
        }

        modeloTablaTarjetas.addRow(fila);
    }

    private void cargarCobroVenta(CobroVenta cobroVenta) {
        Object[] fila = new Object[8];
        fila[0] = cobroVenta.getId();
        fila[1] = cobroVenta.getSucursal();
        fila[2] = cobroVenta.getImporte();
        fila[3] = MovimientoCajaFacade.getInstance().getTotalTarjetaDesdeFecha(cobroVenta.getVenta());
        fila[4] = CuentaCorrienteFacade.getInstance().getImporteCuentaVenta(cobroVenta.getVenta());
        fila[5] = cobroVenta.getVenta().getNumeroTicket();
        fila[6] = cobroVenta.getVenta().getCliente();
        try {
            fila[7] = formato.format(cobroVenta.getFecha());
        } catch (Exception e) {
        }

        modeloTablaCobroVenta.addRow(fila);
    }

    private void cargarCuentaCorriente(CuentaCorriente cc) {
        Object[] fila = new Object[6];
        fila[0] = cc.getId();
        fila[1] = cc.getVenta().getSucursal();
        fila[2] = cc.getImporteCtaCte();
        fila[3] = cc.getVenta().getNumeroTicket();
        fila[4] = cc.getCliente();
        try {
            fila[5] = formato.format(cc.getFecha());
        } catch (Exception e) {
        }

        modeloTablaCuentaCorriente.addRow(fila);
    }

    private void buscarPorCliente() {

    }

    private String getTipoPago(CobroVenta cobroVenta) {
        StringBuilder tipoPago = new StringBuilder();
        if (!CuponTarjetaFacade.getInstance().listarCuponesTarjetaVenta(cobroVenta.getVenta()).isEmpty()) {
            tipoPago.append("-Tarjeta de Credito");
        }
        if (CuentaCorrienteFacade.getInstance().getCuentaCorrienteTicket(cobroVenta.getVenta()) != null) {
            tipoPago.append("-Cuenta Corriente");
        }
        if (cobroVenta.getImporte().compareTo(BigDecimal.ZERO) != 0) {
            tipoPago.append("-Efectivo");
        }
        return tipoPago.toString();
    }
}
