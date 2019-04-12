package vista;

import controlador.Operadora;

public class Principal {
    
    public static void main(String[] args) {

        Operadora operadora = new Operadora();
        
        operadora.getMenu().iniciarSecion();

    }

}
