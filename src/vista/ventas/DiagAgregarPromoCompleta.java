/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventas;

import entidades.articulo.Articulo;
import entidades.promocion.PromocionArticulo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author ruben
 */
public class DiagAgregarPromoCompleta extends java.awt.Dialog {
    
    private List<PromocionArticulo> listaRecibida;
    private List<ArticuloCantidad> articulosCantidad;

    /**
     * Creates new form DiagAgregarPromoCompleta
     */
    public DiagAgregarPromoCompleta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DiagAgregarPromoCompleta(java.awt.Frame parent, boolean modal,List<PromocionArticulo> lista) {
        super(parent, modal);
        initComponents();
        listaRecibida = lista;
        inicializarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jBtnAceptar.setText(org.openide.util.NbBundle.getMessage(DiagAgregarPromoCompleta.class, "DiagAgregarPromoCompleta.jBtnAceptar.text")); // NOI18N
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });
        add(jBtnAceptar, java.awt.BorderLayout.SOUTH);
        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        articulosCantidad = new ArrayList<>();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        agregarPromoCompleta();
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagAgregarPromoCompleta dialog = new DiagAgregarPromoCompleta(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void inicializarComponentes(){
       
        jPanel1.setLayout(new VerticalLayout());
        articulosCantidad = new ArrayList<>();
        for(PromocionArticulo p: listaRecibida){
            ArticuloCantidad a = new ArticuloCantidad();
            a.setArticulo(p.getArticulo());
            a.setTextField(new JTextField());
            articulosCantidad.add(a);
        }
        
        for(ArticuloCantidad ac: articulosCantidad){
            Component label = new JLabel(ac.getArticulo().getDescripcion());
            Component text = ac.getTextField();
            jPanel1.add(label);
            jPanel1.add(text,BorderLayout.AFTER_LAST_LINE);
            
        }
        jPanel1.revalidate();
        validate();
        pack();
    }
    
    public void agregarPromoCompleta(){
        boolean flag = false;
        for(ArticuloCantidad a: articulosCantidad){
            if(a.getTextField().getText().equals("")){
                flag = true;
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(null, "debe seleccionar las cantidades","error en cantidades", JOptionPane.ERROR);        
            articulosCantidad = new ArrayList<>();
        }else{
            this.dispose();
        }
    }
    
    public List<ArticuloCantidad> returnListaCantidades(){
        return articulosCantidad;
    }
    
    public class ArticuloCantidad{
        Articulo articulo;
        JTextField textField;

        public Articulo getArticulo() {
            return articulo;
        }

        public void setArticulo(Articulo articulo) {
            this.articulo = articulo;
        }

        public JTextField getTextField() {
            return textField;
        }

        public void setTextField(JTextField textField) {
            this.textField = textField;
        }
        
        
    }
}
