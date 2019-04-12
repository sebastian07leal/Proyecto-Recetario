package controlador;

import vista.*;
import modelo.*;

//Esta clase se va a encargar de comunicarse con las demas clases y enviar la respuesta 
public class Operadora {

    //Estos objetos permiten comunicarse con las demas clases
    private final Receta receta;
    private final Menu menu;
    private final Logica usauario;

    public Operadora() {

        this.receta = new Receta();
        this.menu = new Menu();
        this.usauario = new Logica();
        
        System.out.println("Hola ");

    }

    public Receta getReceta() {
        return receta;
    }

    public Menu getMenu() {
        return menu;
    }

}
