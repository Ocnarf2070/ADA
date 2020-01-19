import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Esta clase permite la descompresion de un archivo previamente
 * comprimido usando el algoritmo de huffman.

 *
 */

public class Decompresor {
	
	private String rutaOrigen;
	private String rutaDestino;
	
	/**
	 * Es el constructor de la clase, e inicializa las rutas del archivo
	 * origen y destino respectivamente
	 * @param rutaOrigen
	 * @param rutaDestino
	 */
	
	public Decompresor(String rutaOrigen, String rutaDestino){
		
		this.rutaOrigen = rutaOrigen;
		this.rutaDestino = rutaDestino;		
	}
	
	/**
	 * Descomprime un archivo de extension, generando la tabla de codigos,
	 * y a su vez el nuevo archivo descomprimido.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void deCompress() throws FileNotFoundException, IOException{
		
		String buffer="", auxTemp, codigos[], zerosStr="";
		int tamano=0, byteLeido=0, codigo, zeros=0, i,j, numBytes=0, cont=0;
		byte tablaTemp[];
		FileOutputStream escritor;
		FileInputStream lector;
		boolean encontrado=false;
		
		lector = new FileInputStream(rutaOrigen);
		//****LEEMOS el tama–o del fichero
		for (int k=0; k<4; k++)
			numBytes+=(lector.read()*Math.pow(256,k));
		
		
		tamano=lector.read();
		if (tamano!=-1){		
			
			
			//***** LEEMOS LA TABLA ***********************		
			tablaTemp = new byte[tamano];
			codigos = new String[tamano];
			escritor = new FileOutputStream(rutaDestino);
			
			for(i=0; i<tamano; i++){
				tablaTemp[i]= (byte)lector.read(); codigo=0;
				for(j=0; j<4; j++){
					codigo+=(lector.read()*Math.pow(256,j));
				}				
				codigos[i]=Integer.toBinaryString(codigo);
				zeros=lector.read(); zerosStr="";
				for (j=0;j<zeros;j++) zerosStr+="0";
				codigos[i]=zerosStr+codigos[i];
			}

			byteLeido = lector.read();
			buffer=SerieBits(byteLeido);
			//Iremos buscando de manera creciente una ocurrencia en la tabla de c—digos. Cuando esta ocurra, tendremos el caracter.
			// Sino ocurre, abr‡ que unir el siguiente c—digo y seguir.

			auxTemp=""; i=0;
			while (byteLeido!=-1 && cont<numBytes){
				auxTemp+=buffer.charAt(i); j=0;
				while ((j<codigos.length) && (!encontrado)){
					if (auxTemp.equals(codigos[j])){
						escritor.write(tablaTemp[j]);
						cont++;  //Hemos escrito un nuevo byte
						encontrado=true;
					}
					j++;
				}
				i++;

				if (encontrado) {
					buffer=buffer.substring(i);
					i=0;
					auxTemp="";
					encontrado=false;
				}
				if (i==buffer.length()){
					byteLeido = lector.read();
					buffer+=SerieBits(byteLeido);

				}
			}
			escritor.close();
		}
		lector.close();

	}
	
	/**
	 * Devuelve una serie de 8 bits a partir del byte de lectura.
	 * @param byte leido de fichero
	 * @returns String con 8 bits
	 */
	private String SerieBits(int byteLeido){
		String temp=Integer.toBinaryString(byteLeido);
		while (temp.length()<8) temp="0"+temp;
		return temp;
	}
}

