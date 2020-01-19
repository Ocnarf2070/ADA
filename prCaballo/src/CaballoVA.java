
import java.io.*;
import java.util.*;

public class CaballoVA {
    final int numFilas;
    final int numColumnas;
    int[][] tablero;
    int contador;
 
    public CaballoVA(int nf, int nc) {
        numFilas = nf;
        numColumnas = nc;
        tablero     = new int[nf][nc];
    }
 
    public void mostrarTablero() {
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero[i].length; j++) {
                System.out.printf("  %2d  |", tablero[i][j]);
            }
            System.out.println();
            for(int j=0; j<tablero[i].length; j++) System.out.print("------+");
            System.out.println();
        }
       }
       
        protected static void escrituraFich(String fich, List<CaballoVA> g){
        	try (PrintWriter pw = new PrintWriter(fich)) {
        		for(CaballoVA pc:g){
        		pc.escrituraFich(pw);
        		pw.printf("Cantidad de veces que entra al ciclo: %,d %n",  pc.contador);
        		pw.println();
        		}
        		} catch (ArrayIndexOutOfBoundsException e) {
        		System.out.println("ERROR: falta el nombre del fichero");
        		} catch (IOException e) {
        		System.out.println("ERROR: no se puede escribir en el fichero");
        		}
        	}
        private void escrituraFich(PrintWriter pw) {
        	for(int i=0; i<tablero.length; i++) {
                for(int j=0; j<tablero[i].length; j++) {
                    pw.printf("  %2d  |", tablero[i][j]);
                }
                pw.println();
                for(int j=0; j<tablero[i].length; j++) pw.print("------+");
                pw.println();
        	}
    	}
 
    public boolean resolverProblema(int f, int c, int num) {
            contador++;
            tablero[f][c] = num;
            if(num==numFilas*numColumnas) return true;
            int[][] posibles = buscarPosibles(f, c);
            for(int i=0; i<posibles.length; i++) {
            	System.out.println();
            	if(resolverProblema(posibles[i][0], posibles[i][1], num+1)) return true;
            }
            tablero[f][c]=0;
            return false;
    }
 
    int[][] buscarPosibles(int f, int c) {
        int[][] resp = new int[8][2];
        int     pos  = 0;
        if(esValido(f-2,c-1)){ resp[pos][0]=f-2; resp[pos++][1]=c-1; }
        if(esValido(f-2,c+1)){ resp[pos][0]=f-2; resp[pos++][1]=c+1; }
        if(esValido(f-1,c-2)){ resp[pos][0]=f-1; resp[pos++][1]=c-2; }
        if(esValido(f-1,c+2)){ resp[pos][0]=f-1; resp[pos++][1]=c+2; }
        if(esValido(f+2,c-1)){ resp[pos][0]=f+2; resp[pos++][1]=c-1; }
        if(esValido(f+2,c+1)){ resp[pos][0]=f+2; resp[pos++][1]=c+1; }
        if(esValido(f+1,c-2)){ resp[pos][0]=f+1; resp[pos++][1]=c-2; }
        if(esValido(f+1,c+2)){ resp[pos][0]=f+1; resp[pos++][1]=c+2; }
        int[][] tmp = new int[pos][2];
        for(int i=0; i<pos; i++) { tmp[i][0] = resp[i][0]; tmp[i][1]=resp[i][1]; }
        return tmp;
    }
 
    boolean esValido(int f, int c) {
        if(f<0 || f>numFilas-1 || c<0 || c>numColumnas-1) return false;
        if(tablero[f][c]!=0) return false;
        return true;
    }
    

	public static void main(String[] args) {
		List<CaballoVA> g = new ArrayList<>();
    	//for(int i=0;i<5;i++){
    		//for(int j=0;j<5;j++){
        CaballoVA pc = new CaballoVA(5,5);
        pc.resolverProblema(5-1,3-1,1);
        pc.mostrarTablero();
        g.add(pc);
    	//}
    	//}
    		escrituraFich("prueba.txt",g);
    }
}