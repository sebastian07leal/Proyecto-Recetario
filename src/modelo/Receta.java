package modelo;

import java.io.Serializable;

public class Receta implements Serializable {

    private int id; //El id es un numero único con el cual va a contar cada receta para su busqeuda en base de datos, este id se generara automaticamente
    private String nombre;
    private String descripcion; 
    private String ingredientes;
    private String preparacion;
    private boolean favoritos = false;
    private int cantidadDePersonas; //Esa variable solo debe almacenar numeros del 1 - 20;
    private boolean propia = false;

    //Este constructor esta diseñado para realizar comunicaciones con esta  clase y sus metodos
    public Receta() {

    }

    //Este constructor esta diseñado para agregar, visualizar o editar una nueva receta
    public Receta(String nombre, String ingredientes, String preparacion, boolean favoritos, int cantidadDePesonasI, boolean propia, String descripcionDeReceta) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.favoritos = favoritos;
        this.cantidadDePersonas = cantidadDePesonasI;
        this.propia = propia;
        this.descripcion = descripcionDeReceta; 

    }

    
    public String toString(){
        return "\n***"+"El nombre de la receta es: '"+ nombre+ 
                "', \nLos ingredientes de la receta son: '"+ingredientes+
                "', \nLa preparacion de la receta es: '"+preparacion+
                "',\nLa descripcion de la receta es: '"+descripcion+
                "', \nLa receta es propia: '"+propia+
                "',\nEsta en favoritos: '"+favoritos+
                "',\nLa cantidad de personas por racion: "+cantidadDePersonas+"***\n";
    }
    
    //Get Y Set permiten aceder y modificar los parametros de esta clase a excepción del id, el cual solo permite ver
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }
 
    public boolean isPropia() {
        return propia;
    }

    public void setPropia(boolean propia) {
        this.propia = propia;
    }

}
