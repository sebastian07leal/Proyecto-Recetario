package controlador;

import java.io.*;
import java.util.ArrayList;
import modelo.Usuario;

public class Archivar {

    private Operadora operadora;
    private ObjectOutputStream envioDeDatos; //Es el objeto que permite crear el canal para guardar los datos en el archivo
    private ObjectInputStream traerDatos;   //Es el obgeto que permite crear el canal para traer los datos guadados en el archivo
    private File nuevo; //Es el archivo donde se guardan el Obgeto array lis en el equiipo
    private ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>(); //Es el array principal, es donde se guardan los usuarios cuando el programa esta en ejecucion


    //constructor de comunicacion
    public Archivar() {

    }

    //Este metodo convierte obgetos en texto plano 
    public void guardar(Usuario usuarioEnviado) {
        //Trea primero lo guardado y despues guarda apartir del ultimo indice
        traerListadoDeUsuarios();
        
        this.operadora = new Operadora();
       this.listaDeUsuarios.add(usuarioEnviado);

        try {

            //Se crea el archivo y se guarda en la ubicacion por defecto
            nuevo = new File("Usuarios.txt");

            //Se debe encontrar una extencion generica del archivo
            envioDeDatos = new ObjectOutputStream(new FileOutputStream(nuevo));
            envioDeDatos.writeObject(this.listaDeUsuarios);    //Se envia el objeto para guardar en el archivo espesificado anteriormente
            envioDeDatos.close();        
            
        } catch (java.lang.RuntimeException e) {
            System.out.println("Revisa donde se esta almacenando el dato regresado java.lang.RuntimeException ");
         } catch (Exception e) {
             System.out.println("Entro a otro error ");
         }
        

     
    }
    
    
    /*Para que la persistencia afuncione antes de realizar la creacion de un nuevo usuario es necesario 
        revisar que contiene el archivo antes creado*/
    public void traerListadoDeUsuarios(){
        System.out.println("Entro al listado");
        
        nuevo = new File("Usuarios.txt");       
        try {    
             traerDatos = new ObjectInputStream(new FileInputStream(nuevo));
             listaDeUsuarios = (ArrayList<Usuario>) traerDatos.readObject();    //Se  envia lo adquirido a la variable donde incialmente se guardan los datos
             traerDatos.close(); 
             System.out.println("Esta es la lista de usuarios "+this.listaDeUsuarios);
            
        } catch (Exception e) {
            System.out.println("HAY UN ERROR ");
        }   
        
    }
    
    
        
    //get de la lista de usuarios para  su manejo en otras clases 
    public ArrayList<Usuario> getListaDeUsuarios(){
        return this.listaDeUsuarios; 
    }  
    public File getNuevo(){
        return this.nuevo;
    }

    
}
