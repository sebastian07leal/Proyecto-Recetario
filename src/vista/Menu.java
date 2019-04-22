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
    private Usuario datosDeUsuario;

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
            System.out.println("Usuario\n");
            this.nombreIngresado = sc.nextLine();
            System.out.println("  \nContraseña\n");
            this.contrasenaIngresada = sc.nextLine();
            System.out.println();

            System.out.print("Desea cancelar ingrese: 'si', de lo contrario oprima otra tecla para continuar ");
            if (sc.nextLine().equals("si")) {
                exit = -1;
                initPage();
            }
            //Se envia la informacion a logica para que valide si el usuario es correcto o no 
            operadora.getLogica().validarInicoDeSesion(this.nombreIngresado, this.contrasenaIngresada);

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
            System.out.println("Ingrese su nombre de usuario, no se podra cambiar posteriormente");
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
                    generarMenu(operadora.getLogica().ubicacionDeUsuarioPorIndice(nombreIngresado)); //Se le debe enviar el indice donde esta el usuario
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
    public void generarMenu(int indiceUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        datosDeUsuario = operadora.getLogica().objetoUsuarioEnIndice(indiceUsuario);
        byte exit = -1;

        do {
            System.out.println("\n");
            System.out.println("*Acontinuacion ingrese la accion que desea realizar \n");
            System.out.println("1. Para añadir una receta");
            System.out.println("2. Para ver mis recetas");
            System.out.println("3. Para ver todas las recetas");
            System.out.println("4. Para ver recetas favoritas");
            System.out.println("5. Configuracion de cuenta");
            System.out.println("6. Cerrar sesion");

            try {
                switch (sc.nextInt()) {
                    case 1:
                        exit = -1;
                        menuAgregarReceta(indiceUsuario);
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
                        menuEditarPerfil(datosDeUsuario.getNombre()); //Enviar usuario
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
                generarMenu(indiceUsuario);  //Hago  una llamada de nuevo para reiterar el ciclo 
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
            menuEditarPerfil(this.nombreIngresado);
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

    public void menuEditarPerfil(String usuarioIngresado) {
        this.operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();
        String nueva = "";
        String nuevaConfirmacion;
        String contrasenaDeConfirmacion;

        sc = new Scanner(System.in);
        int exit = -1;
        do {
            System.out.println("Ingrese a continuacion las valores que desea editar");
            System.out.println("1. Cambiar contraseña");
            System.out.println("2. Cambiar palabra de recuperacion");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Cancelar");
            try {
                switch (sc.nextInt()) {
                    case 1:
                        exit = -1;
                        System.out.println("Ingrese la nueva contraseña");
                        nueva = sc.next();
                        System.out.println("Ingrese de nuevo la contraseña");
                        nuevaConfirmacion = sc.next();
                        operadora.getLogica().cambiarContrasena(usuarioIngresado, nueva, nuevaConfirmacion); //Se hace la llamada al metodo cambiar contraseña
                        break;
                    case 2:
                        exit = -1;
                        System.out.println("Ingrese la nueva palabra");
                        nueva = sc.next();
                        System.out.println("Ingrese de nuevo la palabra");
                        nuevaConfirmacion = sc.next();
                        System.out.println("Usuario afuera " + this.nombreIngresado);
                        operadora.getLogica().cambiarPalabra(usuarioIngresado, nueva, nuevaConfirmacion); //Se hace la llamada al metodo cambiar palabra
                        break;
                    case 3:
                        exit = -1;
                        System.out.println("Antes de continuar se debe destacar que despues de eliminar esta cuenta, se eliminaran todas las recetas agregadas y los datos asiganados");
                        System.out.println("Para confirmar porfavor ingrese su contraseña para hacer efectiva la eliminacion");
                        contrasenaDeConfirmacion = sc.nextLine();
                        //Se debe confirmar la contraseña y lugo de eso llamar al metodo eliminar
                        break;
                    case 4:
                        exit = -1;
                        generarMenu(operadora.getLogica().ubicacionDeUsuarioPorIndice(nombreIngresado));
                        break;
                    default:
                        System.out.println("Solo se permite ingresar numeros del 1 - 3 intentelo de nuevo");
                        exit = 0;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Solo se permite ingrezar numeros intentelo de nuevo");
                menuEditarPerfil(this.nombreIngresado);
            }

        } while (exit == 0);

    }

    public void menuAgregarReceta(int indiceUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        String confirmacion = "";
        boolean respuestaLogica = false;
        boolean todosDatosIngresados = false; //verificar esta variable 
        String nombreReceta = "";
        String ingredientes = "";
        String preparacion = "";
        String descripcion = "";
        int cantidadDePersonas = 0;      //Esta variable se refiere al numero de personas que permite esta racion de comida

        try {

            System.out.println("Acontinuacion ingrese los datos pedidos");
            System.out.println("Nombre de la receta");
            nombreReceta = sc.nextLine();
            System.out.println("Ingredientes de la receta separados por comas");
            ingredientes = sc.nextLine();
            System.out.println("Preparacion de la receta");
            preparacion = sc.nextLine();
            System.out.println("Descripcion corta de la receta");
            descripcion = sc.nextLine();
            System.out.println("Ingrese en numero para cuantas personas es este plato");
            cantidadDePersonas = Integer.parseInt(sc.nextLine());   //Esta linea de codigo no permite que el siguiente escaner escanee los datos por eso es necesario hacer este casteo, el error ocurres por que se utiliza el mismo escaner
            System.out.println("Desea enviar estos datos escriba 'si' de lo contrario escriba 'no' ");
            confirmacion = sc.nextLine();
            //Valida respuesta, sirve para volver atras si es necesario
            if (confirmacion.equals("si")) {
                //Valida datos
                //Valida que todos los datos hayan sido ingresados
                if (cantidadDePersonas >= 100) {
                    System.out.println("El numero agregado supera el permitido, intentelo de nuevo\n");
                    menuAgregarReceta(indiceUsuario);
                } else if (nombreReceta.length() < 2) {
                    System.out.println("Porfavor  ingrese un nombre mas largo");
                    menuAgregarReceta(indiceUsuario);
                } else if (ingredientes.length() < 2) {
                    System.out.println("Porfavor ingrese los ingredintes mas largo");
                    menuAgregarReceta(indiceUsuario);
                } else if (preparacion.length() < 2) {
                    System.out.println("Porfavor ingrese la preparacion mas largo");
                    menuAgregarReceta(indiceUsuario);
                } else if (descripcion.length() < 2) {
                    System.out.println("Porfavor ingrese la descripcion mas largo");
                    menuAgregarReceta(indiceUsuario);
                } else {
                    //Envia los datos a logica para su validacion
                    respuestaLogica = operadora.getLogica().validarNuevaReceta(indiceUsuario, nombreReceta, ingredientes, preparacion, descripcion, cantidadDePersonas);
                }

            } else if (confirmacion.equals("no")) { //Se le da opciones al usuario para navegar en la plataforma
                //Permite al usuario intentarlo de nuevo o volver al menu incial
                System.out.println("Si desea intentarlo de nuevo ingrese 'si' de lo contrario oprima otra tecla");
                confirmacion = sc.nextLine();

                if (confirmacion.equals("si")) {
                    menuAgregarReceta(indiceUsuario);
                } else {
                    generarMenu(indiceUsuario);
                }
            } else {
                System.out.println("Solo se permite respuesta de 'si' y 'no' ");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Solo se permite agregar numeros, porfavor intentelo de nuevo\n");
            menuAgregarReceta(indiceUsuario);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("El numero ungresado es mayor al permitido, intentelo de nuevo");
            menuAgregarReceta(indiceUsuario);
        }

        if (respuestaLogica == true) {
            System.out.println("LA RECETAS SE A AGREGADO CON EXITO\n");
            generarMenu(indiceUsuario);
        } else{
            System.out.println("No se creo la receta");
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
