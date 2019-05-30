package controlador;

import modelo.*;
import vista.*;

//Esta clase se va a encargar de comunicarse con las demas clases y enviar la respuesta 
public class Operadora {

    //Estos objetos permiten comunicarse con las demas clases
    private final Receta receta;
    private final Menu menu;
    private final Logica logica;
    private final Usuario usuario;

    public Operadora() {

        this.receta = new Receta();
        this.menu = new Menu();
        this.logica = new Logica();
        this.usuario = new Usuario();
    }

    public Receta getReceta() {
        return receta;
    }

    public Menu getMenu() {
        return menu;
    }

    public Logica getLogica() {
        return logica;
    }

    public Usuario getUsuario() {
        return usuario;
    }


}
