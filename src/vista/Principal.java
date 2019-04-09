package vista;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		
		
		//No BORRAR ESTOS METODOS, SON PARA LA EJECUCION DE LA VISTA, SOLO COMENTAR 
		/*Crea un Objeto de tipo InterfazGrafica que se va a encargar de mostrar el registro de la aplicación*/
		InterfazGrafica interfazRegistro = new InterfazGrafica(); 	
		interfazRegistro.setVisible(true);
		interfazRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*La clase de Jframe extiende de windows y tiene sus propios metodos*/  /*Exit ON CLOSE se refiere a cerrar al salir*/
		

	}

}
