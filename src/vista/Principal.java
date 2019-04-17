package vista;

import controlador.Operadora;
import modelo.Usuario;//se va a traer de manera temporal para realizar pruebas

public class Principal {
    
    public static void main(String[] args) {

         Operadora operadora = new Operadora();
         
                  //Ver archivos en base de datos
        operadora.getArchivar().traerListadoDeUsuarios();
        System.out.println(operadora.getArchivar().getListaDeUsuarios());
        System.out.println();

         //Inico del programa
         operadora.getMenu().initPage();

         


//         operadora.getMenu().menuEditarPerfil("Sebastian");////////El error se encuentra en que el menu editar necesita saber cual es su usuario
         
         
        operadora.getArchivar().traerListadoDeUsuarios();
        System.out.println(operadora.getArchivar().getListaDeUsuarios());
        System.out.println();

    }

}
