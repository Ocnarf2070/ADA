import java.io.PrintStream;
import java.util.Random;

public abstract class SubArrayMaximo {

	public abstract SolucionSubArrayMaximo resolver(int[] array);
	
	/**
	 * Genera un array de longitud dim cuyos valores son enteros comprendidos en el intervalo (min,max)  
	 * @param dim, numero de elementos del array
	 * @param min, menor valor posible
	 * @param min, mayor valor posible
	 * @return, array de enteros
	 */
	public static int[] generaArray(int dim, int min, int max) {
		Random random = new Random();
		int[] array = null;
		if (dim>0) {
			array = new int[dim];
			for(int i=0; i<dim; i++) {
				array[i] = min + random.nextInt(max-min);
			}
		}
		return array;
	}
		
	/**
	 * Genera un array de diferencias a partir de la cotizacion diaria  
	*/
	public static int[] vectorDiferencias(int[] dias) {
		// Creamos el vector de diferencias:
		int [] dif=new int [dias.length-1];
		for (int i=0;i<dif.length;i++){
			dif[i]=dias[i+1]-dias[i];
		}
		return dif;
	}
	
	/**
	 * Escribe en la salida out, el problema y su solucion
	 * @param out,  Flujo de salida
	 * @param problema, entrada al problema
	 * @param solucion, solucion
	 */
	protected static void salidaProblema(PrintStream out, int[] problema, SolucionSubArrayMaximo solucion) {
		for(int i=0; i<problema.length; i++) {
			out.print(problema[i]+" ");
		}
		out.println();
		out.println(solucion);
		out.println();
	}
	


	public static void main(String args[]) {
		
	}
	
	
}
