/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Archivar;
import controlador.Operadora;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import modelo.Usuario;
/**
 *
 * @author P201
 */
public class Principal extends javax.swing.JFrame {
    private Menu1 menu1;
    private Iniciosesion iniciosesion;
    private AñadirReceta añadirreceta;
    private Configcuenta configcuenta;
    private Registrarse registrarse;
    private Recuperacuenta recuperacuenta;
    private Recetas recetas;
    private MisRecetas misRecetas;
    private EditarReceta editarReceta;
    private Tips tips;
    /**
     * Creates new form Principal
     */
    public Principal() {
        //initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setName("inicio");
        setTitle("Proyecto");
        setResizable(false);
        pack();
        setIconImage(getIconImage());
        setLocationRelativeTo(null);
        iniciar();
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/imagen4.jpg"));
        return retValue;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
        
        */
        
        Operadora operadora = new Operadora(); 
        Archivar archivar = new Archivar(); 
        
         archivar.traerListadoDeUsuarios();
         
         System.out.println(archivar.getListaDeUsuarios()); 

        
        
    }

    private void iniciar() {
        iniciosesion = new Iniciosesion(this);
        iniciosesion.setVisible(true);
        add(iniciosesion);
        pack();
        setLocationRelativeTo(null);        
    }
    protected void iriniciars(JPanel jPanel){
        remove(jPanel);
        iniciosesion = new Iniciosesion(this);
        iniciosesion.setVisible(true);
        add(iniciosesion);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irRegistrar(JPanel jPanel){
        remove(jPanel);
        registrarse = new Registrarse(this);
        registrarse.setVisible(true);
        add(registrarse);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irConfigcuenta(JPanel jPanel){
        remove(jPanel);
        configcuenta=new Configcuenta(this);
        configcuenta.setVisible(true);
        add(configcuenta);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irAñadirreceta(JPanel jPanel){
        remove(jPanel);
        añadirreceta= new AñadirReceta(this);
        añadirreceta.setVisible(true);
        add(añadirreceta);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irRecuperacuenta(JPanel jPanel){
        remove(jPanel);
        recuperacuenta=new Recuperacuenta(this);
        recuperacuenta.setVisible(true);
        add(recuperacuenta);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irmenu(JPanel jPanel){
        remove(jPanel);
        menu1= new Menu1(this);
        menu1.setVisible(true);
        add(menu1);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irRecetas(JPanel jPanel){
        remove(jPanel);
        recetas= new Recetas(this);
        recetas.setVisible(true);
        add(recetas);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irMisRecetas(JPanel jPanel) {
        remove(jPanel);
        misRecetas= new MisRecetas(this);
        misRecetas.setVisible(true);
        add(misRecetas);
        pack();
        setLocationRelativeTo(null);    
    }
    protected void irEditarReceta(JPanel jPanel){
        remove(jPanel);
        editarReceta= new EditarReceta(this);
        editarReceta.setVisible(true);
        add(editarReceta);
        pack();
        setLocationRelativeTo(null);
    }
    protected void irTips(JPanel jPanel){
        remove(jPanel);
        tips= new Tips(this);
        tips.setVisible(true);
        add(tips);
        pack();
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
