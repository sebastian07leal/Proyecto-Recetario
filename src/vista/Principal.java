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
        //Menu editar receta
        //operadora.getMenu().editarReceta(1);

//        String[] hola = new String[5]; 
//        hola[0] = "Nombre"; 
//        //hola[1] = "Descripcion"; 
//        hola[2] = "Ingredientes***"; 
//        hola[3] = "Preparacion***"; 
//        hola[4] = "50"; 
//        System.out.println("\n");
//        operadora.getLogica().editarReceta(1, "Pure de papa", hola);
        //Ver Recetas
    //    test.mostrarRecetas("Camilo");

    }

}
