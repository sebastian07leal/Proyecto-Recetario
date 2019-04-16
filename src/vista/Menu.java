package vista;

import controlador.*;
import java.util.*;

public class Menu {

    private Scanner sc;
    private Operadora operadora;
    //Toca revizar si son necesarios
    private String nombreIngresado = "";
    private String contrasenaIngresada = "";
    private String palabraIngresada = "";

    //Este constructor está diseñado para la comunicacion entre clases 
    public Menu() {

    }

    //Esta panatalla se ejecutara de primeras
    public void initPage() {

        sc = new Scanner(System.in);
        byte exit = -1;
        do {
            System.out.println("\n");
            System.out.println("Acontinuacion ingrese la acción que desea realizar\n");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            try {
                switch (sc.nextInt()) {
                    case 1:
                        iniciarSecion();
                        break;
                    case 2:
                        crearUsuario();
                        break;
                    case 3:
                        exit = -1;  // -1 Es para que salga del bucle 
                        break;
                    default:
                        System.out.println("Opcion no permitida\nIntentalo de nuevo\n");
                        exit = 0;  // 0 Es para que repita el bucle
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Lo siento solo se permite ingrezar numeros enteros");
                initPage();
            }
        } while (exit == 0);
    }

    //Este metodo simula la interfaz de usuario (Iniciar Sesion) 
    public void iniciarSecion() {
        
        this.operadora = new Operadora();
        sc = new Scanner(System.in);
        byte exit = -1;

        do {
            System.out.println("*Acontinuacion ingrese su usuario y contraseña\n");
            System.out.print("Desea volver 'si/no' ");
            //Si quiere volver se regresara al menu inicial 
            if (sc.nextLine().equals("si")) {
                initPage();
            } else {
                System.out.println("Usuario\n");
                this.nombreIngresado = sc.nextLine();
                System.out.println("  \nContraseña\n");
                this.contrasenaIngresada = sc.nextLine();
                System.out.println();
                //Se envia la informacion a logica para que valide si el usuario es correcto o no 
                operadora.getLogica().ValidarUsuario(this.nombreIngresado, this.contrasenaIngresada);
            }
        } while (exit == 0);
    }

    public void crearUsuario() {
        this.operadora = new Operadora();
        sc = new Scanner(System.in);
        byte exit = -1;
        String contrasena2 = "";
        String confirmar = "";
        do {
            System.out.println("Acontinuacion ingrese los datos espesificados \n");
            System.out.println("Ingrese su nombre de usuario, no puede contener caracteres especiales");
            this.nombreIngresado = sc.nextLine();
            System.out.println("Ingrese su contraseña ");
            this.contrasenaIngresada = sc.nextLine();
            System.out.println("Confirme su contraseña");
            contrasena2 = sc.nextLine();
            System.out.println("Ingrese una palabra única, en caso de necesitar restablecer su contraseña");
            this.palabraIngresada = sc.nextLine();
            System.out.println();
            System.out.println("Desea enviar estos datos 'si/no ? '");
            confirmar = sc.nextLine();

            //Se confirma si se quiere hacer el envio de los datos ingresados para
            if (confirmar.equals("si")) {
                //Si el registro es validado y crado se confirma 
                if (operadora.getLogica().ValidarRegistro(this.nombreIngresado, this.contrasenaIngresada, contrasena2, this.palabraIngresada)) {
                    System.out.println("El usuario a sido creado con exito");
                } else {
                    System.out.println("Ha abido un error al crear el usuario");
                }
                exit = -1; //Sale del bucle 
            } else {
                //Rpetir el siclo hasta que la confirmacion sea 'si'
                exit = 0;    //Reitera el ciclo hasta que se de una respuesta
            }
        } while (exit == 0);
    }

    //Este metodo simula la interfaz de usuario desde el menu (Home)
    public void generarMenu() {
        sc = new Scanner(System.in);
        byte exit = -1;
        do {
            System.out.println("\n");
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
                        exit = -1; //Slago del ciclo
                        break;
                    default:
                        System.out.println("Opcion no permitida\nIntentalo de nuevo\n");
                        exit = 0; //Reitero el ciclo hasta tener una respuesta correcta 
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Lo siento solo se permite ingrezar numeros enteros");
                generarMenu();  //Hago  una llamada de nuevo para reiterar el ciclo 
            }
        } while (exit == 0);
    }

    //Get y Set permiten ver las contraseñas ingresadas por el usuario pero no cambiarlas
    public String getUsuario() {
        return this.nombreIngresado;
    }

    public String getContrasena() {
        return this.contrasenaIngresada;
    }

    public String getPalabraIngresada() {
        return this.palabraIngresada;
    }

}
