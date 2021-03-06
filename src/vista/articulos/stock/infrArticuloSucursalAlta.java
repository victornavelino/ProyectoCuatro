/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ArticuloAlta.java
 *
 * Created on 12/10/2009, 14:29:17
 */
package vista.articulos.stock;

import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.stock.ArticuloDeposito;
import entidades.articulo.stock.Deposito;
import facade.ArticuloSucursalFacade;
import includes.Comunes;
import includes.SuperInternalFrame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author carlos
 */
public class infrArticuloSucursalAlta extends SuperInternalFrame {

    // Atributos    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU");
    EntityManager em = emf.createEntityManager();
    Query quArticulo = em.createQuery("SELECT a FROM Articulo a");
    List listArticulo = quArticulo.getResultList();
    Articulo articulo = new Articulo();
    List listArticulosFiltrados;
    Query quDeposito = em.createQuery("SELECT d FROM Deposito d");
    List listDeposito = quDeposito.getResultList();
    Query quPuesto = em.createQuery("SELECT p FROM Puesto p");
    List listPuesto = quPuesto.getResultList();
    ArticuloDeposito articuloDeposito = new ArticuloDeposito();
    ArticuloSucursalFacade ArticuloSucursalFacade;

    /** Creates new form ArticuloAlta */
    public infrArticuloSucursalAlta() {
        this.ArticuloSucursalFacade = ArticuloSucursalFacade.getInstance();
        initComponents();
        inicializarComponentes();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        lbDescripcion = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistArticulosFiltrados = new javax.swing.JList();
        jXPanel7 = new org.jdesktop.swingx.JXPanel();
        lbDescripcion1 = new javax.swing.JLabel();
        cboDeposito = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        tfCantidad = new javax.swing.JTextField();
        btAsignar = new javax.swing.JButton();
        jXPanel8 = new org.jdesktop.swingx.JXPanel();
        lbDescripcion2 = new javax.swing.JLabel();
        cboPuesto = new javax.swing.JComboBox();
        lbDescripcionSeleccionada = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ASIGNACION DE ARTICULOS A SUCURSAL");
        setToolTipText("");

        jXPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("ARTICULO"));

        lbDescripcion.setText("Descrip.");

        tfDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescripcionKeyReleased(evt);
            }
        });

        jlistArticulosFiltrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistArticulosFiltradosMouseClicked(evt);
            }
        });
        jlistArticulosFiltrados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistArticulosFiltradosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jlistArticulosFiltrados);

        javax.swing.GroupLayout jXPanel6Layout = new javax.swing.GroupLayout(jXPanel6);
        jXPanel6.setLayout(jXPanel6Layout);
        jXPanel6Layout.setHorizontalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel6Layout.setVerticalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jXPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("DEPOSITO"));

        lbDescripcion1.setText("Descrip.");

        cboDeposito.setEnabled(false);

        javax.swing.GroupLayout jXPanel7Layout = new javax.swing.GroupLayout(jXPanel7);
        jXPanel7.setLayout(jXPanel7Layout);
        jXPanel7Layout.setHorizontalGroup(
            jXPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescripcion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel7Layout.setVerticalGroup(
            jXPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescripcion1)
                    .addComponent(cboDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setText("CANTIDAD");

        tfCantidad.setEnabled(false);
        tfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCantidadKeyReleased(evt);
            }
        });

        btAsignar.setText("Asignar");
        btAsignar.setEnabled(false);
        btAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAsignarActionPerformed(evt);
            }
        });

        jXPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("SUCURSAL"));

        lbDescripcion2.setText("Descrip.");

        cboPuesto.setEnabled(false);

        javax.swing.GroupLayout jXPanel8Layout = new javax.swing.GroupLayout(jXPanel8);
        jXPanel8.setLayout(jXPanel8Layout);
        jXPanel8Layout.setHorizontalGroup(
            jXPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDescripcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel8Layout.setVerticalGroup(
            jXPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescripcion2)
                    .addComponent(cboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbDescripcionSeleccionada)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescripcionSeleccionada))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAsignar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescripcionKeyReleased
        filtrarListaArticulos();
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jlistArticulosFiltrados.requestFocus();
            jlistArticulosFiltrados.setSelectedIndex(0);
        }
}//GEN-LAST:event_tfDescripcionKeyReleased

    private void jlistArticulosFiltradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistArticulosFiltradosMouseClicked
        actualizarArticuloDesdeListaFiltrada();
}//GEN-LAST:event_jlistArticulosFiltradosMouseClicked

    private void jlistArticulosFiltradosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistArticulosFiltradosValueChanged
        actualizarArticuloDesdeListaFiltrada();
        cboDeposito.setEnabled(true);
        cboPuesto.setEnabled(true);
        tfCantidad.setEnabled(true);
}//GEN-LAST:event_jlistArticulosFiltradosValueChanged

    private void btAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAsignarActionPerformed
        asignar();
        this.dispose();
    }//GEN-LAST:event_btAsignarActionPerformed

    private void tfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyReleased
        if (!Comunes.validarInteger(tfCantidad.getText())) {
            if (tfCantidad.getText().length() > 1) {
                tfCantidad.setText(tfCantidad.getText().substring(0,
                        tfCantidad.getText().length() - 1));
            } else {
                tfCantidad.setText("");
                btAsignar.setEnabled(false);
            }
        } else {
            btAsignar.setEnabled(true);
        }
    }//GEN-LAST:event_tfCantidadKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAsignar;
    private javax.swing.JComboBox cboDeposito;
    private javax.swing.JComboBox cboPuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private org.jdesktop.swingx.JXPanel jXPanel7;
    private org.jdesktop.swingx.JXPanel jXPanel8;
    private javax.swing.JList jlistArticulosFiltrados;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbDescripcion1;
    private javax.swing.JLabel lbDescripcion2;
    private javax.swing.JLabel lbDescripcionSeleccionada;
    private javax.swing.JTextField tfCantidad;
    private javax.swing.JTextField tfDescripcion;
    // End of variables declaration//GEN-END:variables

    public void inicializarComponentes() {
        cargarListaArticuloTodos();
        cargarComboBoxDeposito();
        cargarComboBoxPuesto();
    }

    public void filtrarListaArticulos() {
        emf = Persistence.createEntityManagerFactory("ProyectoCuatroPU");
        em = emf.createEntityManager();
        quArticulo = em.createQuery("SELECT a FROM Articulo a WHERE a.descripcion LIKE '%" + tfDescripcion.getText() + "%'" +
                " OR a.descripcionReducida LIKE '%" + tfDescripcion.getText() + "%'");
        listArticulosFiltrados = quArticulo.getResultList();
        cargarListaArticulos();
    }

    public void cargarListaArticuloTodos() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 0; i < listArticulo.size(); i++) {
            listaModelo.addElement(listArticulo.get(i));
        }
        jlistArticulosFiltrados.setModel(listaModelo);
    }

    public void cargarListaArticulos() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 0; i < listArticulosFiltrados.size(); i++) {
            listaModelo.addElement(listArticulosFiltrados.get(i));
        }
        jlistArticulosFiltrados.setModel(listaModelo);
    }

    public void actualizarArticuloDesdeListaFiltrada() {
        articulo = (Articulo) jlistArticulosFiltrados.getSelectedValue();
        lbDescripcionSeleccionada.setText(articulo.toString());

    }

    public void cargarComboBoxDeposito() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (int i = 0; i < listDeposito.size(); i++) {
            modeloCombo.addElement(listDeposito.get(i));
        }
        cboDeposito.setModel(modeloCombo);
    }

    public void cargarComboBoxPuesto() {
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (int i = 0; i < listPuesto.size(); i++) {
            modeloCombo.addElement(listPuesto.get(i));
        }
        cboPuesto.setModel(modeloCombo);
    }

    public void asignar() {
        articuloDeposito.setArticulo((Articulo) jlistArticulosFiltrados.getSelectedValue());
        articuloDeposito.setDeposito((Deposito) cboDeposito.getSelectedItem());
        ArticuloSucursalFacade.transferirArticuloDesdeDepositoASucursal(articuloDeposito, (Sucursal) cboPuesto.getSelectedItem(), Long.parseLong(tfCantidad.getText()));
        articuloDeposito = new ArticuloDeposito();
    }
}
