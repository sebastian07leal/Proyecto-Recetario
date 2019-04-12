package vista;

import controlador.Operadora;
import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private Operadora operadora;
    //Toca revizar si son necesarios
    private String usuario;
    private String contrasena;

    //Constructor para agregar parametros 
    public Menu(String usario, String pasword) {
        this.usuario = usario;
        this.contrasena = pasword;
    }

    //Este constructor está diseñado para la comunicacion entre clases 
    public Menu() {

    }

    //Este metodo simula la interfaz de usuario (Iniciar Sesion) 
    public void iniciarSecion() {
        this.operadora = new Operadora();
        sc = new Scanner(System.in);
        byte exit = -1; 
              
        do {     
            
            System.out.println("*Acontinuacion ingrese su usuario y contraseña\n");
            System.out.println("Usuario\n");
            this.usuario = sc.nextLine(); 
            System.out.println("  \nContraseña\n");
            this.contrasena = sc.nextLine();
            System.out.println();
            
            //Se envia la informacion a logica para que valide si el usuario es correcto o no 
            operadora.getLogica().ValidarUsuario(usuario, contrasena);

            
            
        } while (exit == 0);
        
        
        
        
        
    }

    //Este metodo simula la interfaz de usuario desde el menu (Home)
    public void generarMenu() {

        sc = new Scanner(System.in);
        byte exit = -1;

        do {

            System.out.println("*Acontinuacion ingrese la accion que desea realizar \n");
            System.out.println("1. Para añadir una receta");
            System.out.println("2. Para ver mis recetas");
            System.out.println("3. Para ver todas las recetas");
            System.out.println("4. Para ver recetas favoritas");
            System.out.println("5. Para salir");

            try {

                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Estoy en añadir receta");

                        break;
                    case 2:
                        System.out.println("Estoy viendo mis recetas");
                        break;
                    case 3:
                        System.out.println("Estoy viendo todas las recetas");
                        break;
                    case 4:
                        System.out.println("Estoy viendo recetas favoritas");
                        break;
                    case 5:
                        exit = -1;
                        break;
                    default:
                        System.out.println("Opcion no permitida\nIntentalo de nuevo\n");
                        exit = 0;
                        break;
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Lo siento solo se permite ingrezar numeros enteros");
            }

        } while (exit == 0);

    }

    
    
    //Get y Set permiten ver las contraseñas ingresadas por el usuario pero no cambiarlas
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

}
