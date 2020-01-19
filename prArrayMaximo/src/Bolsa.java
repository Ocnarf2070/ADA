class Bolsa {
	
	public static void main(String args[]) {
		SubArrayMaximo sam = new SubArrayMaximoN();		
		int[] problema = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
		SolucionSubArrayMaximo solucion = sam.resolver(problema);
		SubArrayMaximo.salidaProblema(System.out, problema, solucion);
	}
	
}