package controlador;

import java.util.*;
import modelo.*;

public class Logica {

    //Este objeto nos permite conectarnos con la clase menu
    private Operadora operadora;

    //Variables reales; 
    private int posicionDelUsuario;
    private String nombreRecibido;
    private String contrasenaRecibida;
    private String confirmContrasena;
    private String palabraRecibida;
    private Usuario usuario;    //Este obgeto se enviara para su manejo en archivos de persistencia
    private Receta receta;
    private ArrayList<Usuario> listaMomentanea;
    private ArrayList<Receta> listaRecetas;
    private AbstractList<Receta> listaRecetaAdmin;

    public Logica() {
    }

    //validara si el usuario es correcto o no
    public void validarInicoDeSesion(String usuarioEnviado, String contrasenaEnviada) {
        operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();  //Es obligatorio llamar a este metodo para poder acceder a la lista de usuarios 

        //Si entra en este if significa que el usuario existe 
        if (buscarUsuario(usuarioEnviado) == true) {
            //Este if valida que la contraseña ingresada sea correcta
            if (operadora.getArchivar().getListaDeUsuarios().get(this.posicionDelUsuario).getContrsena().equals(contrasenaEnviada)) {
                System.out.println("Bienvenido " + operadora.getArchivar().getListaDeUsuarios().get(this.posicionDelUsuario).getNombre() + " Este es tu ID: " + operadora.getArchivar().getListaDeUsuarios().get(this.posicionDelUsuario).getId());

                operadora.getMenu().generarMenu(this.posicionDelUsuario); //Si la contraseña y usuario son correctos envia al menu principal 
            } else {
                System.out.println("La contraseña es incorrecta porfavor verifique");
                operadora.getMenu().iniciarSecion(); //Si nocumple con los requisitos para iniciar secion es enviado a verificar datos desde el menu iniciar secion
            }
        } else {
            System.out.println("El usuario no existe porfavor verifique");
            operadora.getMenu().iniciarSecion();
        }

    }

    //valida el registro hecho
    public boolean ValidarRegistro(String nombreEnviado, String contrasenaEnviada, String contrasenaConfirmada, String palaEnviada) {
        this.operadora = new Operadora();
        boolean usuarioCreado = false;
        this.nombreRecibido = nombreEnviado;
        this.contrasenaRecibida = contrasenaEnviada;
        this.confirmContrasena = contrasenaConfirmada;
        this.palabraRecibida = palaEnviada;

        //Primero busca si el nombre de usario existe
        if (buscarUsuario(nombreEnviado) == false) {
            //Se validad que las contraseñas ingresadas correspondan
            if (this.contrasenaRecibida.equals(this.confirmContrasena)) {
                //Se crea el obgeto  usuario
                this.usuario = new Usuario(this.nombreRecibido, this.contrasenaRecibida, this.palabraRecibida);
                //Se envia el nuevo usuario para a guardar en el listado de archivos, si la respuesta es False significa que hubo un error al crear el usuario en el archivo     
                usuarioCreado = operadora.getArchivar().guardarUsuario(this.usuario);
            } else {
                //Si las contraseñas no considen se debe volver a ingresar los datos
                System.out.println("Las contraseñas ingresadas no considen, intentelo de nuevo\n");
                operadora.getMenu().crearUsuario();
            }
        } else {
            System.out.println("Ya hay un usuario asignado con ese nombre " + nombreEnviado + " ,intentelo de nuevo con otro nombre de usuario\n");
            operadora.getMenu().crearUsuario();
        }

        //Se envia el obgeto para guardarlo con persistencia     
        return usuarioCreado;
    }

    //Este metodo busca nombres de usuarios dentro de el archivo de usuarios retorna flaso/verdadero si el usuario existe
    public boolean buscarUsuario(String nombreDeUsuario) {
        boolean existe = false;
        this.operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();   //  Es obligatoria primero llamar esta funciona para poder tener los datos guardados en el archivo con anterioridad

        //Recorre todos los obgetos del ArrayList
        for (int i = 0; i < operadora.getArchivar().getListaDeUsuarios().size(); i++) {

            if (operadora.getArchivar().getListaDeUsuarios().get(i).getNombre().equals(nombreDeUsuario)) {
                existe = true;
                this.posicionDelUsuario = i;  //Envia cual es la poscion del usuario encontrado
            }

        }
        return existe;
    }

    //Este metodo devuelve el indice donde esta ubicado el usuario ingresado, se utiliza principalmente para comunicacion entre clases 
    public int ubicacionDeUsuarioPorIndice(String nombreDeUsuario) {
        this.operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();   //  Es obligatoria primero llamar esta funciona para poder tener los datos guardados en el archivo con anterioridad

        //Recorre todos los obgetos del ArrayList
        for (int i = 0; i < operadora.getArchivar().getListaDeUsuarios().size(); i++) {

            if (operadora.getArchivar().getListaDeUsuarios().get(i).getNombre().equals(nombreDeUsuario)) {

                this.posicionDelUsuario = i;  //Envia cual es la poscion del usuario encontrado
            }

        }
        return this.posicionDelUsuario;
    }

    //Este metodo devuelve un obgeto de tipo usuario con todos los datos del usuario según el indice
    public Usuario objetoUsuarioEnIndice(int posicion) {
        operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();
        Usuario datosDeUsuario = new Usuario();

        datosDeUsuario = operadora.getArchivar().getListaDeUsuarios().get(posicion);

        return datosDeUsuario;
    }

    public boolean comprobarPalabra(String nombreDeUsuario, String palabraDeRecuperacion) {
        boolean respuesta = false;
        Usuario datosDeComprobacion;
        if (buscarUsuario(nombreDeUsuario)) {
            datosDeComprobacion = objetoUsuarioEnIndice(this.posicionDelUsuario);
            if (datosDeComprobacion.getPalabraDeRecuperacion().equals(palabraDeRecuperacion)) {
                System.out.println("La palabra es correcta ");
                //deve enviar a editar perfil para realizar el cambio de contraseña si se desea
                System.out.println(datosDeComprobacion);
                respuesta = true;
            } else {
                respuesta = false;
            }
        } else {
            //El usuario no existe 
            respuesta = false;
        }

        return respuesta;
    }

    //Se encarga de cambiar la contraseña y guardar los cambios
    public void cambiarContrasena(String nombreDeUsuario, String contrasena, String contrasenaVerificada) {
        boolean sePuedeCambiar = false; //Evalua si las contraseñas son correctas
        operadora = new Operadora();
        //Busca el usuario y genera el indice para sus edicion
        if (buscarUsuario(nombreDeUsuario) == true) {
            //compara las contraseñas para verificar que sean iguales 
            if (contrasena.equals(contrasenaVerificada)) {
                sePuedeCambiar = true;
            } else {
                System.out.println("Las contraseñas no coinsiden porfavor intentelo de nuevo");
                operadora.getMenu().menuEditarPerfil(nombreDeUsuario);
            }
        }
        //Si se cumple con los requisitos para cambiar la contraseña, se prosede a realizar el cambiar 
        if (sePuedeCambiar == true) {
            //Se crea una copia de la lista en una lista de nueva, para su edicion
            listaMomentanea = (ArrayList<Usuario>) operadora.getArchivar().getListaDeUsuarios().clone();
            //Se realiza el cambio del usuario en la posicion ubicada y mediante el set se envia el cambio al objeto
            listaMomentanea.get(posicionDelUsuario).setContrsena(contrasena);
            //Se llama el metodo con sobrecarga que permite cambiar la lista completa  
            if (operadora.getArchivar().guardar(listaMomentanea)) {
                System.out.println("El cambio a sido exitoso");
                operadora.getMenu().generarMenu(ubicacionDeUsuarioPorIndice(nombreDeUsuario));
            } else {
                System.out.println("Error al realizar el cambio intentelo mas tarde");
                operadora.getMenu().initPage();
            }
        }

    }

    public void cambiarPalabra(String nombreDeUsuario, String palabraRecup, String palabraRecupConfirm) {
        boolean sePuedeCambiar = false; //Evalua si las contraseñas son correctas
        operadora = new Operadora();
        //Busca el usuario y genera el indice para sus edicion
        if (buscarUsuario(nombreDeUsuario) == true) {
            //compara las contraseñas para verificar que sean iguales 
            if (palabraRecup.equals(palabraRecupConfirm)) {
                sePuedeCambiar = true;
            } else {
                System.out.println("Las palabras no coinsiden porfavor intentelo de nuevo");
                operadora.getMenu().menuEditarPerfil(nombreDeUsuario);
            }
        } else {
            System.out.println("No se encotro el usuario");
            operadora.getMenu().menuEditarPerfil(nombreRecibido);
        }
        //Si se cumple con los requisitos para cambiar la contraseña, se prosede a realizar el cambiar 
        if (sePuedeCambiar == true) {
            //Se crea una copia de la lista en una lista de nueva, para su edicion
            listaMomentanea = (ArrayList<Usuario>) operadora.getArchivar().getListaDeUsuarios().clone();
            //Se realiza el cambio del usuario en la posicion ubicada y mediante el set se envia el cambio al objeto
            listaMomentanea.get(posicionDelUsuario).setPalabraDeRecuperacion(palabraRecup);
            //Se llama el metodo con sobrecarga que permite cambiar la lista completa        
            if (operadora.getArchivar().guardar(listaMomentanea)) {
                System.out.println("El cambio a sido exitoso");
                operadora.getMenu().generarMenu(ubicacionDeUsuarioPorIndice(nombreDeUsuario));
            } else {
                System.out.println("Error al realizar el cambio intentelo mas tarde");
                //operadora.getMenu().initPage();
            }
        }

    }

    //Este metodo se encarga de enviar el id del a para crear el documento, si no existe
    public boolean validarNuevaReceta(int indiceDeUsuario, String nombreR, String ingredientesR, String preparacionR, String descripcionR, int cantidadR) {
        boolean respuestaMenu = false;
        operadora = new Operadora();
        boolean archivoEditado = false;
        boolean existeArchivo = false;
        boolean archivoCreado = false;
        String nombreUsuario;
        //Se trae al obgeto y se trae el indice del usuario
        this.usuario = objetoUsuarioEnIndice(indiceDeUsuario); //Se guardan todos los datos del usuario
        nombreUsuario = usuario.getNombre();
        this.receta = new Receta(nombreR, ingredientesR, preparacionR, false, cantidadR, true, descripcionR);
        /*Llama el metodo que se encarga de verificar si el archivo existe y si no crearlo*/
        existeArchivo = operadora.getArchivar().buscarArchivo(nombreUsuario);
        if (existeArchivo == true) {
            operadora.getArchivar().traerRcetas(nombreUsuario); //Si existe se trae el archivo para poder editarlo
            listaRecetas = (ArrayList<Receta>) operadora.getArchivar().getRecetasDeUsuario().clone(); //Se crea una copia para su manejo
            listaRecetas.add(receta);  //Se agrega el nuevo obgeto a la lista 
            archivoEditado = operadora.getArchivar().sobreEscribirReceta(nombreUsuario, listaRecetas); //se envia para si manejo en persistencia
        } else {
            archivoCreado = operadora.getArchivar().crearArchivoReceta(nombreUsuario, this.receta); //Retorna el estado del archivo
        }
        //Valida que no hallan errores al crear o editar los archivos, si hay errores envia false a clase menu
        if (archivoEditado == true) {
            respuestaMenu = true;
        } else if (archivoCreado == true) {
            respuestaMenu = true;
        }
        return respuestaMenu;
    }

    public boolean eliminarR(int indiceUsuario, String nombreReceta) {
        operadora = new Operadora();
        Usuario nombreUser;
        boolean respuestaMenu = false;
        int indiceReseta;
        //Antes de poder traer las recetas del usuario, es necesario conocer el nombre del usuario
        nombreUser = objetoUsuarioEnIndice(indiceUsuario);
        //Para poder editar la lista de recetas del usuario se traen el archivo correspondiente
        operadora.getArchivar().traerRcetas(nombreUser.getNombre());
        //Se verifica la existenncia y la ubicacion de la receta, mediante su nombre
        indiceReseta = buscarReceta(indiceUsuario, nombreReceta);
        if (indiceReseta != -1) {
            //Se trae el arrayList que contiene las  recetas 
            listaRecetas = operadora.getArchivar().getRecetasDeUsuario();
            this.listaRecetas.remove(indiceReseta);
            //Despues de eliminar es necesario guardar los cambios hechos en la lista
            respuestaMenu = operadora.getArchivar().sobreEscribirReceta(nombreUser.getNombre(), this.listaRecetas);
        } else {
            System.out.println("No se encontro el nombre de la receta");
            respuestaMenu = false;
        }
        return respuestaMenu;
    }

    public boolean eliminarUsuario(int indiceUsuario, String contrasenaEnviada) {
        boolean respuesta = false;
        boolean contraIguales = false;
        operadora = new Operadora();
        operadora.getArchivar().traerListadoDeUsuarios();
        this.usuario = objetoUsuarioEnIndice(indiceUsuario);
        //Primero se verifica que la contraseña ingresada sea correcta       
        if (usuario.getContrsena().equals(contrasenaEnviada)) {
            contraIguales = true;
        } else {
            System.out.println("Lo sentimos las contraseñas no coinciden");
            respuesta = false;
        }
        //Se elimina el usuario del archivo que contiene los usuarios Usuarios.txt
        if (contraIguales) {

            listaMomentanea = operadora.getArchivar().getListaDeUsuarios();
            this.listaMomentanea.remove(indiceUsuario);
            respuesta = operadora.getArchivar().guardar(this.listaMomentanea);
        }
        return respuesta;
    }

    //Este metodo busca la receta por su nombre y devuelve la posicion en la que este, si no existe devuelve -1 como resultado
    public int buscarReceta(int indiceUsuario, String nombreReceta) {
        operadora = new Operadora();
        operadora.getArchivar().traerRcetas("Admin");
        listaRecetaAdmin = operadora.getArchivar().getRecetasDeUsuario();
        int posicionR = -1;
        Usuario nombreUsuario;
        //Se trae el nombre del usuario
        nombreUsuario = objetoUsuarioEnIndice(indiceUsuario);
        //Se trae la lista de recetas 
        operadora.getArchivar().traerRcetas(nombreUsuario.getNombre()); //Trae  las recetas
        listaRecetas = operadora.getArchivar().getRecetasDeUsuario();

        //Busca dentro de la recetas globales
        for (int j = 0; j < listaRecetaAdmin.size(); j++) {
            if (listaRecetaAdmin.get(j).getNombre().equals(nombreReceta)) {
                posicionR = j;  //Envia cual es la poscion del usuario encontrado
                break; //Este break es necesario para que el ciclo deje de iterar apenas encuentre un indice con el nombre de la receta
            } else {
                posicionR = -1; 
             }            
        }        
        
        //Recorre todos los obgetos del ArrayList
        for (int i = 0; i < listaRecetas.size(); i++) {
            if (listaRecetas.get(i).getNombre().equals(nombreReceta)) {
                posicionR = i;  //Envia cual es la poscion del usuario encontrado
                break; //Este break es necesario para que el ciclo deje de iterar apenas encuentre un indice con el nombre de la receta
            } else {
                posicionR = -1;
            }
        }

        
        return posicionR;
    }

    public void verRecetas(int indiceUsuario, String mostrar) {
        //Este metodo recibe dos parametros, el primero es el indice del usuario y el segundo determina que se debe mostrar
        //propia  = solo las recetas del usuario
        //global = las recetas propias y las de Admin
        operadora = new Operadora();
        this.usuario = objetoUsuarioEnIndice(indiceUsuario);

        switch (mostrar) {
            case "propia":
                //solo se muestran las recetas del usuario
                operadora.getArchivar().traerRcetas(usuario.getNombre());
                listaRecetas = operadora.getArchivar().getRecetasDeUsuario();
                System.out.println(listaRecetas);   //Muestra las recetas del usuario
                break;
            case "global":
                //Se muestran la recetas de Admin y del Usuario
                operadora.getArchivar().traerRcetas(usuario.getNombre());
                listaRecetas = operadora.getArchivar().getRecetasDeUsuario(); //Se guardan la recetas del usuario
                operadora.getArchivar().traerRcetas("Admin"); //Se trae las recetas del usuario global
                listaRecetaAdmin = operadora.getArchivar().getRecetasDeUsuario(); //Se guardan las recetas predefinidas para mostrarlas
                System.out.println("PROPIAS: \n" + listaRecetas + " GLOBALES:\n " + listaRecetaAdmin);
                break;
        }
    }

    public void verResultadoBusqueda(int indIseUsuario, int ubicacionReceta) {
        //Este metodo solo permite visualizar una receta 
        operadora = new Operadora();
        this.usuario = objetoUsuarioEnIndice(indIseUsuario);
        //Se traen las recetas del usuario
        operadora.getArchivar().traerRcetas(usuario.getNombre());
        listaRecetas = operadora.getArchivar().getRecetasDeUsuario();
        System.out.println("Esta es la receta encontrada" + listaRecetas.get(ubicacionReceta));

    }

    //Este metodo se debe encargar de hacer las validaciones para enviar a menu agregar receta, donde se editara la receta
    public void editarReceta(int indiceUsuario, String nombreReceta, String[] listaDeEdiciones) {
        boolean errorGuardar = false;
        usuario = objetoUsuarioEnIndice(indiceUsuario); //Se trae el obgeto usuario
        operadora.getArchivar().traerRcetas(usuario.getNombre()); //Se traenlas recetas del usuario para modificar
        //Es necesario concoer el indice de la receta
        int posicionReceta = buscarReceta(indiceUsuario, nombreReceta);
        //Se guardaran los datos optenidos en del array
        int racionEntero;
        listaRecetas = (ArrayList<Receta>) operadora.getArchivar().getRecetasDeUsuario().clone();  //Se crea una copia de la lista de usuarios para modificar
        //Valida que datos del array estan llenos para cambiarlos
        for (int i = 0; i < listaDeEdiciones.length; i++) {

            if (listaDeEdiciones[i] != null) {
            //Posicion 0 Contiene el  nombre
                //Posicion 1 Contiene la descripcion
                //Posicion 2 Contiene los ingredientes
                //Posicion 3 Contiene la preparacion
                //Posicion 4 Contiene la racion en cadenas de texto             
                switch (i) {
                    case 0:
                        listaRecetas.get(posicionReceta).setNombre(listaDeEdiciones[i]); //Envia por medio de un set los datos 
                        break;
                    case 1:
                        listaRecetas.get(posicionReceta).setDescripcion(listaDeEdiciones[i]);
                        break;
                    case 2:
                        listaRecetas.get(posicionReceta).setIngredientes(listaDeEdiciones[i]);
                        break;
                    case 3:
                        listaRecetas.get(posicionReceta).setPreparacion(listaDeEdiciones[3]);
                        break;
                    case 4:
                        racionEntero = validaRacion(listaDeEdiciones[4]);
                        if (racionEntero != -1) {
                            listaRecetas.get(posicionReceta).setCantidadDePersonas(racionEntero);
                        } else {
                            System.out.println("\tNo se ingreso un numero, intentelo de nuevo");
                            operadora.getMenu().editarReceta(indiceUsuario);
                        }
                        break;
                    default:
                        System.out.println("No se debe disparar switch editar receta");
                        break;
                }
                //System.out.println("bacia "+i);
            } else {
                //System.out.println("basia "+(i+1));
            }

        }
        //Guarda la receta editada
        errorGuardar = operadora.getArchivar().sobreEscribirReceta(usuario.getNombre(), this.listaRecetas);
        if (errorGuardar == false) {
            System.out.println("Se produjo un error al editar");
        }

    }

    //Este metodo valida el String enviado es un entero valido
    private int validaRacion(String racionEnviada) {
        int respuesta = -1;

        try {
            //transforma el String en numero
            int racionTransformada = Integer.parseInt(racionEnviada);
            //Valida que el numero este dentro de los permitidos
            if (racionTransformada <= 100) {
                respuesta = racionTransformada;
            } else {
                respuesta = -1;
            }
        } catch (Exception e) {
            //No se ingreso un numero
            respuesta = -1;
        }

        return respuesta;
    }

    //Get y Set de las variables basicas 
    public String getNombreRecibido() {
        return nombreRecibido;
    }

    public String getContrasenaRecibida() {
        return contrasenaRecibida;
    }

    public String getPalabraRecibida() {
        return palabraRecibida;
    }

    public int getPosicionDeUsuario() {
        return posicionDelUsuario;
    }

    public ArrayList<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(ArrayList<Receta> listaReceta) {
        this.listaRecetas = listaReceta;
    }

}
