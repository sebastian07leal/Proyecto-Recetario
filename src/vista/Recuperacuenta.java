/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Operadora;
import javax.swing.JOptionPane;

/**
 *
 * @author DUARTE MENDEZ
 */
public class Recuperacuenta extends javax.swing.JPanel {
    private Principal principal;
    private Operadora operadora;
    /**
     * Creates new form Recuperacuenta
     */
    public Recuperacuenta(Principal principal) {
        this.principal=principal;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textsuperior = new javax.swing.JLabel();
        usuariotext = new javax.swing.JLabel();
        palabratxt = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        palabrarecu = new javax.swing.JTextField();
        marcaagua = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textsuperior.setFont(new java.awt.Font("Sitka Text", 1, 48)); // NOI18N
        textsuperior.setForeground(new java.awt.Color(255, 255, 255));
        textsuperior.setText("Recuperacion de cuenta");
        add(textsuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 71, -1, 59));

        usuariotext.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        usuariotext.setForeground(new java.awt.Color(255, 255, 255));
        usuariotext.setText("Usuario");
        add(usuariotext, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 70, 20));

        palabratxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        palabratxt.setForeground(new java.awt.Color(255, 255, 255));
        palabratxt.setText("Palabra de recuperacion");
        add(palabratxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, 20));

        aceptar.setBackground(new java.awt.Color(204, 0, 51));
        aceptar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        aceptar.setForeground(new java.awt.Color(102, 204, 0));
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 138, 48));

        volver.setBackground(new java.awt.Color(204, 0, 51));
        volver.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        volver.setForeground(new java.awt.Color(102, 204, 0));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 138, 48));
        add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 183, -1));
        add(palabrarecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 183, -1));

        marcaagua.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 11)); // NOI18N
        marcaagua.setForeground(new java.awt.Color(255, 255, 255));
        marcaagua.setText("Easy Code");
        add(marcaagua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 80, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo.jpg"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        volver();
    }//GEN-LAST:event_volverActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        validar();
    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel marcaagua;
    private javax.swing.JTextField palabrarecu;
    private javax.swing.JLabel palabratxt;
    private javax.swing.JLabel textsuperior;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel usuariotext;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        principal.iriniciars(this);
    }

    private void validar() {
        this.operadora=new Operadora();
        if(usuario.getText().equals("")|| palabrarecu.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Espacios vacios");
        }else{
            switch(operadora.getLogica().comprobarPalabra(usuario.getText(), palabrarecu.getText())){
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Palabra de recuperacion correcta!");                    
                    principal.setUsuariotem(usuario.getText());
                    principal.irConfigcuenta(this);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Palabra de verificacion invalida");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Manin hay un error");
                    break;
            }            
        }
        usuario.setText("");
        palabrarecu.setText("");
    }
}
