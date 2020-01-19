import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Esta clase permite generar un arbol binario de codigos huffman.
 *
 */
public abstract class HuffmanAbstract {
	
	protected Nodo primero; // Contiene un enlace al primer nodo de la lista
						  // Par moverse por la lista inicial de nodos se usa 
						  // getDerecha() y getIzquierda()
	protected Nodo raizArbol; // Contiene un enlace al nodo raiz del arbol Huffman
	protected byte tabla[]; // Es un array con los símbolos distintos.
	protected String listaCodigos[];
	protected int tamano; //Cantidad de símbolos distintos
	protected int cont; //Iterador de la lista de códigos.
	
	/**
	 * Es el constructor de la clase Huffman e inicializa el tamaño
	 * de la misma a cero
	 * 
	 */
	
	public HuffmanAbstract(){
		primero=null;
		tamano=cont=0;
	}
	
	/**
	 * Permite leer el archivo de entrada para generar la tabla de frecuencias
	 * de los bytes correspondientes y un objeto con el arbol Huffman
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public int readOrigen(InputStream lector) throws IOException, FileNotFoundException {
		int byteLeido;
		int numBytes = 0;
		if (lector!=null) {
			int tabla[]=new int[256];
			do {
				byteLeido = lector.read();
				if (byteLeido != -1) {
					tabla[byteLeido]++;
					numBytes++;
				}
			} while (byteLeido != -1);
			generarHuffman(tabla);
		}
		return numBytes;
	}
	
	/**
	 * Agrega un nuevo nodo al final de la lista doblemente enlazada
	 * @param miNodo Es el nodo que se desea añadir
	 */
	public void agregarElemento(Nodo miNodo){
		if(primero==null){
			primero=miNodo;
		}
		else{
			Nodo aux=primero;
			while(aux.getDerecha()!=null)
				aux=aux.getDerecha();
			aux.setDerecha(miNodo);
			miNodo.setIzquierda(aux);
		}
		tamano++;
	}
	/**
	 * Ordena la lista doblemente enlazada de nodos por medio de su frecuencia de menor
	 * a mayor. Utiliza el método de burbuja.
	 *
	 */
	public void ordenar(){
		
		Nodo aux1=primero;
		Nodo aux2=aux1;
		int tempFrec;
		char tempLetra;
				
		while(aux1!=null){
			
			while(aux2.getDerecha()!=null){
				if(aux2.getFrecuencia()>aux2.getDerecha().getFrecuencia()){
					tempFrec=aux2.getFrecuencia();
					tempLetra=aux2.getLetra();
					aux2.setFrecuencia(aux2.getDerecha().getFrecuencia());
					aux2.setLetra(aux2.getDerecha().getLetra());
					aux2.getDerecha().setFrecuencia(tempFrec);
					aux2.getDerecha().setLetra(tempLetra);
				}
				aux2=aux2.getDerecha();
			}
			aux2=primero;
			aux1=aux1.getDerecha();
        }
	}
		
	/**
	 * Permite generar el arbol de codigos huffman sin establecer los códigos. Este paso se realizará en el método
	 * generarListaCodigo.
	 */
	abstract public void generarArbol(); 
		//A IMPLEMENTAR POR EL ALUMNO
	
	/**
	 * Permite ubicar un nodo en la lista enlazada tomando como referencia la frecuencia
	 * del nodo y el byte que representa.
	 * @param miNodo es el nodo a añadir
	 * @param aux2 es el nodo desde donde se empezara a recorrer la lista
	 * @return el nodo ubicado en la lista
	 */
	public Nodo ubicarNodo(Nodo miNodo, Nodo aux2){
		Nodo aux=aux2;
	
		while (aux!=null) {
			if(miNodo.getFrecuencia()<=aux.getFrecuencia()){
				aux.getIzquierda().setDerecha(miNodo);
				miNodo.setIzquierda(aux.getIzquierda());
				aux.setIzquierda(miNodo);
				miNodo.setDerecha(aux);
				return miNodo;
			}
			if(aux.getDerecha()==null){
				aux.setDerecha(miNodo);
				miNodo.setIzquierda(aux);
				break;
			}
			aux=aux.getDerecha();
		}
		return miNodo;
	}
		
	/**
	 * Genera la lista de códigos huffman para todos los nodos hoja que componen
	 * el arbol huffman.
	 * @param miNodo es el nodo desde donde se empezara a recorrer el arbol (raiz)
	 * @param cadena es la cadena inicializada en "" que permite modificarse con la recursion
	 * y sera la cadena que se le asigna como codigo huffman al nodo.
	 */
	public void generarListaCodigo(Nodo miNodo, String cadena){
		if(miNodo!=null){
			if(miNodo.isHoja()){
				if (cadena.isEmpty()){ //En el caso de que halla un solo nodo en el árbol
					listaCodigos[cont] = "0";
				}
				else {
					listaCodigos[cont] = cadena;
				}
				tabla[cont]=(byte)miNodo.getLetra();
				cont++;
			}
			generarListaCodigo(miNodo.getHijoIzq(), cadena +"0");
			generarListaCodigo(miNodo.getHijoDer(), cadena +"1");
		}
	}
	
	/**
	 * Permite crear todos los nodos que poseen frecuencias y añadirlos a la lista enlazada
	 * para crear el arbol huffman a partir de una tabla  de frecuencias. Si tabla[i]=c, entonces el carácter c aparece i veces.
	 */
	
	public void generarHuffman(int tabla[]){
		for (int i = 0; i < tabla.length; i++) {
			if(tabla[i] !=0){
				Nodo aux=new Nodo((char)i, tabla[i], true);
				agregarElemento(aux);
			}
		}
		ordenar();		
		generarArbol();
		this.tabla=new byte[tamano];
		listaCodigos = new String[tamano];
		generarListaCodigo(raizArbol, "");
	}
	
	/**
	 * Permite obtener el codigo huffman de un byte determinado.
	 * @param Es el byte que se desea saber su codigo huffman
	 * @return el codigo huffman en formato String
	 */
	public String getCodigo(byte valor){
		for(int i=0; i<tamano; i++)
			if(tabla[i]==valor )
				return listaCodigos[i];
		return null;
	}

	/**
	 * Permite obtener el codigo huffman a partir de una posición en la lista de códigos
	 * @param posición de la lista
	 * @return el código de huffman en formato String
	 */
	public String getCodigo(int i){
		if ((i>=0) && (i<tamano)) return listaCodigos[i];
		else return null;
		
	}

	/**
	 * Permite una String con la lista de códigos de una cadena de entrada
	 * @param posición de la lista
	 * @return el código de huffman en formato String de la cadena completa
	 */
	public String getCodigo(String st){
		String stCodificada = "";
		if (st!=null) {
			for (int i=0; i<st.length(); i++) {
				byte valor = (byte) st.charAt(i);
				String codigo = getCodigo(valor);
				if (codigo!=null) {
					stCodificada += codigo;
				} else {
					stCodificada += "_"; // Error, codigo inexistente
				}
			}
		}
		return stCodificada;
	}

	
	
	/**
	 * Devuelve la tabla de frecuencias
	 * @return la tabla de las frecuencias
	 */
	public byte[] getTabla() {
		return tabla;
	}
	/**Devuelve el numero de Nodos en la lista Huffman
	 * @return un entero
	 */
	public int getTamano() {
		return tamano;
	}

	
	/**
	 * Metodos auxiliares para depuracion, 
	 * Imprime el arbol huffman a partir de un nodo 
	 * Se llama mediante la instrucción "imprimeArbol(raizArbol,"");"
	 * @param nodo el nodo raiz
	 * @param offset, se usa para producir un efecto de identacion.
	 */
	protected void imprimirArbol(Nodo nodo, String offset) {
		if (nodo!=null) {
			System.out.println(offset + nodo);
			imprimirArbol(nodo.getHijoIzq(),offset+"|   ");
			imprimirArbol(nodo.getHijoDer(),offset+"|   ");
		}
	}
	
	/**
	 * Metodo auxiliar para depuracion.
	 * Escribe la lista de nodos y sus frecuencias 
	 * Se llama mediante la instruccion "imprimeLista(primero);"
	 * @param nodo
	 */
	protected void imprimirLista(Nodo nodo) {
		if (nodo!=null) {
			System.out.println(nodo);
			imprimirLista(nodo.getDerecha());
		}
	}
	
	/**
	 * Metodo auxiliar para depuracion.
	 * Escribe la lista de simbolos y sus correspondientes codigos
	 */
	protected void imprimirListaCodigos() {
		if (listaCodigos!=null) {
			for(int i=0; i<listaCodigos.length; i++) {
				System.out.println("simbolo = <"+ (char) tabla[i] + "> codigo = "+listaCodigos[i]);
			}
		}
	}
	
	
}
