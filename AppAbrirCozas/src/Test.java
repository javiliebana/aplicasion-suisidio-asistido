import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		Interfaz i = new Interfaz();
		i.setVisible(true);
		Controlador controlador = new Controlador(i);
		i.setControlador(controlador);
	}

}
