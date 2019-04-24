package controlador;

import controlador.*;
import modelo.*;
import vista.*;

//Esta clase es momentane y sirve para ayudar al desarrollador
public class SuperTest {

    private Operadora operadora = new Operadora();

    public SuperTest() {

    }

    public void mostrarColeccionDeUsuarios() {

        operadora.getArchivar().traerListadoDeUsuarios();
        System.out.println(operadora.getArchivar().getListaDeUsuarios());
        System.out.println();
    }

    public void mostrarRecetas(String nombre) {

        operadora.getArchivar().traerRcetas(nombre);
        System.out.println(operadora.getArchivar().getRecetasDeUsuario());
    }

}
