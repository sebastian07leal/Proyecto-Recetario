package vista;

import controlador.Operadora;
import modelo.Usuario;//se va a traer de manera temporal para realizar pruebas

public class Principal {
    
    public static void main(String[] args) {

         Operadora operadora = new Operadora();

         //Inico del programa
         operadora.getMenu().initPage();
//
//


         
//         System.out.println(operadora.getLogica().comprobarPalabra("Sebastian", " soy el creador?"));

    }

}
