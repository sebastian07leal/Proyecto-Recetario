package controlador;

import modelo.*;

public class Logica {

    //Este objeto nos permite conectarnos con la clase menu
    private Operadora operadora;

    //estos usuarios va a ser momentaneos mientras se implementan las interfaces graficas
    private String user = "Sebastian";
    private String pas = "123123";

    //Variables reales; 
    private String nombreRecibido;
    private String contrasenaRecibida;
    private String confirmContrasena;
    private String palabraRecibida;
    private Usuario usuario;    //Este obgeto se enviara para su manejo en archivos de persistencia

    public Logica() {
    }

    //validara si el usuario es correcto o no
    public void ValidarUsuario(String usuarioEnviado, String contrasenaEnviada) {
        operadora = new Operadora();
        //Solo se ha comparado sebastian 
        if (usuarioEnviado.equals(user)) {
            System.out.println();
            System.out.println("El usuario o contraseña ingresados no son correctos, intentelo de nuvo");
            operadora.getMenu().iniciarSecion();
            if (contrasenaEnviada.equals(pas)) {
                operadora.getMenu().generarMenu();
            }
        } else {
            System.out.println();
            System.out.println("El usuario o contraseña ingresados no son correctos, intentelo de nuvo");
            operadora.getMenu().iniciarSecion();
        }
    }

    //valida el registro hecho
    public boolean ValidarRegistro(String nombreEnviado, String contrasenaEnviada, String contrasenaConfirmada, String palaEnviada) {
        this.operadora = new Operadora();
        boolean contraIguales = false;
        this.nombreRecibido = nombreEnviado;
        this.contrasenaRecibida = contrasenaEnviada;
        this.confirmContrasena = contrasenaConfirmada;
        this.palabraRecibida = palaEnviada;

        if (this.contrasenaRecibida.equals(this.confirmContrasena)) {
            contraIguales = true;
        }
        //Se crea el obgeto  usuario
        this.usuario = new Usuario(this.nombreRecibido, this.contrasenaRecibida, this.palabraRecibida);
 
        //Se envia el obgeto para guardarlo con persistencia     
        operadora.getArchivar().guardar(this.usuario);

        return contraIguales;
    }
    
    public boolean validarExistencia(Usuario usuarioEnProceso){
        
        return false;
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

}
