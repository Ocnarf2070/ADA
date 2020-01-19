/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoN extends SubArrayMaximo {

	public SolucionSubArrayMaximo resolver(int[] array) {
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo();
		 /** Implementar aqui una solucion de complejidad lineal */
		int sum=0;
		for(int i=0;i<array.length-1;i++){
			sum+=(array[i+1]-array[i]);
			if(sum<0){
				sum=0;
				ssam.setDiaCompra(i+1);
			}
			if(ssam.getSumaOptima()<sum){
				ssam.setSumaOptima(sum);
				ssam.setDiaVenta(i+1);
			}
		}
		return ssam;
	}
}
