import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


public class Huffman extends HuffmanAbstract {

	/**
	 * Permite generar el arbol de codigos huffman sin establecer los c�digos. Este paso se realizar� en el m�todo
	 * generarListaCodigo de la clase HuffmanAbstract
	 */
	public void generarArbol(){
		//A IMPLEMENTAR POR EL ALUMNO
		while(primero.getDerecha()!=null){
		Nodo aux=new Nodo('\u0000', primero.getFrecuencia()+primero.getDerecha().getFrecuencia(), false);
		aux.setHijoIzq(primero);
		aux.setHijoDer(primero.getDerecha());
		aux=ubicarNodo(aux,primero);
		primero=primero.getDerecha().getDerecha();
		}
		raizArbol=primero;
	}

	/**
	 * Metodo principal para realizar pruebas
	 */
	public static void main(String arg[]) throws FileNotFoundException, IOException {
		HuffmanAbstract h = new Huffman();
		//String text = "j'aime aller sur le bord de l'eau les jeudis ou les jours impairs";
		String text="AAABBBBBBCCCCDEEEFGG";
		InputStream is = new ByteArrayInputStream(text.getBytes("UTF-8"));
		h.readOrigen(is);
		h.imprimirArbol(h.raizArbol,"");
		h.imprimirListaCodigos();
	}
	

}
