package controlador;

import java.io.*;
import java.util.ArrayList;
import modelo.*;

public class Archivar {

    private ObjectOutputStream envioDeDatos; //Es el objeto que permite crear el canal para guardar los datos en el archivo
    private ObjectInputStream traerDatos;   //Es el obgeto que permite crear el canal para traer los datos guadados en el archivo
    private File nuevo; //Es el archivo donde se guardan el Obgeto array lis en el equiipo
    private ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>(); //Es el array principal, es donde se guardan los usuarios cuando el programa esta en ejecucion
    private ArrayList<Receta> recetasDeUsuaros = new ArrayList<Receta>();

    //constructor de comunicacion
    public Archivar() {

    }

    //Este metodo convierte obgetos en texto plano  y los guarda devueleve true/False si se logro crear
    public boolean guardarUsuario(Usuario usuarioEnviado) {
        boolean creado = false;
        //Trea primero lo guardado y despues guarda apartir del ultimo indice
        traerListadoDeUsuarios();
        this.listaDeUsuarios.add(usuarioEnviado);
        try {
            //Se crea el archivo y se guarda en la ubicacion por defecto
            nuevo = new File("Usuarios.txt");
            //Se debe encontrar una extencion generica del archivo
            envioDeDatos = new ObjectOutputStream(new FileOutputStream(nuevo));
            envioDeDatos.writeObject(this.listaDeUsuarios);    //Se envia el objeto para guardar en el archivo espesificado anteriormente
            envioDeDatos.close();
            creado = true;
        } catch (java.lang.RuntimeException e) {
            System.out.println("Revisa donde se esta almacenando el dato regresado java.lang.RuntimeException ");
            creado = false;
        } catch (Exception e) {
            System.out.println("Entro a otro error en guardar usuario");
            creado = false;
        }
        return creado;
    }

    //Este metodo se sobrecarga para poder modificar partes de una lista y sobre escribirla, a diferencia del metodo anterior este recibe listas completas, el otro añade objetos
    public boolean guardar(ArrayList<Usuario> listaEnviada) {
        boolean creado = false;
        //Trea primero lo guardado y despues guarda apartir del ultimo indice
        traerListadoDeUsuarios();
        //Se sobre escribe la lista ya creada con la lista modificada 
        this.listaDeUsuarios = listaEnviada;
        try {
            //Se crea el archivo y se guarda en la ubicacion por defecto
            nuevo = new File("Usuarios.txt");
            //Se debe encontrar una extencion generica del archivo
            envioDeDatos = new ObjectOutputStream(new FileOutputStream(nuevo));
            envioDeDatos.writeObject(this.listaDeUsuarios);    //Se envia el objeto para guardar en el archivo espesificado anteriormente
            envioDeDatos.close();
            creado = true;
        } catch (java.lang.RuntimeException e) {
            System.out.println("Revisa donde se esta almacenando el dato regresado java.lang.RuntimeException ");
            creado = false;
        } catch (Exception e) {
            System.out.println("Entro a otro error en guardar");
            creado = false;
        }
        return creado;
    }

    /*Para que la persistencia afuncione antes de realizar la creacion de un nuevo usuario es necesario 
     revisar que contiene el archivo antes creado*/
    public void traerListadoDeUsuarios() {
        nuevo = new File("Usuarios.txt");
        try {
            traerDatos = new ObjectInputStream(new FileInputStream(nuevo));
            listaDeUsuarios = (ArrayList<Usuario>) traerDatos.readObject();    //Se  envia lo adquirido a la variable donde incialmente se guardan los datos
            traerDatos.close();

        } catch (Exception e) {
            System.out.println("HAY UN ERROR en traer listado");
        }
    }

    //Este metodo se encarga de buscar los archivos 
    public boolean buscarArchivo(String nombreUser) {
        nuevo = new File(nombreUser + ".txt"); //Se crea un obgeto de tipo file con el  nombre del archivo   
        boolean existe; //Esta variable es la respuesta a la busqueda
        existe = nuevo.exists();
        return existe; //Retorna la respuesta de la busqueda 
    }

    //Este metodo creara un archivo que contendrá todas la recetas del usuario, se inicia con la primera receta creada
    public boolean crearArchivoReceta(String nombreUsuario, Receta recetaNueva) {
        boolean creado = false;
        this.recetasDeUsuaros.add(recetaNueva);
        //Se crea un archivo con el mismo nombre del usuario para facilitar su busqueda
        nuevo = new File(nombreUsuario + ".txt");
        try {

            //Se crea el canal para crear los datos  y transformarlos
            envioDeDatos = new ObjectOutputStream(new FileOutputStream(nuevo));
            envioDeDatos.writeObject(this.recetasDeUsuaros);
            envioDeDatos.close();
            creado = true;
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
            creado = false;
        }
        return creado;
    }

    //En caso de que el archivo exista solo se sobre escribira
    //Este metodo tambien funciona para editar recetas y eliminar recetas
    public boolean sobreEscribirReceta(String nombreUsuario, ArrayList<Receta> listadoRecetas) {
        traerRcetas(nombreUsuario); //Para poder editar o agrgar una receta es necesario traerla
        boolean editado = false;
        this.recetasDeUsuaros = listadoRecetas;
        try {
            nuevo = new File(nombreUsuario + ".txt");
            envioDeDatos = new ObjectOutputStream(new FileOutputStream(nuevo));
            envioDeDatos.writeObject(this.recetasDeUsuaros);
            envioDeDatos.close();
            editado = true;
        } catch (Exception e) {
            System.out.println("Error al remplazar el usuario");
            editado = false;
        }
        return editado;
    }

    //Se crea un metodo que trae las recetas de los usuarios
    public void traerRcetas(String nombreUsuario) {
        this.nuevo = new File(nombreUsuario + ".txt");

        try {
            this.traerDatos = new ObjectInputStream(new FileInputStream(this.nuevo));
            recetasDeUsuaros = (ArrayList<Receta>) this.traerDatos.readObject();
            traerDatos.close();
        } catch (Exception e) {
            //Aca debe avizar de otra manera
            System.out.println("Error en traer Recetas");
        }

    }

    //get de la lista de usuarios para  su manejo en otras clases 
    public ArrayList<Usuario> getListaDeUsuarios() {
        return this.listaDeUsuarios;
    }

    public ArrayList<Receta> getRecetasDeUsuario() {
        return this.recetasDeUsuaros;
    }

    public File getNuevo() {
        return this.nuevo;
    }

}
