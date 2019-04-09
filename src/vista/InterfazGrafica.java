package vista;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;


/*Esta clase hereda de Jframe la cual pertenece al paquete swing que se especializa en interfaces de usuario*/
public class InterfazGrafica extends JFrame{
	
	
	//Constructor de la clase 
	public InterfazGrafica() {
		
		//Muestra que sistema de ventanas se está utilizando para mostrar el programa
		Toolkit miPantalla = Toolkit.getDefaultToolkit(); /*Se crea un obgeto de tipo Toolkit dado que el metodo devuelve un obgeto del mismo tipo*/
		
		//Se determina cual es la resoluciona de la ventana
		Dimension tamanoPantalla = miPantalla.getScreenSize();  /*Es obligatorio generar un obgeto Dimension para poder guardar lo retornado por el metodo*/
			
		int alruraPantalla = tamanoPantalla.height; 
		int anchoPantalla = tamanoPantalla.width; 
			
		
		//Genera el Tamaño y el lugar donde se creará la ventana
		setBounds(0, 0, anchoPantalla, (alruraPantalla - 40));
		
		//Este metodo no permite que las dimenciones del marco sean cambiadas
		setResizable(false);
		
		//Agrega un titulo a la ventana 
		setTitle(" REGISTRO DE USUARIO ");
		

		
	}
	
}
