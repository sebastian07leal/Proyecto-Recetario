/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Operadora;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author DUARTE MENDEZ
 */
public class Configcuenta extends javax.swing.JPanel {
    private Principal principal;
    private Operadora operadora;
    /**
     * Creates new form Configcuenta
     */
    public Configcuenta(Principal principal) {
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

        cambiotxt = new javax.swing.JLabel();
        cambio2txt = new javax.swing.JLabel();
        eliminartxt = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        conficontra = new javax.swing.JPasswordField();
        palbrarecu = new javax.swing.JTextField();
        confipalabra = new javax.swing.JTextField();
        contraseñatxt = new javax.swing.JLabel();
        conficontrasetxt = new javax.swing.JLabel();
        palabratxt = new javax.swing.JLabel();
        confipalabratxt = new javax.swing.JLabel();
        contraseñaactualtxt = new javax.swing.JLabel();
        contraseñaactual = new javax.swing.JPasswordField();
        eliminar = new javax.swing.JButton();
        guardarpalabra = new javax.swing.JButton();
        guardarcontraseña = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        marcaagua = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cambiotxt.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        cambiotxt.setForeground(new java.awt.Color(255, 255, 255));
        cambiotxt.setText("Cambio de contraseña");
        add(cambiotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 49, -1, -1));

        cambio2txt.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        cambio2txt.setForeground(new java.awt.Color(255, 255, 255));
        cambio2txt.setText("Cambio de palabra de recuperacion");
        add(cambio2txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 256, -1, -1));

        eliminartxt.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        eliminartxt.setForeground(new java.awt.Color(255, 255, 255));
        eliminartxt.setText("Eliminar cuenta");
        add(eliminartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 409, -1, -1));

        contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 111, 223, 39));

        conficontra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        conficontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                conficontraKeyPressed(evt);
            }
        });
        add(conficontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 168, 223, 39));

        palbrarecu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(palbrarecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 299, 221, 37));

        confipalabra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confipalabra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confipalabraKeyPressed(evt);
            }
        });
        add(confipalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 347, 221, 37));

        contraseñatxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        contraseñatxt.setForeground(new java.awt.Color(255, 255, 255));
        contraseñatxt.setText("contraseña");
        add(contraseñatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 118, -1, -1));

        conficontrasetxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        conficontrasetxt.setForeground(new java.awt.Color(255, 255, 255));
        conficontrasetxt.setText("confirme contraseña");
        add(conficontrasetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 168, -1, -1));

        palabratxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        palabratxt.setForeground(new java.awt.Color(255, 255, 255));
        palabratxt.setText("Palabra de recuperacion");
        add(palabratxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 299, -1, -1));

        confipalabratxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        confipalabratxt.setForeground(new java.awt.Color(255, 255, 255));
        confipalabratxt.setText("Repita la palabra");
        add(confipalabratxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 347, -1, -1));

        contraseñaactualtxt.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        contraseñaactualtxt.setForeground(new java.awt.Color(255, 255, 255));
        contraseñaactualtxt.setText("Contraseña Actual");
        add(contraseñaactualtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 461, -1, -1));

        contraseñaactual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contraseñaactual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaactualKeyPressed(evt);
            }
        });
        add(contraseñaactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 459, 233, 31));

        eliminar.setBackground(new java.awt.Color(204, 0, 51));
        eliminar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        eliminar.setForeground(new java.awt.Color(102, 204, 0));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 465, -1, -1));

        guardarpalabra.setBackground(new java.awt.Color(204, 0, 51));
        guardarpalabra.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        guardarpalabra.setForeground(new java.awt.Color(102, 204, 0));
        guardarpalabra.setText("Guardar");
        guardarpalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarpalabraActionPerformed(evt);
            }
        });
        add(guardarpalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 330, -1, -1));

        guardarcontraseña.setBackground(new java.awt.Color(204, 0, 51));
        guardarcontraseña.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        guardarcontraseña.setForeground(new java.awt.Color(102, 204, 0));
        guardarcontraseña.setText("Guardar");
        guardarcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarcontraseñaActionPerformed(evt);
            }
        });
        add(guardarcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 148, -1, -1));

        volver.setBackground(new java.awt.Color(204, 0, 51));
        volver.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        volver.setForeground(new java.awt.Color(102, 204, 0));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 11, -1, -1));

        marcaagua.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 11)); // NOI18N
        marcaagua.setForeground(new java.awt.Color(255, 255, 255));
        marcaagua.setText("Easy Code");
        add(marcaagua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        menu();
    }//GEN-LAST:event_volverActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        eliminarcuenta();
    }//GEN-LAST:event_eliminarActionPerformed

    private void guardarcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarcontraseñaActionPerformed
        cambiocontraseña();
    }//GEN-LAST:event_guardarcontraseñaActionPerformed

    private void guardarpalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarpalabraActionPerformed
        cambiopalabra();
    }//GEN-LAST:event_guardarpalabraActionPerformed

    private void conficontraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conficontraKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) cambiocontraseña();
    }//GEN-LAST:event_conficontraKeyPressed

    private void confipalabraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confipalabraKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) cambiopalabra();
    }//GEN-LAST:event_confipalabraKeyPressed

    private void contraseñaactualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaactualKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) eliminarcuenta();
    }//GEN-LAST:event_contraseñaactualKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cambio2txt;
    private javax.swing.JLabel cambiotxt;
    private javax.swing.JPasswordField conficontra;
    private javax.swing.JLabel conficontrasetxt;
    private javax.swing.JTextField confipalabra;
    private javax.swing.JLabel confipalabratxt;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JPasswordField contraseñaactual;
    private javax.swing.JLabel contraseñaactualtxt;
    private javax.swing.JLabel contraseñatxt;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel eliminartxt;
    private javax.swing.JButton guardarcontraseña;
    private javax.swing.JButton guardarpalabra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel marcaagua;
    private javax.swing.JLabel palabratxt;
    private javax.swing.JTextField palbrarecu;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    private void menu() {
        principal.irmenu(this);
    }
   

    private void cambiocontraseña() {
        this.operadora = new Operadora();
        if(contraseña.getText().equals("") || conficontra.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Alguna casilla esta vacia");
        }else{
            switch(operadora.getLogica().cambiarContrasena(principal.getUsuariotem(), contraseña.getText(), conficontra.getText())){
                case 0:
                    JOptionPane.showMessageDialog(null, "Cambio de contraseña acertado");
                    contraseña.setText("");
                    conficontra.setText("");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Contraseñas no coinciden");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al momento de guardar en base de datos");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Manin Error de parametros");
                    break;
            }
        }
    }

    private void cambiopalabra() {
        this.operadora = new Operadora();
        if(palbrarecu.getText().equals("") || confipalabra.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Alguna casilla esta vacia");
        }else{
            switch(operadora.getLogica().cambiarPalabra(principal.getUsuariotem(), palbrarecu.getText(), confipalabra.getText())){
                case 0:
                    JOptionPane.showMessageDialog(null, "Cambio de palabra acertado");
                    palbrarecu.setText("");
                    confipalabra.setText("");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Palabras no coinciden");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "No se encontro al usuario");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en persistencia");
                    break;
            }
        }
    }

    private void eliminarcuenta() {
        this.operadora = new Operadora();
        if(contraseñaactual.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Porfavor digite una contraseña");
        }else{
            if(operadora.getLogica().eliminarUsuario(operadora.getLogica().ubicacionDeUsuarioPorIndice(principal.getUsuariotem()), contraseñaactual.getText())){
                principal.iriniciars(this);
                JOptionPane.showMessageDialog(null, "Lamentamos que tengas que hacerlo");
            }else{
                JOptionPane.showMessageDialog(null, "Uy tu contraseña actual no es esa");
            }
        }
        
        
    }
}
