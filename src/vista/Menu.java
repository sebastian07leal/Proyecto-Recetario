package vista;

import controlador.*;
import java.util.*;
import modelo.Usuario;

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
        int respuestaDeUsuaario;
        byte exit = -1;
        do {
            System.out.println("\n");
            System.out.println("Acontinuacion  oprima el numero según la accion que desee realizar\n");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. ¿Has olvidado tu contraseña?");
            System.out.println("4. Salir");
            respuestaDeUsuaario = sc.nextInt();
            


            try {
                switch (respuestaDeUsuaario) {
                    case 1:
                        exit = -1;
                        iniciarSecion();
                        break;
                    case 2:
                        exit = -1;
                        crearUsuario();
                        break;
                    case 3:
                        exit = -1;
                        menuRecuperarCuenta();
                        break;
                    case 4:
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
            } catch (Exception e) {
                System.out.println("Al parecer hay un error");
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
            System.out.print("Desea cancelar ingrese: 'si', de lo contrario oprima otra tecla para continuar ");
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
                operadora.getLogica().validarInicoDeSesion(this.nombreIngresado, this.contrasenaIngresada);
            }
        } while (exit == 0);
    }

    public void crearUsuario() {
        this.operadora = new Operadora();
        sc = new Scanner(System.in);
        byte exit = -1;
        String salir = "";
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
            System.out.println("¿Desea guardar los cambios? ingrese 'si' de lo contrario oprima cualquier tecla");
            confirmar = sc.nextLine();

            //Se confirma si se quiere hacer el envio de los datos ingresados para
            if (confirmar.equals("si")) {
                //Si el registro es validado y crado se confirma 
                if (operadora.getLogica().ValidarRegistro(this.nombreIngresado, this.contrasenaIngresada, contrasena2, this.palabraIngresada)) {
                    System.out.println("El usuario a sido creado con exito\n");
                    generarMenu();
                } else {
                    System.out.println("Ha abido un error al crear el usuario");
                }
                exit = -1; //Sale del bucle 
            } else {
                System.out.println("Si decea volver al meni principal escriba 'si', de lo contrario oprima otra tecla para vovler a ingresar los datos "); //Da la opcion de vovler atras 
                salir = sc.nextLine();
                if (salir.equals("si")) {
                    exit = -1;
                    initPage(); //Envia al usuario a la pestaña de inicio
                } else {
                    //Reitera el ciclo para que el usuario pueda ingresar de nuevo sus datos
                    exit = 0;    //Reitera el ciclo hasta que se de una respuesta
                }

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
            System.out.println("5. Editar datos de cuenta (contraseña y pregunta de recuperacion)");
            System.out.println("6. Cerrar sesion");

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
                        System.out.println("Editar datos de cuenta ");
                        break;
                    case 6:
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

    public void menuRecuperarCuenta() {
        sc = new Scanner(System.in);
        operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios(); //Es obligatorio llamar este metodo parar poder obtener los datos de los usuarios
        //Se obtiene el nombre de usuario para ralizar la busqueda y traer los datos de dicho usuario
        System.out.println("Para recuperar su contraseña porfavor ingrese su nombre de usuario acontinuacion");
        this.nombreIngresado = sc.nextLine();
        //Se llama el metodo encargado de realizar la busqueda y el indice donde se encuentra en el array si el usuario no existe, se le da aviso al usuario
        System.out.println("Ingrese la palabra de recuperacion");
        this.palabraIngresada = sc.nextLine();

        if (operadora.getLogica().comprobarPalabra(this.nombreIngresado, this.palabraIngresada)) {
            System.out.println("Porfavor cambia tu contraseña y palabra");
        } else {
            System.out.println("la cuenta no existe o la palabra ingesada no coincide con la palabra de recuperacion");
            System.out.println("¿Desea intentarlo de nuevo? ingrese 'si',  de lo contrario oprima otra tecla");
            if (sc.nextLine().equals("si")) {
                menuRecuperarCuenta();
            } else {
                initPage();
            }
        }
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
