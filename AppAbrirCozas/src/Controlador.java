import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;


public class Controlador {
	Interfaz i;
	File fichero;
	
	public Controlador(Interfaz ventana){
		this.i = ventana;
		fichero = new File("direcciones.txt");
		cargarFichero();
	}
	

	public void setVista(Interfaz i) {
		this.i=i;
	}
	
	public void abrirPrograma(String programa) {
		// TODO Auto-generated method stub
		String p= programa;
		
		Runtime r = Runtime.getRuntime();
		try {
			Process p1 = r.exec("cmd /c start "+p);
		} catch (IOException e) {
			System.out.println("no se ha podido crear el subproceso");
			e.printStackTrace();
		}
	}
	
	
	public void navegar(String cadena) {
		
		try {
			Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + cadena);
			i.modelo.addElement(cadena);
			i.list.setModel(i.modelo);
			volcarDatos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void cargarFichero(){
		/* Se pasa la información almacenada en el fichero en el componente
		 * DefaultListModel para que luego se refleje en el componente JList
		 */
		
		try {
			FileReader flujo = new FileReader(fichero);
			BufferedReader br = new BufferedReader(flujo);
			String linea=br.readLine();
			while(linea!=null){
				
				i.modelo.addElement(linea);
				linea=br.readLine();	
			}
			i.list.setModel(i.modelo);
			flujo.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la aplicación");
		}
		
		
	}
	
	private void volcarDatos(){
		try {
			FileWriter flujo = new FileWriter(fichero);
			// Bucle para acceder a todos los elementos del modelo, el primero tiene la posición 0 y con getSize tenemos el número total 
			for ( int j=0; j<i.modelo.getSize();j++){
				flujo.write(i.modelo.getElementAt(j).toString()+"\r"+"\n");
				
			}
			flujo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}


