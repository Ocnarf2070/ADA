import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

class LectorFicheroEjemplos {
	
	HashMap<Integer, ArrayList<Integer>> problemas;
	HashMap<Integer, SolucionSubArrayMaximo> soluciones;
	
	
	/**
	 * Lee los problemas y su solucion desde un fichero de ejemplos  
	 * @param fileName, nombre del fichero que contiene los ejemplos
	 */
	public LectorFicheroEjemplos(String fileName) {
		problemas = new HashMap<Integer, ArrayList<Integer>>();
		soluciones = new HashMap<Integer, SolucionSubArrayMaximo>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int i=0;
			while (br.ready()) {
				String line = "";
				do {
					line = br.readLine(); // lee la linea de datos del problema, saltando las lineas en blanco 
					line = line.trim();
				} while (br.ready() && line.equals(""));
				if (!line.equals("")) {
					ArrayList<Integer> arraylist = new ArrayList<Integer>();
					Scanner sc = new Scanner(line);
					while (sc.hasNextInt()) {
						arraylist.add(new Integer(sc.nextInt()));
					}
					line = br.readLine(); // lee sumaOptima, diaCompra, diaVenta
					sc = new Scanner(line).useDelimiter("[^0-9]+");
					int diaCompra = sc.nextInt();
					int diaVenta = sc.nextInt();
					int sumaOptima = sc.nextInt();
				    SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo(sumaOptima, diaCompra, diaVenta);
				    problemas.put(new Integer(i), arraylist);
				    soluciones.put(new Integer(i), ssam);
					i++;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error leyendo el fichero "+ fileName);
		}
		
	}

	/**
	 * Devuelve el nsimo problema de ejemplos
	 * @return el vector de enteros del problema
	 */
	public int[] problema(int nsimo) {
		int[] problema = null;
		 if (nsimo<problemas.size()) {
			 ArrayList<Integer> arraylist = problemas.get(new Integer(nsimo));
			 problema = new int[arraylist.size()];
			 for(int i=0; i<arraylist.size(); i++) {
				 problema[i] = arraylist.get(i).intValue();
			 }
		 }
		 return problema;
	}
	
	/**
	 * Devuelve la solucion al nsimo problema de ejemplos
	 * @return el vector de enteros del problema
	 */
	public SolucionSubArrayMaximo solucion(int nsimo) {
		SolucionSubArrayMaximo ssam = null;
		if (nsimo<soluciones.size()) {
			ssam = soluciones.get(new Integer(nsimo));
		}
		return ssam;
	}
	

}