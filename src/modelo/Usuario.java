package modelo;

import java.io.Serializable;
import java.util.UUID;  //Esta libreria es necesaria para generar el id 

public class Usuario implements Serializable{

    private UUID id; //El id se generara automaticamente Segun el estandar RFC4122
    private String nombre;
    private String contrasena; 
    private String palabraDeRecuperaion; 
    
    //Constructor para comunicar 
    public Usuario(){
    }
    
    //Constructor para agregar un nuevo usuario
    public Usuario(String nombre, String contrasena, String recuperacion){      
        this.nombre = nombre; 
        this.contrasena = contrasena; 
        this.palabraDeRecuperaion = recuperacion; 
        this.id = generarID();        
    }
    
    //Este metodo genera el ID segun el estandar UUID
    public UUID generarID(){   
        UUID idusuario = UUID.randomUUID();
        return idusuario;
    }
    
    //Es necesario para visualizar de forma correcta lo creado en este obgeto
    public String toString(){
        return "\n***"+" El Id del usuario es: "+ id +", Nombre: " + nombre + ", Contraseña: " + contrasena + ", Palabra de recuperacion:" + palabraDeRecuperaion+"***";
    }

//Get y Set 
    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrsena() {
        return contrasena;
    }

    public void setContrsena(String contrsena) {
        this.contrasena = contrsena;
    }

    public String getPalabraDeRecuperacion() {
        return palabraDeRecuperaion;
    }

    public void setPalabraDeRecuperacion(String preguntaRecuperacion) {
        this.palabraDeRecuperaion = preguntaRecuperacion;
    }
    
    
    
    
}
