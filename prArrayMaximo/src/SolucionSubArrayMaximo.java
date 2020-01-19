import java.lang.reflect.Array;

/**
 * Clase auxiliar para devolver una solucion del problema del SubArrayMaximo
 * @author Ricardo Conejo
 */
class SolucionSubArrayMaximo {

	protected final static int SIN_CALCULAR = Integer.MIN_VALUE;

	protected int sumaOptima=SIN_CALCULAR;	
	protected int diaCompra=SIN_CALCULAR;
	protected int diaVenta=SIN_CALCULAR;


	public SolucionSubArrayMaximo() {
		sumaOptima=SIN_CALCULAR;	
		diaCompra=SIN_CALCULAR;
		diaVenta=SIN_CALCULAR;
	}

	public SolucionSubArrayMaximo(int sumaOptima, int diaCompra, int diaVenta) {
		setSumaOptima(sumaOptima);
		setDiaCompra(diaCompra);
		setDiaVenta(diaVenta);
	}
	
	public void setSumaOptima(int sumaOptima) {
		this.sumaOptima = sumaOptima;
	}
	public int getSumaOptima() {
		 return sumaOptima;
	}
	
	public void setDiaCompra(int diaCompra) {
		this.diaCompra = diaCompra;
	}
	public int getDiaCompra() {
		 return diaCompra;
	}

	public void setDiaVenta(int diaVenta) {
		this.diaVenta = diaVenta;
	}
	public int getDiaVenta() {
		 return diaVenta;
	}

	
	public boolean equals(Object obj){
		boolean equals = false;
		if (obj instanceof SolucionSubArrayMaximo) {
			SolucionSubArrayMaximo ssam = (SolucionSubArrayMaximo) obj;
			equals = (this.sumaOptima == ssam.sumaOptima && this.diaCompra == ssam.diaCompra && this.diaVenta == ssam.diaVenta);
		}
		return equals;
	}
	
	public boolean equivalente(int[] array, SolucionSubArrayMaximo ssam){
		boolean equivalente = false;
		if (this.sumaOptima == ssam.sumaOptima && array[ssam.diaVenta] - array[ssam.diaCompra] == ssam.sumaOptima) {
			equivalente = true;
		}
		return equivalente;
	}
	
	
	public String toString() {
		String str = "";
		if (sumaOptima!=SIN_CALCULAR && diaCompra!=SIN_CALCULAR && diaVenta!=SIN_CALCULAR) {
			str = "comprar dia "+diaCompra + "; vender dia "+diaVenta +"; beneficio = "+sumaOptima + ";";
		} else {
			str = "SINCALCULAR";
		}
		return str;
	}
	
}
