package controlador;

import java.util.ArrayList;
import modelo.*;


public class Logica {
    //Este objeto nos permite conectarnos con la clase menu
    private Operadora operadora;
    //Estructura de datos para el manejo de las recetas y usuarios
    private ArrayList<Receta> recetas;
    private ArrayList<Usuario> usuario; 
    
    //estos usuarios va a ser momentaneos mientras se implementan las interfaces graficas
    
    private String userProfe = "profe";
    private String pasProfe = "profe123";
    private String user = "Sebastian";
    private String pas = "123123";
    public Logica() {
        this.operadora = new Operadora();
    }
    
    //validara si el usuario es correcto o no
    public boolean ValidarUsuario(){  
        
        return true; 
    }
    //valida el registro hecho
    public boolean ValidarRegistro(){
        
        return true; 
    }
    
    
    
    

    
}
