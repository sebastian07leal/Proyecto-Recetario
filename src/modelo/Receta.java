package modelo;

import java.util.*;



public class Receta {

    private int id; //El id es un numero único con el cual va a contar cada receta para su busqeuda en base de datos, este id se generara automaticamente
    private String nombre;
    private ArrayList<String> ingredientes;
    private String preparacion;
    private String clasificacion;
    private boolean favoritos = false;
    private byte facilidad;  //Esta variable solo debe almacenar numeros del 1 - 10 
    private byte cantidadDePersonas; //Esa variable solo debe almacenar numeros del 1 - 20;
    private float tiempoDePreparacion;
    private boolean propia = false;

    //Este constructor esta diseñado para realizar comunicaciones con esta  clase y sus metodos
    public Receta() {

    }

    //Este constructor esta diseñado para agregar, visualizar o editar una nueva receta
    public Receta(String nombre, ArrayList<String> ingredientes, String preparacion, String clasificacion, boolean favoritos, byte facilidad, byte cantidadDePesonas, float tiempoDePreparacion, boolean propia) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.clasificacion = clasificacion;
        this.favoritos = favoritos;
        this.facilidad = facilidad;
        this.cantidadDePersonas = cantidadDePesonas;
        this.tiempoDePreparacion = tiempoDePreparacion;
        this.propia = propia;

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

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    public byte getFacilidad() {
        return facilidad;
    }

    public void setFacilidad(byte facilidad) {
        this.facilidad = facilidad;
    }

    public byte getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(byte cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public float getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(float tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public boolean isPropia() {
        return propia;
    }

    public void setPropia(boolean propia) {
        this.propia = propia;
    }

}
