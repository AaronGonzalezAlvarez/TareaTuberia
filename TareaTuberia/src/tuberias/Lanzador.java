package tuberias;

import java.util.Iterator;

public class Lanzador {

	public static void main(String[] args) {
		Process proceso;
		
		try {
			
			for (int i = 0; i < 5; i++) {
				proceso = Runtime.getRuntime().exec("java -jar generador.jar 5 | java -jar frecuencia.jar");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
