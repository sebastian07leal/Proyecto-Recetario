package controlador;

import java.util.ArrayList;
import modelo.*;

public class Logica {

    //Este objeto nos permite conectarnos con la clase menu
    private Operadora operadora;
    //Estructura de datos para el manejo de las recetas y usuarios
    private ArrayList<Receta> recetas;
    private ArrayList<Usuario> usuario;

    //estos usuarios va a ser momentaneos mientras se implementan las interfaces graficas
    private String userProfe = "profe";
    private String pasProfe = "profe123";
    private String user = "Sebastian";
    private String pas = "123123";

    public Logica() {
    }

    //validara si el usuario es correcto o no
    public void ValidarUsuario(String usuarioIngre, String paswIngre) {

        operadora = new Operadora();
        //Se debe realizar la comparacion con obgetos 
        //Solo se ha comparado sebastian 
        if (usuarioIngre.equals(user)) {
            if (paswIngre.equals(pas)) {
                operadora.getMenu().generarMenu();

            }
        } else {
            System.out.println();
            System.out.println("El usuario o contraseña ingresados no son correctos, intentelo de nuvo");
            operadora.getMenu().iniciarSecion();
        }

    }

    //valida el registro hecho
    public boolean ValidarRegistro() {

        operadora = new Operadora();
        return true;
    }

}
