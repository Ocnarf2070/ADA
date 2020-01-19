/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoN2 extends SubArrayMaximo {

	public SolucionSubArrayMaximo resolver(int[] array) {
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo();
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (ssam.getSumaOptima() < array[j] - array[i]) {
					ssam.setDiaCompra(i);
					ssam.setDiaVenta(j);
					ssam.setSumaOptima(array[j] - array[i]);
				}
			}
		}

		return ssam;
	}
}

