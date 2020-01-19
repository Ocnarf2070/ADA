import java.util.ArrayList;
import java.util.List;

public class Analizar {
	
	/*
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de
	 * salida que deberia tener la solucion a este ejericio.
	 * Esta clase debe modificarse completamente para cumplir 
	 * mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */
	
	public static String masCercano(double ratio) {
			if (ratio < 1.5) {                      // aprox 1.0
				return "1";							
			} else if (1 <= ratio && ratio < 3.0) { // aprox 2.0
				return "N";
			} else if (3 <= ratio && ratio < 6.0) { // aprox 4.0
				return "N2";
			} else if (6 <= ratio && ratio < 10.0) { // aprox 8.0
				return "N3";
			} else { 								 // otras
				return "NF";
			}
	}
	
	public static void main(String arg[]) {
		List<Double> com = new ArrayList<>();
		Temponano t = new Temponano();
		int k=1000;
		long t1=0;
		for(int n=1; n<=1000000000; n*=2) {
			t1=0;
			for(int i=0;i<k;i++){
		t.iniciar();
		Algoritmo.f(n);
		t.parar();
		t1 += t.tiempoPasado();
		t.reiniciar();
			}
			//System.out.println(t1);
			com.add((double)t1/(double)k);
			//System.out.println(t1);
		}
		System.out.println(com.toString());
		com.remove(0);
		System.out.println(com.get(com.size()-1)-com.get(1));
		//System.out.println(masCercano(ratio));
	}
		/*public static void main(String arg[]) {
		List<Double> com = new ArrayList<>();
		long t1=0, t2=0;
		int k=100;
		for(int n=1; n<=1000000; n*=2) {
			t1=0;t2=0;
			for(int i=0;i<k;i++){
				t1 += System.nanoTime();
				Algoritmo.f(n);
				t2 += System.nanoTime();
				//System.out.println(t1+" "+t2);
			}
			com.add((double) ((t2/k)-(t1/k)));
			System.out.println("T("+n+")="+((t2/k)-(t1/k)));
			
		}
		for(int i=0;i<com.size()-1;i++){
			System.out.println(com.get(i+1)/com.get(i));
		}
		}*/
}
