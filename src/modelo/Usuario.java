package modelo;

public class Usuario {

    private String id; //El id se generara automaticamente 
    private String nombre;
    private String contrsena; 
    private String preguntaRecuperacion; 
    
    //Constructor para comunicar 
    public Usuario(){
        
    }
    //Constructor para agregar un nuevo usuario
    public Usuario(String nombre, String contrasena, String preguntasRecuperacion){
        
        this.nombre = nombre; 
        this.contrsena = contrasena; 
        this.preguntaRecuperacion = preguntasRecuperacion; 
        
    }

//Get y Set 
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrsena() {
        return contrsena;
    }

    public void setContrsena(String contrsena) {
        this.contrsena = contrsena;
    }

    public String getPreguntaRecuperacion() {
        return preguntaRecuperacion;
    }

    public void setPreguntaRecuperacion(String preguntaRecuperacion) {
        this.preguntaRecuperacion = preguntaRecuperacion;
    }
    
    
    
    
}
