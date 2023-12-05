package tuberias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Lanzador {

	public static void main(String[] args) {
		Process proceso;
		
		Scanner scanner = new Scanner(System.in);
		Scanner prueba = null;
        System.out.print("Numero de cadenas por proceso: ");
        int numCadena = scanner.nextInt();
        System.out.print("Numero de veces a repetir: ");
        int numProceso = scanner.nextInt();
        String cadena="";
		
        try {

            // Construir la cadena de comandos como una lista
            proceso = Runtime.getRuntime().exec(new String[] {
                    "java", "-jar", "C:\\Users\\DAW_M\\Documents\\socket\\generador.jar", String.valueOf(numCadena)
            });

            // Capturar la salida del primer comando
            BufferedReader bf = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            StringBuilder output = new StringBuilder();
            String linea;
            while ((linea = bf.readLine()) != null) {
                output.append(linea).append("\n");
            }

            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Exit Code del generador.jar: " + exitCode);

            // Ahora ejecutar el segundo comando utilizando la salida del primero como entrada
            if (exitCode == 0) {
                String resultadoGenerador = output.toString().trim(); // Obtener la salida del primer comando

                // Construir la cadena de comandos para el segundo proceso
                Process segundoProceso = Runtime.getRuntime().exec(new String[] {
                        "java", "-jar", "C:\\Users\\DAW_M\\Documents\\socket\\frecuencia.jar"
                });
                
                //pruebas
                PrintWriter entradaFrecuencia = new PrintWriter(segundoProceso.getOutputStream());
                entradaFrecuencia.println(output);
                entradaFrecuencia.flush();
                
                Scanner salidaF = new Scanner(segundoProceso.getInputStream());
                while(salidaF.hasNextLine()) {
                	System.out.println(salidaF.nextLine());
                }
                segundoProceso.waitFor();
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
}
