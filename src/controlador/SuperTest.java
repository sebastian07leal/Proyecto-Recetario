package controlador;

import controlador.*;
import modelo.*;
import vista.*;

//Esta clase es momentane y sirve para ayudar al desarrollador
public class SuperTest {

    private Operadora operadora = new Operadora();
    private Archivar archivar = new Archivar(); 

    public SuperTest() {

    }

    public void mostrarColeccionDeUsuarios() {

        archivar.traerListadoDeUsuarios();
        System.out.println(archivar.getListaDeUsuarios());
        System.out.println();
    }

    public void mostrarRecetas(String nombre) {

        archivar.traerRcetas(nombre);
        System.out.println(archivar.getRecetasDeUsuario());
    }

}
