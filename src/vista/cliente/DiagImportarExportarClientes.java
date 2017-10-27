/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cliente;

import entidades.articulo.ListaPrecio;
import entidades.cliente.Cliente;
import entidades.persona.DocumentoIdentidad;
import entidades.persona.Telefono;
import entidades.persona.TipoDocumento;
import entidades.persona.TipoTelefono;
import facade.ClienteFacade;
import facade.ListaPrecioFacade;
import facade.TelefonoFacade;
import facade.TipoDocumentoFacade;
import facade.TipoTelefonoFacade;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
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
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author vouilloz
 */
public class DiagImportarExportarClientes extends javax.swing.JDialog {

    private Vector headers = new Vector();
    private Vector data = new Vector();
    private List<Cliente> listasCliente;
    private ModeloTablaNoEditable modeloTablaClientes;
    private ModeloTablaNoEditable modeloTablaOrganismos;
    private Cliente persona;
    private TipoTelefono tipotel;
    private Telefono telefono;
    private DocumentoIdentidad documento;
    private TipoDocumento tipoDoc;
    private ListaPrecio listaPrecio;
    SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form DiagImportarExportarClientes
     */
    public DiagImportarExportarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnImportarClientes = new javax.swing.JButton();
        btnExportarClientes = new javax.swing.JButton();
        btnGuardarListaClientes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        btnImportarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnImportarClientes.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarClientes.class, "DiagImportarExportarClientes.btnImportarClientes.text")); // NOI18N
        btnImportarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarClientesActionPerformed(evt);
            }
        });

        btnExportarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnExportarClientes.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarClientes.class, "DiagImportarExportarClientes.btnExportarClientes.text")); // NOI18N
        btnExportarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarClientesActionPerformed(evt);
            }
        });

        btnGuardarListaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardarListaClientes.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarClientes.class, "DiagImportarExportarClientes.btnGuardarListaClientes.text")); // NOI18N
        btnGuardarListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarListaClientesActionPerformed(evt);
            }
        });

        jButton1.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarClientes.class, "DiagImportarExportarClientes.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImportarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnGuardarListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnImportarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarListaClientes)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(DiagImportarExportarClientes.class, "DiagImportarExportarClientes.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarClientesActionPerformed
        importar();
    }//GEN-LAST:event_btnImportarClientesActionPerformed

    private void btnExportarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarClientesActionPerformed
        exportar();
    }//GEN-LAST:event_btnExportarClientesActionPerformed

    private void btnGuardarListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarListaClientesActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarListaClientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTablaClientesPersona(ClienteFacade.getInstance().getPersonas());
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
            java.util.logging.Logger.getLogger(DiagImportarExportarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagImportarExportarClientes dialog = new DiagImportarExportarClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExportarClientes;
    private javax.swing.JButton btnGuardarListaClientes;
    private javax.swing.JButton btnImportarClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables

    private void importar() {
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
            tblClientes.setModel(model);
        }

    }

    void leerDatosExcel(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
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
                    if (cell.getType() == CellType.DATE) {
                        System.out.println("fecha sin formatear: " + ((DateCell) cell).getDate());
                        System.out.println("fecha formateaada: " + sdf.format(((DateCell) cell).getDate()));
                        d.add(sdf.format(((DateCell) cell).getDate()));
                    } else {
                        d.add(cell.getContents());
                    }

                }
                d.add("\n");
                data.add(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private void exportar() {
        new ExportarExcel().crearExcelJtable(tblClientes, "Listado de Personas");
    }

    private void inicializarComponentes() {
        cargarTablaPersonas();
      }

    private void cargarTablaPersonas() {
        List<Integer> columnasNoEditables = new ArrayList<>();
        columnasNoEditables.add(0);
        columnasNoEditables.add(1);
        columnasNoEditables.add(2);
        columnasNoEditables.add(3);
        columnasNoEditables.add(4);
        columnasNoEditables.add(5);
        modeloTablaClientes = new ModeloTablaNoEditable(columnasNoEditables);
        cargarEncabezadosTabla(modeloTablaClientes);
    }


    private void cargarEncabezadosTabla(ModeloTablaNoEditable modeloTablaClientes) {
        //modeloTablaClientes.addColumn("ID");
        modeloTablaClientes.addColumn("Apellido");
        modeloTablaClientes.addColumn("Nombre");
        modeloTablaClientes.addColumn("tipo Documento dni");
        modeloTablaClientes.addColumn("Nro Dni");
        modeloTablaClientes.addColumn("Fecha Nacimiento");
        modeloTablaClientes.addColumn("Lista de Precio");
        tblClientes.setModel(modeloTablaClientes);
    }



    private void cargarCliente(Cliente persona) {
        int filas = modeloTablaClientes.getColumnCount();
        int numeroFila = 0;
        Object[] fila = new Object[filas];
        fila[numeroFila++] = persona.getApellido();
        fila[numeroFila++] = persona.getNombre();
        try {
            fila[numeroFila++] = persona.getDocumentoIdentidad().getTipoDocumento().toString();
        } catch (Exception e) {
            //fila[numeroFila++] = "";
        }

        fila[numeroFila++] = persona.getDocumentoIdentidad().getNumero();
        try {
            fila[numeroFila++] = formatFecha.format(persona.getFechaNacimiento());
        } catch (Exception e) {
            // fila[numeroFila++] = "";
        }
        try {
            fila[numeroFila++] = persona.getListaPrecio().getDescripcion();
        } catch (Exception e) {
            //fila[numeroFila++] = "";
        }

        modeloTablaClientes.addRow(fila);
    }

    private void guardar() {

        int reply = JOptionPane.showConfirmDialog(null,
                "¿Desea guardar los cambios?", "Atualizar Clientes",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                guardarClientes();
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

    private void guardarClientes() {

        try {
            for (int i = 0; i < tblClientes.getRowCount(); i++) {

                if (!ClienteFacade.getInstance().getPersonaDni(tblClientes.getValueAt(i, 3).toString())) {
                    System.out.println("entroooooo");

                    persona = new Cliente();
                    documento = new DocumentoIdentidad();
                    tipoDoc = new TipoDocumento();
                    persona.setApellido(tblClientes.getValueAt(i, 0).toString());
                    persona.setNombre(tblClientes.getValueAt(i, 1).toString());

                    if (!tblClientes.getValueAt(i, 2).toString().isEmpty()) {
                        tipoDoc = (TipoDocumento) TipoDocumentoFacade.getInstance().buscarPorTipo(tblClientes.getValueAt(i, 2).toString().toUpperCase().trim());
                    } else {
                        System.out.println("no carga el tipo documento");
                    }
                    System.out.println("tipo documento" + tipoDoc);
                    documento.setNumero(tblClientes.getValueAt(i, 3).toString());
                    documento.setTipoDocumento(tipoDoc);
                    persona.setDocumentoIdentidad(documento);
                    try {
                        persona.setFechaNacimiento(formatFecha.parse(tblClientes.getValueAt(i, 4).toString()));
                    } catch (Exception e) {

                    }
                    if (!tblClientes.getValueAt(i, 5).toString().isEmpty()) {
                        listaPrecio = ListaPrecioFacade.getInstance().getPorDescripcion(tblClientes.getValueAt(i, 5).toString());
                        try {
                            listaPrecio.getId();
                            persona.setListaPrecio(listaPrecio);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Antes de importar los clientes debe \n"
                                    + "cargar correctamente las listas de precios \n"
                                    + "y verificar que el cliente posea lista de precio \n"
                                    + "en el archivo excel");
                            throw new Exception();
                        }
//                        if (listaPrecio != null) {
//                            persona.setListaPrecio(listaPrecio);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Antes de importar los clientes debe \n"
//                                    + "cargar correctamente las listas de precios \n"
//                                    + "y verificar que el cliente posea lista de precio \n"
//                                    + "en el archivo excel");
//                            throw new Exception();
//                        }

                    }

                    ClienteFacade.getInstance().alta(persona);

                } else {
                    documento = new DocumentoIdentidad();
                    tipoDoc = new TipoDocumento();
                    persona = ClienteFacade.getInstance().getPersonaXDni(tblClientes.getValueAt(i, 3).toString());
                    persona.setApellido(tblClientes.getValueAt(i, 0).toString());
                    persona.setNombre(tblClientes.getValueAt(i, 1).toString());

                    if (!tblClientes.getValueAt(i, 2).toString().isEmpty()) {
                        tipoDoc = (TipoDocumento) TipoDocumentoFacade.getInstance().buscarPorTipo(tblClientes.getValueAt(i, 2).toString().toUpperCase().trim());
                    } else {
                        System.out.println("no carga el tipo documento");
                    }

                    documento.setNumero(tblClientes.getValueAt(i, 3).toString());
                    documento.setTipoDocumento(tipoDoc);
                    persona.setDocumentoIdentidad(documento);
                    try {
                        persona.setFechaNacimiento(formatFecha.parse(tblClientes.getValueAt(i, 4).toString()));
                    } catch (Exception e) {

                    }
                    if (!tblClientes.getValueAt(i, 5).toString().isEmpty()) {
                        listaPrecio = ListaPrecioFacade.getInstance().getPorDescripcion(tblClientes.getValueAt(i, 5).toString());
                        try {
                            listaPrecio.getId();
                            persona.setListaPrecio(listaPrecio);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Antes de importar los clientes debe \n"
                                    + "cargar correctamente las listas de precios \n"
                                    + "y verificar que el cliente posea lista de precio \n"
                                    + "en el archivo excel");
                            throw new Exception();
                        }
//                        if (listaPrecio != null) {
//                            persona.setListaPrecio(listaPrecio);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Antes de importar los clientes debe \n"
//                                    + "cargar correctamente las listas de precios \n"
//                                    + "y verificar que el cliente posea lista de precio \n"
//                                    + "en el archivo excel");
//                            throw new Exception();
//                        }

                    }

                    ClienteFacade.getInstance().modificar(persona);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

    }


    private void cargarTablaClientesPersona(List<Cliente> personas) {
        modeloTablaClientes = new ModeloTablaNoEditable();
        cargarEncabezadosTabla(modeloTablaClientes);
        configurarTabla(tblClientes);
        try {
            cargarClientesPersona(personas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }
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

    private void cargarClientesPersona(List<Cliente> personas) {
        try {
            modeloTablaClientes = new ModeloTablaNoEditable();
            cargarEncabezadosTabla(modeloTablaClientes);
            for (Cliente persona : personas) {
                cargarCliente(persona);
            }
            tblClientes.setModel(modeloTablaClientes);
        } catch (Exception ex) {
            Logger.getLogger(DiagImportarExportarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
