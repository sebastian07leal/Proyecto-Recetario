package vista;

import controlador.Operadora;

public class Menu {
    private Operadora operadora;
    private String usuario;
    private String contrasena;

    //Constructor para agregar parametros 
    public Menu(String usario, String pasword) {
        this.usuario = usario;
        this.contrasena = pasword;
    }

    //Este constructor está diseñado para la comunicacion entre clases 
    public Menu() {
        this.operadora = new Operadora(); 
    }

    //Get y Set permiten ver las contraseñas ingresadas por el usuario pero no cambiarlas
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

}
