package tuberias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Frecuencia {

	public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        String lineaTeclado;        
     
        try {
        	File fichero = new File("save.txt");
            FileWriter fw = new FileWriter(fichero,true);
            
            while ((lineaTeclado = bf.readLine()) != null) {
                int a = 0;
                int e = 0;
                int o = 0;

                for (int x = 0; x < lineaTeclado.length(); x++) {
                    char caracter = Character.toLowerCase(lineaTeclado.charAt(x));
                    if (caracter == 'a') {
                        a++;
                    } else if (caracter == 'e') {
                        e++;
                    } else if (caracter == 'o') {
                        o++;
                    }
                }

                System.out.println(lineaTeclado +" a:"+a +" e:" + e +" i:" + o);
                fw.write(lineaTeclado +" a:"+a +" e:" + e +" i:" + o+"\n");
            }
            fw.write("------------------------------\n");
            fw.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
    }
}