package vista;

import controlador.Operadora;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tips extends javax.swing.JPanel {
    DefaultTableModel modelo;
    Principal principal;
    private Operadora operadora;
    public Tips(Principal principal) {
        this.operadora= new Operadora();
        this.principal=principal;
        initComponents();
        modelo= new DefaultTableModel();
        modelo.addColumn("---*TIPS*---");
        for (int i = 0; i < operadora.getLogica().traerTips().size(); i++) {
            String []almacenar = {operadora.getLogica().traerTips().get(i)};
            modelo.addRow(almacenar);
            
        }
        this.jTable1.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configusuario = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        recetas = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cerrarsesion = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        tipsintroducir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        añadir = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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

        add(recetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 710, 150));

        cerrarsesion.setBackground(new java.awt.Color(153, 153, 153));
        cerrarsesion.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        cerrarsesion.setForeground(new java.awt.Color(0, 51, 102));
        cerrarsesion.setText("Cerrar Sesion");
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        add(cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 553, 160, 30));

        volver.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        volver.setForeground(new java.awt.Color(0, 51, 102));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 160, 30));
        add(tipsintroducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 400, 30));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Tip");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 40, 30));

        añadir.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        añadir.setForeground(new java.awt.Color(0, 51, 102));
        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        add(añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 110, 30));

        editar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        editar.setForeground(new java.awt.Color(0, 51, 102));
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 110, 30));

        eliminar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        eliminar.setForeground(new java.awt.Color(0, 51, 102));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 110, 30));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Máximo 80 caracteres");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 160, 30));

        marcaagua.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 11)); // NOI18N
        marcaagua.setForeground(new java.awt.Color(255, 255, 255));
        marcaagua.setText("Easy Code");
        add(marcaagua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 80, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo3.jpg"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void configusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configusuarioActionPerformed
        configusu();
    }//GEN-LAST:event_configusuarioActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        salir();
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        volver();
    }//GEN-LAST:event_volverActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        busqueda();
    }//GEN-LAST:event_buscarActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        añadir();
        relogear();
    }//GEN-LAST:event_añadirActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        editar();
        relogear();
    }//GEN-LAST:event_editarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        elminar();
        relogear();
    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadir;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton configusuario;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel marcaagua;
    private javax.swing.JScrollPane recetas;
    private javax.swing.JTextField tipsintroducir;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
    private void busqueda() {
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
    private void configusu() {
        principal.irConfigcuenta(this);
    }

    private void volver() {
        principal.irmenu(this);
    }

    private void salir() {
        principal.iriniciars(this);
    }    

    private void añadir() {
        this.operadora=new Operadora();
        if(tipsintroducir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "escribe algo");
        }else{
            int obtener= tipsintroducir.getText().length();
            if(obtener <= 80){
                ArrayList<String> guardar= new ArrayList<String>();
                guardar= operadora.getLogica().traerTips();
                String uno= tipsintroducir.getText();
                guardar.add(uno);
                operadora.getLogica().guardarTips(guardar);
                JOptionPane.showMessageDialog(null, "Agregado con exito con exito vuelve a entrar a tips para verlo");
            }else{
                JOptionPane.showMessageDialog(null, "Es demasiado largo");
            }
        }
    }

    private void editar() {
        int fila = jTable1.getSelectedRow();
        this.operadora=new Operadora();
        if(tipsintroducir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "escribe algo");
        }else{
            int obtener= tipsintroducir.getText().length();
            if(obtener <= 80){
                if(fila>=0){
                    System.out.println(fila);
                    ArrayList<String> guardar= new ArrayList<String>();
                    guardar= operadora.getLogica().traerTips();
                    String uno= tipsintroducir.getText();
                    guardar.remove(fila);
                    guardar.add(fila, uno);
                    operadora.getLogica().guardarTips(guardar);
                    JOptionPane.showMessageDialog(null, "Editado con exito vuelve a entrar a tips para verlo");
                }else{
                    JOptionPane.showMessageDialog(null, "Porfavor selecciona una fila");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Es demasiado largo");
            }
        }
    }

    private void elminar() {
        
        int fila = jTable1.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(null, "porfavor seleccione una fila");
        }else{
            System.out.println(fila);
            ArrayList<String> guardar= new ArrayList<String>();
            guardar= operadora.getLogica().traerTips();            
            guardar.remove(fila);            
            operadora.getLogica().guardarTips(guardar);
        }
    }

    private void relogear() {
        principal.irTips(this);
    }
}
