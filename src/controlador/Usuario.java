

package controlador;

public class Usuario {
   
    private String usuario; 
    private String contraseña;
    
    public boolean usuario(String user, String pasword){
        
        this.usuario = user; 
        this.contraseña = pasword; 
        
        
        
        
        System.out.println("Entro a validar usuario "+" Usario: "+usuario+" Contraseña: "+contraseña);
        return true; 
    }
    
    
    public boolean registro(){   
        System.out.println("Entro al metodo de la clase usuario");
        return true; 
    }
    
    
    
}
