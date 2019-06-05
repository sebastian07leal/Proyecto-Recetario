/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Archivar;
import controlador.Operadora;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Receta;

/**
 *
 * @author DUARTE MENDEZ
 */
public class EditarReceta extends javax.swing.JPanel {
    private Principal principal;
    private Archivar archivar;
    private Operadora operadora;
    /**
     * Creates new form AñadirReceta
     */
    public EditarReceta(Principal principal) {
        this.principal=principal;
        this.archivar=new Archivar();
        initComponents();
        
        ArrayList<Receta> receta= new ArrayList <Receta>();
        archivar.traerRcetas(principal.getUsuariotem());
        receta = archivar.getRecetasDeUsuario();
        nombre.setText(receta.get(principal.getUbicacion()).getNombre());
        ingredientes.setText(receta.get(principal.getUbicacion()).getIngredientes());
        preparacion.setText(receta.get(principal.getUbicacion()).getPreparacion());
        descripcion.setText(receta.get(principal.getUbicacion()).getDescripcion());
        
        cantplatos.setText(Integer.toString(receta.get(principal.getUbicacion()).getCantidadDePersonas()));
        
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
        nombretxt = new javax.swing.JLabel();
        marcaagua = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        ingredientestxt = new javax.swing.JLabel();
        ingredientes = new javax.swing.JTextField();
        preparaciontxt = new javax.swing.JLabel();
        preparacion = new javax.swing.JTextField();
        descripciontxt = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcantidadpersonas = new javax.swing.JLabel();
        cantplatos = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configusuario.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        configusuario.setForeground(new java.awt.Color(0, 51, 153));
        configusuario.setText("Configurar usuario");
        configusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configusuarioActionPerformed(evt);
            }
        });
        add(configusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 280, -1));

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscadorKeyPressed(evt);
            }
        });
        add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 10, 140, 40));

        buscar.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(0, 51, 153));
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 120, 40));

        nombretxt.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(255, 153, 0));
        nombretxt.setText("Nombre");
        add(nombretxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 90, -1));

        marcaagua.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 11)); // NOI18N
        marcaagua.setForeground(new java.awt.Color(255, 255, 255));
        marcaagua.setText("Easy Code");
        add(marcaagua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 80, -1));

        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 190, 30));

        ingredientestxt.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        ingredientestxt.setForeground(new java.awt.Color(255, 153, 0));
        ingredientestxt.setText("Ingredientes");
        add(ingredientestxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 150, -1));
        add(ingredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 260, 70));

        preparaciontxt.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        preparaciontxt.setForeground(new java.awt.Color(255, 153, 0));
        preparaciontxt.setText("Preparacion");
        add(preparaciontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 140, -1));
        add(preparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 260, 60));

        descripciontxt.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        descripciontxt.setForeground(new java.awt.Color(255, 153, 0));
        descripciontxt.setText("Descripcion");
        add(descripciontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 140, 30));
        add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 260, 80));

        cancelar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 51, 153));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 90, -1));

        guardar.setFont(new java.awt.Font("Sitka Text", 1, 11)); // NOI18N
        guardar.setForeground(new java.awt.Color(0, 51, 153));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Editar Receta");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Nombre.png"))); // NOI18N
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ingredientes.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 40, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Preparacion.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 40, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/descripcion.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 40, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Preparacion.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 40, 50));

        txtcantidadpersonas.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        txtcantidadpersonas.setForeground(new java.awt.Color(255, 153, 0));
        txtcantidadpersonas.setText("Cantidad de personas");
        add(txtcantidadpersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 200, 50));

        cantplatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantplatosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantplatosKeyTyped(evt);
            }
        });
        add(cantplatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 210, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo3.jpg"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void configusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configusuarioActionPerformed
        configusu();
    }//GEN-LAST:event_configusuarioActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        volver();
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        busqueda();
    }//GEN-LAST:event_buscarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        modificar();
    }//GEN-LAST:event_guardarActionPerformed

    private void cantplatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantplatosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_cantplatosKeyTyped

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') &&(c<'A' || c>'z')) evt.consume();
    }//GEN-LAST:event_nombreKeyTyped

    private void buscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) busqueda();
    }//GEN-LAST:event_buscadorKeyPressed

    private void cantplatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantplatosKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) modificar();
    }//GEN-LAST:event_cantplatosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantplatos;
    private javax.swing.JButton configusuario;
    private javax.swing.JTextField descripcion;
    private javax.swing.JLabel descripciontxt;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField ingredientes;
    private javax.swing.JLabel ingredientestxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel marcaagua;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombretxt;
    private javax.swing.JTextField preparacion;
    private javax.swing.JLabel preparaciontxt;
    private javax.swing.JLabel txtcantidadpersonas;
    // End of variables declaration//GEN-END:variables

    private void configusu() {
        principal.irConfigcuenta(this);
    }
    private void busqueda() {
        this.operadora=new Operadora();
        int p,j;
        if(buscador.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lo sentimos no has escrito un nombre");
        }else{
            p=operadora.getLogica().buscarReceta(principal.getUsuariotem(), buscador.getText());
            j=operadora.getLogica().buscarrecetapersona(principal.getUsuariotem(), buscador.getText());
            if(-1 == p && -1==j){
                JOptionPane.showMessageDialog(null, "no existe");
            }else{
                if(p!=-1){
                    principal.settipo("alcatraz");
                    principal.setUbicacion(p);
                }else if(j!=1){
                    principal.settipo("otro");
                    principal.setUbicacion(j);
                }
                principal.setNombrerec(buscador.getText());
                principal.irMostrarReceta(this);
            }
        }
        
    }
    private void volver() {
        principal.irMisRecetas(this);
    }

    private void modificar() {
        if(nombre.getText().equals("") || ingredientes.getText().equals("") || preparacion.getText().equals("") || descripcion.getText().equals("") || cantplatos.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tienes alguna casilla vacia");
        }else{
            ArrayList<Receta> receta= new ArrayList <Receta>();
            archivar.traerRcetas(principal.getUsuariotem());
            receta = archivar.getRecetasDeUsuario();
            
            receta.get(principal.getUbicacion()).setNombre(nombre.getText());
            receta.get(principal.getUbicacion()).setIngredientes(ingredientes.getText());
            receta.get(principal.getUbicacion()).setPreparacion(preparacion.getText());
            receta.get(principal.getUbicacion()).setDescripcion(descripcion.getText());
            receta.get(principal.getUbicacion()).setCantidadDePersonas(Integer.parseInt(cantplatos.getText()));
            archivar.sobreEscribirReceta(principal.getUsuariotem(), receta);
            principal.irMisRecetas(this);
            //operadora.getLogica().editarReceta(operadora.getLogica().ubicacionDeUsuarioPorIndice(principal.getUsuariotem()), receta.get(principal.getUbicacion()).getNombre() , listaDeEdiciones);
        }
    }
}
