/**Esta clase representa un elemento (Nodo) del arbol huffman
 * Y tiene como atributos una letra, una frecuencia, un nodo izquierda y derecha
 * para la lista enlazada, y un nodo hijoIzq e hijoDer para los dos hijos en el arbol huffman
 */
public class Nodo {
	
	private char letra;
	private int frecuencia;
	private boolean tipo; // true representa que el nodo es un nodo hoja, false que es un nodo intermedio
	private Nodo derecha, izquierda;
	private Nodo hijoIzq, hijoDer;
	
	/**
	 * Este es el constructor de la clase e inicializa la frecuencia, la letra y el tipo
	 * del nodo
	 * @param letra
	 * @param frecuencia
	 * @param tipo
	 */
	public Nodo(char letra, int frecuencia, boolean tipo){
		this.letra=letra;
		this.frecuencia=frecuencia;
		this.tipo=tipo;
	}
	
	/**
	 * Devuelve el hijo Izquierdo del Nodo
	 * @return un Nodo
	 */
	public Nodo getHijoIzq() {
		return hijoIzq;
	}

	/**
	 * Permite a–adir el hijo izquierdo del Nodo
	 * @param hijoIzq Es el Nodo a añadir
	 */
	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	/**
	 * Devuelve el hijo derecho del Nodo
	 * @return un Nodo
	 */
	public Nodo getHijoDer() {
		return hijoDer;
	}

	/**
	 * Permite añadir el hijo derecho del nodo
	 * @param hijoDer un nood
	 */
	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}
	/**
	 * Devuelve el hijo derecho del nodo
	 * @return un nodo
	 */
	public Nodo getDerecha() {
		return derecha;
	}
	
	/**
	 * Permite a–adir un nodo a la derecha del nodo
	 * @param derecha el nuevo nodo
	 */
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	/**
	 * Devuelve el nodo izquierda
	 * @return un nodo
	 */
	public Nodo getIzquierda() {
		return izquierda;
	}
	/**
	 * Añade un nodo a la izquierda
	 * @param izquierda el nuevo nodo
	 */
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	/**
	 * Devuelve la letra que representa el Nodo
	 * @return una letra
	 */
	public char getLetra() {
		return letra;
	}
	/**
	 * Permite asignar una nueva letra al Nodo
	 * @param letra la letra nueva
	 */
	public void setLetra(char letra) {
		this.letra = letra;
	}
	/**
	 * Obtiene la frecuencia del Nodo
	 * @return un entero
	 */
	public int getFrecuencia() {
		return frecuencia;
	}
	/**
	 * Permite asignar la frecuencia de un nodo
	 * @param frecuencia
	 */
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Devuelve el tipo del nodo
	 * @return 
	 */
	public boolean isHoja() {
		return tipo;
	}
	/**
	 * Asigna el tipo a un nodo
	 * @param tipo el nuevo tipo
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "letra = <"+getLetra()+">" + " frecuencia="+ getFrecuencia();
	}

}
