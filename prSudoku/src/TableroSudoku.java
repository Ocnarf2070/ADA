// ALUMNO:Franco Emanuel González Sánchez
// GRUPO:  

import java.util.*;


public class TableroSudoku implements Cloneable {
	
	// constantes relativas al n� de filas y columnas del tablero
	protected static final int MAXVALOR=9; 
	protected static final int FILAS=9; 
	protected static final int COLUMNAS=9; 
							 
	protected static Random r = new Random();
	
	protected int celdas[][]; // una celda vale cero si est\u00E1 libre.
	
	public TableroSudoku() {
		celdas = new int[FILAS][COLUMNAS]; //todas a cero.
	}

	// crea una copia de su par\u00E1metro
	public TableroSudoku(TableroSudoku uno) {
		TableroSudoku otro = (TableroSudoku) uno.clone();
		this.celdas = otro.celdas;
	}

	// crear un tablero a parir de una configuraci\u00D3n inicial (las celdas vac\u00EDas
	// se representan con el caracter ".".
    public TableroSudoku(String s) {
    	this();
    	if(s.length() != FILAS*COLUMNAS) {
    		throw new RuntimeException("Construcci\u00D3n de sudoku no v\u00E1lida.");
    	} else {
    		for(int f=0;f<FILAS;f++) 
				for(int c=0;c<COLUMNAS;c++) {
					Character ch = s.charAt(f*FILAS+c);
					celdas[f][c] = (Character.isDigit(ch) ? Integer.parseInt(ch.toString()) : 0 ); 
				}		
		}		
    }

	
	/* Realizar una copia en profundidad del objeto
	 * @see java.lang.Object#clone()
	 */
	public Object clone()  {
		TableroSudoku clon;
		try {
			clon = (TableroSudoku) super.clone();
			clon.celdas = new int[FILAS][COLUMNAS]; 
			for(int i=0; i<celdas.length; i++)
				System.arraycopy(celdas[i], 0, clon.celdas[i], 0, celdas[i].length);
		} catch (CloneNotSupportedException e) {
			clon = null;
		}	
		return clon;
	}
	
	/* Igualdad para la clase
	 * @see java.lang.Object#equals()
	 */
	public boolean equals(Object obj) {
		if (obj instanceof TableroSudoku) {
			TableroSudoku otro = (TableroSudoku) obj;
			for(int f=0; f<FILAS; f++)
				if(!Arrays.equals(this.celdas[f],otro.celdas[f]))
					return false;
			return true;		
		} else
			return false;
	}
	


	public String toString() {
		String s = "";

		for(int f=0;f<FILAS;f++) {
			for(int c=0;c<COLUMNAS;c++) 
				s += (celdas[f][c]==0 ? "." : String.format("%d",celdas[f][c])); 
		}
		return s;	
	}


	// devuelva true si la celda del tablero dada por fila y columna est\u00E1 vac\u00EDa.
	protected boolean estaLibre(int fila, int columna) {
		return celdas[fila][columna] == 0;
	}
	
	// devuelve el n�mero de casillas libres en un sudoku.
	protected int numeroDeLibres() {
		int n=0;
	    for (int f = 0; f < FILAS; f++) 
	        for (int c = 0; c < COLUMNAS; c++)
	        	if(estaLibre(f,c))
	        		n++;
	    return n;
	}
	
	protected int numeroDeFijos() {
		return FILAS*COLUMNAS - numeroDeLibres();
	}

	// Devuelve true si @valor ya esta en la fila @fila.
	protected boolean estaEnFila(int fila, int valor) {
		// A completar por el alumno
		int i=0;
		while(i<COLUMNAS&&valor!=(celdas[fila][i]))i++;
		return (i<COLUMNAS)?true:false;
	}    

	// Devuelve true si @valor ya esta en la columna @columna.
	protected boolean estaEnColumna(int columna, int valor) {
		int i=0;
		while(i<FILAS && valor!=(celdas[i][columna]))i++;
		return (i<FILAS)?true:false;
	}    
	

	// Devuelve true si @valor ya esta en subtablero al que pertence @fila y @columna.
	protected boolean estaEnSubtablero(int fila, int columna, int valor) {
		// A completar por el alumno
		boolean esta=false;
		int i=0,j=0;
		int nfil=3*(fila/3),ncol=3*(columna/3);
		
		while(i<3&&!esta){
			j=0;
			while(j<3&&!esta){
				if(valor==(celdas[nfil+i][ncol+j]))esta=true;
				j++;
			}
			i++;
		}
		return esta;		
	}    

	
	// Devuelve true si se puede colocar el @valor en la @fila y @columna dadas.
	protected boolean sePuedePonerEn(int fila, int columna, int valor) {
		// A completar por el alumno
		return estaLibre(fila,columna)&&!estaEnFila(fila,valor)&&!estaEnColumna(columna,valor)&&!estaEnSubtablero(fila,columna,valor);
	}
	
	
	

	protected void resolverTodos(List<TableroSudoku> soluciones, int fila, int columna) {
		// A completar por el alumno
		int libre=numeroDeLibres();
		if(fila>=FILAS){
			columna++;
			fila=0;
		}
		for(int i=1;i<=MAXVALOR;i++){
			if(columna<COLUMNAS&&fila<FILAS){
				if(!estaLibre(fila,columna)){
					resolverTodos(soluciones,fila+1,columna);
					return;
				}
				if(sePuedePonerEn(fila,columna,i)){
					celdas[fila][columna]=i;
					resolverTodos(soluciones,fila+1,columna);
					celdas[fila][columna]=0;
				}
				if(i>=MAXVALOR)	return;
			}
				//System.out.println(libre);
				if(libre==0){//System.out.println("g");
					soluciones.add(new TableroSudoku(this));
					libre++;
					return;
				}
				
		}
		
	}


	public List<TableroSudoku> resolverTodos() {
		//System.out.println(sePuedePonerEn(1,1,2));
		List<TableroSudoku> sols  = new LinkedList<TableroSudoku>();
		resolverTodos(sols, 0, 0);
		return sols;
	}


	public static void main(String arg[]) {
		TableroSudoku t = new TableroSudoku( 
				"....25......714.5.547.96..871.9.28.6...163...63..8.1.54....19.3.7.5...6.3.....5..");

		List<TableroSudoku> lt = t.resolverTodos();
		for(Iterator<TableroSudoku> i= lt.iterator(); i.hasNext();) {
			TableroSudoku ts = i.next(); 
			System.out.println(ts);

		}
		System.out.println(t);
		System.out.println(lt.size());

	}
	
	
}
