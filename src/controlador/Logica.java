package controlador;

import java.util.ArrayList;
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
    private ArrayList<Usuario> listaMomentanea;

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
            operadora.getMenu().iniciarSecion(); //Si nocumple con los requisitos para iniciar secion es enviado a verificar datos desde el menu iniciar secion
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
                usuarioCreado = operadora.getArchivar().guardar(this.usuario);
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
    public int  ubicacionDeUsuarioPorIndice (String nombreDeUsuario) {
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
            if(operadora.getArchivar().guardar(listaMomentanea)){
                System.out.println("El cambio a sido exitoso");
                operadora.getMenu().generarMenu(ubicacionDeUsuarioPorIndice(nombreDeUsuario));
            }else{
                System.out.println("Error al realizar el cambio intentelo mas tarde");
                operadora.getMenu().initPage();
            }
        }

    }

    public void cambiarPalabra(String nombreDeUsuario,String palabraRecup, String palabraRecupConfirm) {
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
        }else{
                                    System.out.println("Entro******false*********");
        }
        //Si se cumple con los requisitos para cambiar la contraseña, se prosede a realizar el cambiar 
        if (sePuedeCambiar == true) {
            //Se crea una copia de la lista en una lista de nueva, para su edicion
            listaMomentanea = (ArrayList<Usuario>) operadora.getArchivar().getListaDeUsuarios().clone();
            //Se realiza el cambio del usuario en la posicion ubicada y mediante el set se envia el cambio al objeto
            listaMomentanea.get(posicionDelUsuario).setPalabraDeRecuperacion(palabraRecup);
            //Se llama el metodo con sobrecarga que permite cambiar la lista completa        
            if(operadora.getArchivar().guardar(listaMomentanea)){
                System.out.println("El cambio a sido exitoso");
                operadora.getMenu().generarMenu(ubicacionDeUsuarioPorIndice(nombreDeUsuario));
            }else{
                System.out.println("Error al realizar el cambio intentelo mas tarde");
                //operadora.getMenu().initPage();
            }
        }        
        
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

    
    
}
