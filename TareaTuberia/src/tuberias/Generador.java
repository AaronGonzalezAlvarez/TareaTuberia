package tuberias;

public class Generador {
	public static void main(String[] args) {
		int numeroCadena = 10;
		String[] vecesRepetir= args;
		char[] vocales = {'a','e','i','o','u'};
		
		String mostrar;
		int num;
		try {
			 num = Integer.parseInt(vecesRepetir[0]);
		} catch (Exception e) {
			 num = 8;
		}
		
		for(int y=0;y<num;y++) {
			mostrar = "";
			for(int x =0;x<numeroCadena;x++) {
				mostrar+=vocales[(int)(Math.random() * 5)];			
			}
		System.out.println(mostrar);
		}
	}
}