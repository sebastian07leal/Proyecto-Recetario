/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Archivar;
import controlador.Operadora;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DUARTE MENDEZ
 */
public class MisRecetas extends javax.swing.JPanel {
    DefaultTableModel modelo;
    Principal principal;
    private Operadora operadora;
    private Archivar archivar;
    /**
     * Creates new form MisRecetas
     */
    public MisRecetas(Principal principal) {
        this.operadora=new Operadora();
        this.principal=principal;
        initComponents();
        modelo= new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("descripcion");
        this.jTable1.setModel(modelo);
        operadora.getLogica().verRecetas(operadora.getLogica().ubicacionDeUsuarioPorIndice(principal.getUsuariotem()), "propia");
        //System.out.println(operadora.getReceta());
        //DefaultTableModel addRow = modelo.addRow(archivar.traerRcetas(principal.getUsuariotem()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configusuario = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JButton();
        misrecetas = new javax.swing.JButton();
        recetas = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        marcaagua = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configusuario.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        configusuario.setForeground(new java.awt.Color(0, 51, 102));
        configusuario.setText("Configurar usuario");
        configusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configusuarioActionPerformed(evt);
            }
        });
        add(configusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 300, -1));

        buscador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 10, 140, 40));

        buscar.setBackground(new java.awt.Color(153, 153, 153));
        buscar.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(0, 51, 102));
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 120, 40));

        volver.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        volver.setForeground(new java.awt.Color(0, 51, 102));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 160, 30));

        cerrarsesion.setBackground(new java.awt.Color(153, 153, 153));
        cerrarsesion.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        cerrarsesion.setForeground(new java.awt.Color(0, 51, 102));
        cerrarsesion.setText("Cerrar Sesion");
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        add(cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 160, 30));

        misrecetas.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        misrecetas.setForeground(new java.awt.Color(0, 51, 102));
        misrecetas.setText("Recetas");
        misrecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misrecetasActionPerformed(evt);
            }
        });
        add(misrecetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 160, 30));

        jTable1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo.jpg")))); // NOI18N
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        recetas.setViewportView(jTable1);

        add(recetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 710, -1));

        editar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        editar.setForeground(new java.awt.Color(0, 51, 102));
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 160, 30));

        eliminar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 51, 102));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 160, 30));

        marcaagua.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 11)); // NOI18N
        marcaagua.setForeground(new java.awt.Color(255, 255, 255));
        marcaagua.setText("Easy Code");
        add(marcaagua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 80, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Fondo2.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void configusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configusuarioActionPerformed
        configusu();
    }//GEN-LAST:event_configusuarioActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        volver();
    }//GEN-LAST:event_volverActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        salir();
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void misrecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misrecetasActionPerformed
        recetas();
    }//GEN-LAST:event_misrecetasActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_eliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        buscar();
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton configusuario;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel marcaagua;
    private javax.swing.JButton misrecetas;
    private javax.swing.JScrollPane recetas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    private void configusu() {
        principal.irConfigcuenta(this);
    }

    private void volver() {
        principal.irmenu(this);
    }

    private void salir() {
        principal.iriniciars(this);
    }

    private void recetas() {
        principal.irRecetas(this);
    }

    private void editar() {
        principal.irEditarReceta(this);
    }

    private void eliminar() {
        this.operadora= new Operadora();
        //operadora.getLogica().eliminarR(operadora.getLogica().ubicacionDeUsuarioPorIndice(principal.getUsuariotem()), jTable1.getValueAt(jTable1MouseClicked(evt), jTable1MouseClicked(evt)));
        
        
    }
    private void buscar() {
        this.operadora=new Operadora();
        int p;
        if(buscador.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lo sentimos no has escrito un nombre");
        }else{
            p=operadora.getLogica().buscarReceta(operadora.getLogica().ubicacionDeUsuarioPorIndice(principal.getUsuariotem()), buscador.getText());
            if(-1 == p){
                JOptionPane.showMessageDialog(null, "no existe");
            }else{
                principal.setUbicacion(p);
                principal.setNombrerec(buscador.getText());
                principal.irMostrarReceta(this);
            }
        }
        
    }
}
