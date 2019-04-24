package vista;

import controlador.Operadora;
import controlador.SuperTest;

public class Principal {

    public static void main(String[] args) {
        SuperTest test = new SuperTest();
        Operadora operadora = new Operadora();

        //Inico del programa
        operadora.getMenu().initPage();

         //Ver datos de usuario
        //test.mostrarColeccionDeUsuarios();
        

        

    }

}
