import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Esta clase permite manipular un archivo de entrada para generar un archivo
 * comprimido utilizando el algoritmo de huffman.
 * 
 */
public class Compresor {
		
	private long numBytes;
	private String rutaOrigen, rutaDestino;

	/**
	 * Es el constructor de la clase, e inicializa las rutas de origen y destino
	 * 
	 * @param rutaOrigen
	 *            es la ruta de origen
	 * @param rutaDestino
	 *            es la ruta de destino
	 */

	public Compresor(String rutaOrigen, String rutaDestino) {

		this.rutaOrigen = rutaOrigen;
		this.rutaDestino = rutaDestino;
	}


		/**
		 * Permite realizar la compresion de un archivo, escribiendo en la cabecera,
		 * la longitud del archivo con un maximo de 65535 bytes de longitud, ya que
		 * representa un WORD de longitud, la tabla de codigos huffman, y el resto
		 * del archivo comprimido.
		 * 
		 * @throws IOException
		 * @throws FileNotFoundException
		 */
		public void compress() throws IOException, FileNotFoundException {
		
			String temp = "", buffer = "", code = "";
			int byteLeido = 0, tam, parteCod;
			byte tablaTemp[];
			HuffmanAbstract miHuffman = new Huffman();
			FileInputStream lector;
			FileOutputStream escritor;
		
			lector = new FileInputStream(rutaOrigen);
			numBytes = miHuffman.readOrigen(lector);
			lector.close();
			escritor = new FileOutputStream(rutaDestino);
			if (numBytes > 0) { //Solo vamos a comprimir si el fichero origen tiene al menos un caracter
				lector = new FileInputStream(rutaOrigen);
				// ******** Escribimos el tama–o del fichero desglosado en bytes **********
				// Lo necesitaremos saber para no descodificar un caracter de m‡s al final
				for (int i=0;i<4;i++){
					escritor.write((byte)(numBytes%256));
					numBytes/=256;
				}
				
				tablaTemp = miHuffman.getTabla();
		
				// ******** ESCRIBE TABLA **********
				tam = miHuffman.getTamano();
				escritor.write(tam);
		
				for (int i = 0; i < tam; i++) {
					escritor.write(tablaTemp[i]);
					code = miHuffman.getCodigo(i);
					parteCod=Integer.parseInt(code, 2); //Pasamos a Integer el c—digo
					// Como hicimos antes vamos a suponer que los c—digos de Huffman obtenidos NO superar‡n 
					// los 32 bits, por lo que escribiremos 4 bytes por cada c—digo
					for (int j = 0; j < 4; j++) {
						escritor.write((byte) (parteCod % 256));
						parteCod /= 256; 
					}
					
					escritor.write(numZero(code));
				}
		
				// ****** Escribe el resto del fichero comprimido**************
				byteLeido = lector.read();
				while (byteLeido!=-1){		
					code = miHuffman.getCodigo((byte) byteLeido);
					buffer+=code;
					while (buffer.length()>=8){
						temp=buffer.substring(0, 8);
						buffer=buffer.substring(8);
						escritor.write(Integer.parseInt(temp, 2));
					}
					byteLeido = lector.read();
				}
				lector.close();
				
				// Con los caracteres sobrantes..				
				if (buffer.length() > 0){
					for (int j = buffer.length(); j < 8; j++)
						buffer += "0";
					escritor.write(Integer.parseInt(buffer, 2));
				}
			}
			escritor.close();
		}

	/**
	 * Permite saber cuantos ceros tendra delante el codigo huffman para
	 * facilitar la descompresion del archivo.
	 * 
	 * @param code
	 *            es el codigo huffman a analizar
	 * @return el numero de ceros que tendra delante el codigo huffman
	 */

	private int numZero(String code) {
		int cont = 0;
		while ((cont < code.length()-1) && (code.charAt(cont) == '0')) {
			cont++;
		}
		return cont;
	}

}
