package vista;

import controlador.Operadora;
import controlador.SuperTest;

public class Principal {
    
    public static void main(String[] args) {
        SuperTest  test = new SuperTest(); 
         Operadora operadora = new Operadora();
         

         //Inico del programa
         operadora.getMenu().initPage();

         //Test de eliminar receta 
         //operadora.getLogica().eliminarR(1, "funciono");
         
         //Ver recetas propias
         //operadora.getMenu().verRecetasPropias(1);
         
         //Metodo ver recetas LOGICA
         //operadora.getLogica().verRecetas(1, "global");
         
         //Ver recetas por usuario
         test.mostrarRecetas("Sebastian");
         
         //Ver datos de usuario
         //test.mostrarColeccionDeUsuarios();
         
         //test a buscar
         //operadora.getLogica().verResultadoBusqueda(1, 1);

    }


}
