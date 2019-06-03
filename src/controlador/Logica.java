package controlador;

import java.util.*;
import modelo.*;

public class Logica {

    //Este objeto nos permite conectarnos con la clase menu
    private Archivar archivar; 
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
    private ArrayList<Receta> listaRecetaAdmin;

    public Logica() {
    }

    //validara si el usuario es correcto o no
    public boolean validarInicoDeSesion(String usuarioEnviado, String contrasenaEnviada) {
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios();  //Es obligatorio llamar a este metodo para poder acceder a la lista de usuarios 
        boolean respuesta = false; 

        //Si entra en este if significa que el usuario existe 
        if (buscarUsuario(usuarioEnviado) == true) {
            //Este if valida que la contraseña ingresada sea correcta
            if (archivar.getListaDeUsuarios().get(this.posicionDelUsuario).getContrsena().equals(contrasenaEnviada)) {
                //Devuelve true si el usuario existe y si las contraseñas son iguales
                respuesta = true; 
            } else {
                System.out.println("Error la contraseña no coincide");
                respuesta = false; 
            }
        } else {
            System.out.println("Error el usuario no existe");
            respuesta = false; 
        }      
        return respuesta;
    }

    //valida el registro hecho
    public int ValidarRegistro(String nombreEnviado, String contrasenaEnviada, String contrasenaConfirmada, String palaEnviada) {
        archivar = new Archivar(); 
        int usuarioCreado = 2;
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
                usuarioCreado = 0;
                archivar.guardarUsuario(this.usuario);
            } else {
                //Si las contraseñas no considen se debe volver a ingresar los datos
                System.out.println("Error las contraseñas no coinciden");
                usuarioCreado = 1; 
            }
        } else {
            System.out.println("Error ya existe un usuario asignado con ese nombre " + nombreEnviado);
            usuarioCreado = 2; 
        }  
        return usuarioCreado;
    }

    //******************Este metodo es OBLIGATORIO para el buen funcionamiento de otros metodos*******************************************************
    //Este metodo busca nombres de usuarios dentro de el archivo de usuarios retorna flaso/verdadero si el usuario existe
    public boolean buscarUsuario(String nombreDeUsuario) {
        boolean existe = false;
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios();   //  Es obligatoria primero llamar esta funciona para poder tener los datos guardados en el archivo con anterioridad
        //Recorre todos los obgetos del ArrayList
        for (int i = 0; i < archivar.getListaDeUsuarios().size(); i++) {
            if (archivar.getListaDeUsuarios().get(i).getNombre().equals(nombreDeUsuario)) {
                existe = true;
                this.posicionDelUsuario = i;  //Envia cual es la poscion del usuario encontrado
            }
        }
        return existe;
    }

    //*********************Para utilizar este metodo es necesario verificar con anterioridad que el usuario exista***********************************************
    public int ubicacionDeUsuarioPorIndice(String nombreDeUsuario) {
        archivar = new  Archivar(); 
        archivar.traerListadoDeUsuarios();   //  Es obligatoria primero llamar esta funciona para poder tener los datos guardados en el archivo con anterioridad
        //Recorre todos los obgetos del ArrayList
        for (int i = 0; i < archivar.getListaDeUsuarios().size(); i++) {
            if (archivar.getListaDeUsuarios().get(i).getNombre().equals(nombreDeUsuario)) {
                this.posicionDelUsuario = i;  //Envia cual es la poscion del usuario encontrado
            }
        }
        return this.posicionDelUsuario;
    }

    //Este metodo devuelve un obgeto de tipo usuario con todos los datos del usuario según el indice
    public Usuario objetoUsuarioEnIndice(int posicion) {
        archivar = new Archivar(); 
       archivar.traerListadoDeUsuarios();
        Usuario datosDeUsuario = new Usuario();
        datosDeUsuario = archivar.getListaDeUsuarios().get(posicion);
        return datosDeUsuario;
    }

     //Compuerba que la palabra de recuperación sea correcta
    public int comprobarPalabra(String nombreDeUsuario, String palabraDeRecuperacion) {
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios();   //Es obligatorio llamar este metodo parar poder obtener los datos de los usuarios
        int respuesta = 2;  //Respuesta del metodo a interfaz 
        Usuario datosDeComprobacion;
        if (buscarUsuario(nombreDeUsuario)) {
            datosDeComprobacion = objetoUsuarioEnIndice(this.posicionDelUsuario);
            if (datosDeComprobacion.getPalabraDeRecuperacion().equals(palabraDeRecuperacion)) {
                respuesta = 0;
            } else {
                System.out.println("Error las palabras no coinciden");
                respuesta = 1;
            }
        } else {
            //El usuario no existe 
            System.out.println("Error el usuario no existe");
            respuesta = 2;
        }
        return respuesta;
    }
    //Se encarga de cambiar la contraseña y guardar los cambios
    public int cambiarContrasena(String nombreDeUsuario, String contrasena, String contrasenaVerificada) {
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios(); //Es obligatorio para el manejo de persistencia
        boolean sePuedeCambiar = false; //Evalua si las contraseñas son correctas
        int respuesta = 2;
        //Busca el usuario y genera el indice para sus edicion
        if (buscarUsuario(nombreDeUsuario) == true) {
            //compara las contraseñas para verificar que sean iguales 
            if (contrasena.equals(contrasenaVerificada)) {
                sePuedeCambiar = true;
            } else {
                System.out.println("Error las contraseñas no coinciden");
                respuesta = 1; 
            }
        }
        //Si se cumple con los requisitos para cambiar la contraseña, se prosede a realizar el cambiar 
        if (sePuedeCambiar == true) {
            //Se crea una copia de la lista en una lista de nueva, para su edicion
            listaMomentanea = (ArrayList<Usuario>) archivar.getListaDeUsuarios().clone();
            //Se realiza el cambio del usuario en la posicion ubicada y mediante el set se envia el cambio al objeto
            listaMomentanea.get(posicionDelUsuario).setContrsena(contrasena);
            //Se llama el metodo con sobrecarga que permite cambiar la lista completa  
            if (archivar.guardar(listaMomentanea)) {
                respuesta = 0; 
            } else {
                System.out.println("Error al guardar los cambios en persistencia");
                respuesta =2;
            }
        }
        return respuesta; 
    }

    public int cambiarPalabra(String nombreDeUsuario, String palabraRecup, String palabraRecupConfirm) {
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios();
        boolean sePuedeCambiar = false; //Evalua si las contraseñas son correctas
        int respuesta = 3;
        //Busca el usuario y genera el indice para sus edicion
        if (buscarUsuario(nombreDeUsuario) == true) {
            //compara las palabras para verificar que sean iguales 
            if (palabraRecup.equals(palabraRecupConfirm)) {
                sePuedeCambiar = true;
            } else {
                System.out.println("Error las palabras no coinciden");
                respuesta = 1; 
            }
        } else {
            System.out.println("Error no se encontro el usuario");
            respuesta = 2; 
        }
        //Si se cumple con los requisitos para cambiar la contraseña, se prosede a realizar el cambiar 
        if (sePuedeCambiar == true) {
            //Se crea una copia de la lista en una lista de nueva, para su edicion
            listaMomentanea = (ArrayList<Usuario>) archivar.getListaDeUsuarios().clone();
            //Se realiza el cambio del usuario en la posicion ubicada y mediante el set se envia el cambio al objeto
            listaMomentanea.get(posicionDelUsuario).setPalabraDeRecuperacion(palabraRecup);
            //Se llama el metodo con sobrecarga que permite cambiar la lista completa        
            if (archivar.guardar(listaMomentanea)) {
                respuesta = 0; 
            } else {
                System.out.println("Error al realizar el cambio en persistencia");
                respuesta = 3; 
            }
        }
        return respuesta; 
    }
    //Este metodo se encarga de enviar el id del a para crear el documento, si no existe
    public boolean validarNuevaReceta(int indiceDeUsuario, String nombreR, String ingredientesR, String preparacionR, String descripcionR, int cantidadR) {
        archivar = new Archivar(); 
        boolean respuestaMenu = false;
        boolean archivoEditado = false;
        boolean existeArchivo = false;
        boolean archivoCreado = false;
        String nombreUsuario;
        //Se trae al obgeto y se trae el indice del usuario
        this.usuario = objetoUsuarioEnIndice(indiceDeUsuario); //Se guardan todos los datos del usuario
        nombreUsuario = usuario.getNombre();
        this.receta = new Receta(nombreR, ingredientesR, preparacionR, false, cantidadR, true, descripcionR);
        /*Llama el metodo que se encarga de verificar si el archivo existe y si no crearlo*/
        existeArchivo = archivar.buscarArchivo(nombreUsuario);
        if (existeArchivo == true) {
            archivar.traerRcetas(nombreUsuario); //Si existe se trae el archivo para poder editarlo
            listaRecetas = (ArrayList<Receta>) archivar.getRecetasDeUsuario().clone(); //Se crea una copia para su manejo
            listaRecetas.add(receta);  //Se agrega el nuevo obgeto a la lista 
            archivoEditado = archivar.sobreEscribirReceta(nombreUsuario, listaRecetas); //se envia para si manejo en persistencia
        } else {
            archivoCreado = archivar.crearArchivoReceta(nombreUsuario, this.receta); //Retorna el estado del archivo
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
        archivar = new Archivar(); 
        Usuario nombreUser;
        boolean respuestaMenu = false;
        int indiceReseta;
        //Antes de poder traer las recetas del usuario, es necesario conocer el nombre del usuario
        nombreUser = objetoUsuarioEnIndice(indiceUsuario);
        //Para poder editar la lista de recetas del usuario se traen el archivo correspondiente
        archivar.traerRcetas(nombreUser.getNombre());
        //Se verifica la existenncia y la ubicacion de la receta, mediante su nombre
        indiceReseta = buscarReceta(indiceUsuario, nombreReceta);
        if (indiceReseta != -1) {
            //Se trae el arrayList que contiene las  recetas 
            listaRecetas = archivar.getRecetasDeUsuario();
            this.listaRecetas.remove(indiceReseta);
            //Despues de eliminar es necesario guardar los cambios hechos en la lista
            respuestaMenu = archivar.sobreEscribirReceta(nombreUser.getNombre(), this.listaRecetas);
        } else {
            System.out.println("Error no se encontro el nombre de la receta");
            respuestaMenu = false;
        }
        return respuestaMenu;
    }
    //Elimina el usuario
    public boolean eliminarUsuario(int indiceUsuario, String contrasenaEnviada) {
        boolean respuesta = false;
        boolean contraIguales = false;
        archivar = new Archivar(); 
        archivar.traerListadoDeUsuarios();
        this.usuario = objetoUsuarioEnIndice(indiceUsuario);
        //Primero se verifica que la contraseña ingresada sea correcta       
        if (usuario.getContrsena().equals(contrasenaEnviada)) {
            contraIguales = true;
        } else {
            System.out.println("Error las contraseñas no coinciden");
            respuesta = false;
        }
        //Se elimina el usuario del archivo que contiene los usuarios Usuarios.txt
        if (contraIguales) {
            listaMomentanea = archivar.getListaDeUsuarios();
            this.listaMomentanea.remove(indiceUsuario);
            respuesta = archivar.guardar(this.listaMomentanea);
        }
        return respuesta;
    }
    //Este metodo busca la receta por su nombre y devuelve la posicion en la que este, si no existe devuelve -1 como resultado
    public int buscarReceta(int indiceUsuario, String nombreReceta) {
        archivar = new Archivar(); 
        archivar.traerRcetas("Admin");
        listaRecetaAdmin = archivar.getRecetasDeUsuario();
        int posicionR = -1;
        Usuario nombreUsuario;
        //Se trae el nombre del usuario
        nombreUsuario = objetoUsuarioEnIndice(indiceUsuario);
        //Se trae la lista de recetas 
        archivar.traerRcetas(nombreUsuario.getNombre()); //Trae  las recetas
        listaRecetas = archivar.getRecetasDeUsuario();
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
    //*****************************************************************************************************************************************************************************************
    //VERIFICAR METODO
        //Este metodo debe debe devolver un Array con el total de las listas 
    public ArrayList<ArrayList<Receta>> verRecetas(int indiceUsuario, String mostrar) {
        //Este metodo recibe dos parametros, el primero es el indice del usuario y el segundo determina que se debe mostrar
        //propia  = solo las recetas del usuario
        //global = las recetas propias y las de Admin
        ArrayList<ArrayList<Receta>> enviar = new ArrayList<ArrayList<Receta>>(); 
        archivar = new Archivar(); 
        this.usuario = objetoUsuarioEnIndice(indiceUsuario);
        switch (mostrar) {
            case "propia":
                //solo se muestran las recetas del usuario
                archivar.traerRcetas(usuario.getNombre());
                listaRecetas = archivar.getRecetasDeUsuario();
                enviar.add(listaRecetas); 
                break;
            case "global":
                //Se muestran la recetas de Admin y del Usuario
                archivar.traerRcetas(usuario.getNombre());
                listaRecetas = archivar.getRecetasDeUsuario(); //Se guardan la recetas del usuario
                archivar.traerRcetas("Admin"); //Se trae las recetas del usuario global
                listaRecetaAdmin = archivar.getRecetasDeUsuario(); //Se guardan las recetas predefinidas para mostrarlas
                enviar.add(listaRecetas);
                enviar.add(listaRecetaAdmin); 
                break;
            default:
                    System.out.println("Error no se envia la referencia que se debe mostrar");
                break;
        }
        
        return enviar; 
    }
    //********************************************************************************************************************************************************************************************

    //Este metodo devuelve la receta encontrada
    public Receta  verResultadoBusqueda(int indIseUsuario, int ubicacionReceta) {
        //Este metodo solo permite visualizar una receta 
        archivar = new Archivar(); 
        this.usuario = objetoUsuarioEnIndice(indIseUsuario);
        //Se traen las recetas del usuario
        archivar.traerRcetas(usuario.getNombre());
        listaRecetas = archivar.getRecetasDeUsuario();
        return this.listaRecetas.get(ubicacionReceta); 
    }

    //Este metodo se debe encargar de hacer las validaciones para enviar a menu agregar receta, donde se editara la receta
    public boolean editarReceta(int indiceUsuario, String nombreReceta, String[] listaDeEdiciones) {
        boolean errorGuardar = false;
        boolean respuesta = false; 
        archivar = new Archivar(); 
        usuario = objetoUsuarioEnIndice(indiceUsuario); //Se trae el obgeto usuario
        archivar.traerRcetas(usuario.getNombre()); //Se traenlas recetas del usuario para modificar
        //Es necesario concoer el indice de la receta
        int posicionReceta = buscarReceta(indiceUsuario, nombreReceta);
        //Se guardaran los datos optenidos en del array
        int racionEntero;
        listaRecetas = (ArrayList<Receta>) archivar.getRecetasDeUsuario().clone();  //Se crea una copia de la lista de usuarios para modificar
        //Valida que datos del array estan llenos para cambiarlos
        for (int i = 0; i < listaDeEdiciones.length; i++) {
            //Solo entra en los casos que se esta ocupado
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
                            System.out.println("\tError no se ingreso un numero entero");
                            respuesta = false; 
                        }
                        break;
                    default:
                        System.out.println("Error el tamaño del array ingresado supera el permitido");
                        break;
                }
            } else {
                //Espacios bacios, solo se utiliza para depurar
            }
        }
        //Guarda la receta editada
        errorGuardar = archivar.sobreEscribirReceta(usuario.getNombre(), this.listaRecetas);
        if (errorGuardar == false) {
            System.out.println("Error al guardar la receta");
            respuesta = false; 
        }else{
            respuesta = true; 
        }
        return respuesta; 
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
    public boolean guardarTips (ArrayList<String> tips){
        Archivar archivar = new Archivar(); 
        boolean respuesta = false;
        archivar.traerTips();
        //
        
        if (archivar.guardarTips(tips)) {
            System.out.println("Envio true");
        }else{
            System.out.println("Error al guardar //Logica");
        }
        
        return respuesta; 
    }
    
    
    public  ArrayList<String> traerTips(){
        archivar = new Archivar(); //permite comunicación con la lógica
        ArrayList<String> enviado = new ArrayList<String>();  //Se guardan la lista de tips
        archivar.traerTips();   //Es necesario traer los tips para poder hacer una copia de los mismos
        
        enviado = archivar.getTipsStrings();  //Crea una copia de los String almacenados
        
        if (enviado == null) {
            System.out.println("Error archivo basio");
        }
        
        
        return enviado; 
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
