class ProbarEjemplos {
	
	public static void main(String args[]) {
		SubArrayMaximo sam;		
		LectorFicheroEjemplos lf = new LectorFicheroEjemplos("ejemplos.txt");
		
		// Probar el metodo de fuerza bruta
		sam = new SubArrayMaximoN2();
		for(int i=0; i<30; i++) {
			int[] problema = lf.problema(i);
			SolucionSubArrayMaximo ssam = lf.solucion(i);
			SolucionSubArrayMaximo solucionAlumno = sam.resolver(problema);
			if (!solucionAlumno.equivalente(problema, ssam)) {
				System.out.println("No se ha encontrado la solucion correcta a este problema\n");
				System.out.println("Solucion correcta:");
				SubArrayMaximo.salidaProblema(System.out, problema, ssam);
				System.out.println("Solucion hallada:");
				SubArrayMaximo.salidaProblema(System.out, problema, solucionAlumno);
				System.exit(1);
			}
		}
		System.out.println("El metodo de fuerza bruta supera las pruebas de los ejemplos");

		// Probar la solucion de divide y venceras
		sam = new SubArrayMaximoNLOGN();
		for(int i=0; i<100; i++) {
			int[] problema = lf.problema(i);
			SolucionSubArrayMaximo ssam = lf.solucion(i);
			SolucionSubArrayMaximo solucionAlumno = sam.resolver(problema);
			if (!solucionAlumno.equivalente(problema, ssam)) {
				System.out.println("No se ha encontrado la solucion correcta a este problema\n");
				System.out.println("Solucion correcta:");
				SubArrayMaximo.salidaProblema(System.out, problema, ssam);
				System.out.println("Solucion hallada:");
				SubArrayMaximo.salidaProblema(System.out, problema, solucionAlumno);
				System.exit(1);
			}
		}
		System.out.println("El metodo de Divide y Venceras supera las pruebas de los ejemplos");

		// Probar la solucion de complejidad lineal
		sam = new SubArrayMaximoN();
		for(int i=0; i<100; i++) {
			int[] problema = lf.problema(i);
			SolucionSubArrayMaximo ssam = lf.solucion(i);
			SolucionSubArrayMaximo solucionAlumno = sam.resolver(problema);
			if (!solucionAlumno.equivalente(problema, ssam)) {
				System.out.println("No se ha encontrado la solucion correcta a este problema\n");
				System.out.println("Solucion correcta:");
				SubArrayMaximo.salidaProblema(System.out, problema, ssam);
				System.out.println("Solucion hallada:");
				SubArrayMaximo.salidaProblema(System.out, problema, solucionAlumno);
				System.exit(1);
			}
		}

		System.out.println("El metodo de Complejidad Lineal supera las pruebas de los ejemplos");
	}
	
}