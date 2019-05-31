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
    @SuppressWarnings("InfiniteRecursion")
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

            try {
                respuestaDeUsuaario = sc.nextInt();
                switch (respuestaDeUsuaario) {
                    case 1:
                        exit = -1;
                        iniciarSecion();
                        break;
                    case 2:
                        exit = -1;
                        //crearUsuario();
                        break;
                    case 3:
                        exit = -1;
                       // menuRecuperarCuenta();
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
                System.out.println("Al parecer hay un error en init page "+e);
                initPage();
            }

        } while (exit == 0);
    }
   // ********************************************************************************Terminado 
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
            } else {
                //Se envia la informacion a logica para que valide si el usuario es correcto o no 
                operadora.getLogica().validarInicoDeSesion(this.nombreIngresado, this.contrasenaIngresada);
            }

        } while (exit == 0);

    }
/*
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
    }*/

    public void eliminarUsuario(int indiceUsuario) {
        operadora = new Operadora();

        sc = new Scanner(System.in);
        String contrasenaEnviada;
        String respuesta;
        System.out.println("Antes de eliminar el usuario es necesario informarte que no se prodra recuperar posteriormente las recetas creadas");
        System.out.println("Si quieres eliminar es usuario porfavor ingresa tu contraseña a continuacion");
        contrasenaEnviada = sc.nextLine();
        if (operadora.getLogica().eliminarUsuario(indiceUsuario, contrasenaEnviada)) {
            System.out.println("El se a eliminado cone exito");
        } else {
            System.out.println("¿Desea intentarlo de nuevo? escriba 'si'  de lo contrario oprima otra palabra");
            respuesta = sc.nextLine();
            if (respuesta.equals("si")) {
                eliminarUsuario(indiceUsuario);
            } else {
                generarMenu(indiceUsuario);
            }
        }
    }

    //Este metodo simula la interfaz de usuario desde el menu (Home)
    @SuppressWarnings("InfiniteRecursion")
    public void generarMenu(int indiceUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        datosDeUsuario = operadora.getLogica().objetoUsuarioEnIndice(indiceUsuario);
        byte exit = -1;

        do {
            System.out.println("\n");
            System.out.println("*Acontinuacion ingrese la accion que desea realizar \n");
            System.out.println("\t1. Para añadir una receta");
            System.out.println("\t2. Para ver mis recetas");
            System.out.println("\t3. Para ver todas las recetas");
            System.out.println("\t4. Buscar receta");
            System.out.println("\t5. Configuracion de cuenta");
            System.out.println("\t6. Eliminar  receta");
            System.out.println("\t7. Editar receta");
            System.out.println("\t8. Cerrar sesion");

            try {
                switch (sc.nextInt()) {
                    case 1:
                        exit = -1;
                        menuAgregarReceta(indiceUsuario);
                        break;
                    case 2:
                        exit = -1;
                        verRecetas(indiceUsuario, "propia");
                        break;
                    case 3:
                        exit = -1;
                        verRecetas(indiceUsuario, "global");
                        break;
                    case 4:
                        exit = -1;
                        buscarReceta(indiceUsuario);
                        break;
                    case 5:
                        exit = -1;
                        menuEditarPerfil(datosDeUsuario.getNombre()); //Enviar usuario
                        break;
                    case 6:
                        exit = -1;
                        eliminarReceta(indiceUsuario);
                        break;
                    case 7:
                        exit = -1;
                        editarReceta(indiceUsuario);
                        break;
                    case 8:
                        exit = -1;
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
/*
    public void menuRecuperarCuenta() {
        sc = new Scanner(System.in);
        operadora = new Operadora();
        //Este metodo se debe quitar 
        //Se obtiene el nombre de usuario para ralizar la busqueda y traer los datos de dicho usuario
        System.out.println("Para recuperar su contraseña porfavor ingrese su nombre de usuario acontinuacion");
        this.nombreIngresado = sc.nextLine();
        //Se llama el metodo encargado de realizar la busqueda y el indice donde se encuentra en el array si el usuario no existe, se le da aviso al usuario
        System.out.println("Ingrese la palabra de recuperacion");
        this.palabraIngresada = sc.nextLine();
        
        //*******************************************************************************************
        
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
        
        //*************************************************************************************************
    }*/

    @SuppressWarnings("InfiniteRecursion")
    public void menuEditarPerfil(String usuarioIngresado) {
        this.operadora = new Operadora();
        int indiseUsuario = operadora.getLogica().ubicacionDeUsuarioPorIndice(usuarioIngresado);
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
                        eliminarUsuario(indiseUsuario);
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

    @SuppressWarnings("InfiniteRecursion")
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
            switch (confirmacion) {
                case "si":
                    //Valida datos
                    //Valida que todos los datos hayan sido ingresados
                    if (operadora.getLogica().buscarReceta(indiceUsuario, nombreReceta) != (-1)) {
                        System.out.println("El nombre de la receta ingresado ya existe, porfavor intente con otro nombre\n");
                        menuAgregarReceta(indiceUsuario);
                    } else if (cantidadDePersonas >= 100) {
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
                    break;
                case "no":
                    //Se le da opciones al usuario para navegar en la plataforma
                    //Permite al usuario intentarlo de nuevo o volver al menu incial
                    System.out.println("Si desea intentarlo de nuevo ingrese 'si' de lo contrario oprima otra tecla");
                    confirmacion = sc.nextLine();
                    if (confirmacion.equals("si")) {
                        menuAgregarReceta(indiceUsuario);
                    } else {
                        generarMenu(indiceUsuario);
                    }
                    break;
                default:
                    System.out.println("Solo se permite respuesta de 'si' y 'no' ");
                    menuAgregarReceta(indiceUsuario);
                    break;
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
        } else {
            System.out.println("No se creo la receta");
        }

    }

    //Este menu toma los datos sobre que receta se va a borrar de la lista
    public void eliminarReceta(int indiceUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        String nombreEliminar;
        String confirmacion;
        System.out.println("Acontinuacion ingrese el nombre de la receta a eliminar");
        nombreEliminar = sc.nextLine();
        System.out.println("Si esta seguro que desea eliminar porfavor escribar el siguiente texto: 'ELIMINAR' ");
        confirmacion = sc.nextLine();
        //Se verifica que la confirmacion se dada
        if (confirmacion.equals("ELIMINAR")) {
            //Se llama el metodo de eliminacion de variable
            if (operadora.getLogica().eliminarR(indiceUsuario, nombreEliminar)) {
                System.out.println("La receta ha sido eliminada con exito");
                generarMenu(indiceUsuario);
            } else {
                System.out.println("Hubo un error al eliminar la receta, intentelo de nuevo");
                eliminarReceta(indiceUsuario);
            }

        } else {
            System.out.println("La palabra escrita no coinside. Si quiere reintentar escriba 'si' de lo contrario oprima otra tecla");
            confirmacion = sc.nextLine();
            if (confirmacion.equals("si")) {
                eliminarReceta(indiceUsuario);
            } else {
                generarMenu(indiceUsuario);
            }
        }
    }

    public void verRecetas(int indiceUsuario, String vista) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        String respuesta = "";
        System.out.println("Bienvenido estas las recetas\n");
        operadora.getLogica().verRecetas(indiceUsuario, vista);
        //Este enunciado se debe cambuar en las interfaces graficas por un boton cancelar
        System.out.println("si quiere volver al menu principal escriba 'si' de lo contrario oprima otra tecla");
        respuesta = sc.nextLine();

        //Se valida la respuesta, esto se encarga de permitirle al suario volver al menu cuando quiera
        if (respuesta.equals("si")) {
            generarMenu(indiceUsuario);
        } else {
            verRecetas(indiceUsuario, vista);
        }

    }

    @SuppressWarnings("InfiniteRecursion")
    public void editarReceta(int indiseUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        String[] opciones = new String[5];
        int exit = -1;
        int respuesta;
        int racion;
        String res; 
        String nombreReceta;
        String reintentar;

        System.out.println("Bienvenido a su editor de recetas\n");
        System.out.println("Porfavor ingesa el nombre de la receta que quieres editar");
        nombreReceta = sc.nextLine();   //Este escaner genera un error 
        sc.nextLine(); 
        //Valida que la receta exista antes de continuar
        //En caso de no existir no permite iniciar con la edicion
        if (operadora.getLogica().buscarReceta(indiseUsuario, nombreReceta) != -1) {

            do {
 
                System.out.println("Acontinuacion selecione lo que desea editar\n");

                System.out.println("\t1. Nombre");
                System.out.println("\t2. Descripcion");
                System.out.println("\t3. Ingredientes");
                System.out.println("\t4. Preparación");
                System.out.println("\t5. Cantidad de ración");
                //System.out.println("\t6. Cancelar");

                try {
                    respuesta = Integer.parseInt( sc.nextLine());  //Se captura la respuesta  del usuario

                    switch (respuesta) {
                        case 1:
                            exit = 1; 
                            System.out.println("Porfavor ingrese el nuevo nombre");
                            opciones[0] = sc.nextLine(); 
                            break;
                        case 2:
                            System.out.println("Porfavor ingrese la nueva descripción");
                            opciones[1] = sc.nextLine();
                            break;
                        case 3:
                            System.out.println("Porfavor ingrese los ingredientes");
                            opciones[2] = sc.nextLine();
                            break;
                        case 4:
                            System.out.println("Porfavor ingrese la preparacion");
                            opciones[3] = sc.nextLine();
                            break;
                        case 5:
                            System.out.println("Profavor ingese la cantidad de ración ");
                            opciones[4] = sc.nextLine();
                            break;
                        case 6:
                            //Se debe sustituir
                            break;
                        default:
                            System.out.println("Solo se permite ingrezar numeros, intentelo de nuevo");
                            editarReceta(indiseUsuario);
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error intentelo de nuevo");
                    editarReceta(indiseUsuario);
                }
                //Emula un boton de enviar
                System.out.println("¿Quiere enviar los datos? Si es el caso ingrese 'si' de lo cotnrario oprima otra tecla");
                reintentar = sc.next();
                sc.nextLine(); 
                if (reintentar.equals("si")) {
                    exit = -1;
                    operadora.getLogica().editarReceta(indiseUsuario, nombreReceta, opciones);
                }
                System.out.println("¿Quiere editar algo mas? Si es el caso ingrese 'si' de lo cotnrario oprima otra tecla");
                reintentar = sc.next();
                sc.nextLine(); 
                if (reintentar.equals("si")) {
                    exit = 0;
                } else {   //Envia al menu principal  
                    exit = -1;
                    generarMenu(indiseUsuario);
                }

            } while (exit == 0);

        } else {
            System.out.println("La receta no existe porfavor intentelo de nuevo, Quiere volver al menu principal, escriba 'si' de lo contrario oprima otra tecla");
            res = sc.next(); 
            sc.nextLine(); 
            if (res.equals("si")) {
                editarReceta(indiseUsuario);
            }else{
                generarMenu(indiseUsuario);
            }

        }

    }

    public void buscarReceta(int indiseUsuario) {
        operadora = new Operadora();
        sc = new Scanner(System.in);
        String nombreBuscar;
        String respuesta;
        int posicion = -3;
        System.out.println("Ingrese el nombre  exacto de la receta a buscar");
        nombreBuscar = sc.nextLine();
        posicion = operadora.getLogica().buscarReceta(indiseUsuario, nombreBuscar);
        //Se busca la receta
        if (posicion != -1) {
            operadora.getLogica().verResultadoBusqueda(indiseUsuario, posicion);
            System.out.println("Si quiere volver a intentarlo escriba 'si' de lo contrario oprima otra tecla");
            respuesta = sc.nextLine();
            if (respuesta.equals("si")) {
                buscarReceta(indiseUsuario);
            } else {
                generarMenu(indiseUsuario);
            }
        } else {
            System.out.println("Lo sentimos el nombre " + nombreBuscar + " no existe, si quiere intentarlo de nuevo escriba 'si' de lo contrario oprima otra tecla");
            respuesta = sc.nextLine();
            if (respuesta.equals("si")) {
                buscarReceta(indiseUsuario);
            } else {
                generarMenu(indiseUsuario);
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
