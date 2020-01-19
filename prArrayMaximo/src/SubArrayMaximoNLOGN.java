/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class SubArrayMaximoNLOGN extends SubArrayMaximo {

	public SolucionSubArrayMaximo resolver(int[] array) {
		SolucionSubArrayMaximo ssam = new SolucionSubArrayMaximo();
		 /** Implementar aqui una solucion mediante el metodo Divide y Venceras */
		int [] a = new int [array.length-1];
		rellenar (array, a);
		ssam=SubArray(a,0,a.length-1,ssam);
		return ssam;
	}

	private SolucionSubArrayMaximo SubArray(int[] a, int inf, int sup, SolucionSubArrayMaximo ssam) {
		int med;
		if(sup-inf==0){
			ssam.setDiaCompra(inf);
			ssam.setDiaVenta(sup+1);
			ssam.setSumaOptima(a[inf]);
		}else{
			SolucionSubArrayMaximo res1= new SolucionSubArrayMaximo();
			SolucionSubArrayMaximo res2= new SolucionSubArrayMaximo();
			SolucionSubArrayMaximo res3= new SolucionSubArrayMaximo();
			med = (sup+inf)/2;
			res1=SubArray(a,inf,med,res1);
			res2=SubArray(a,med+1,sup,res2);
			res3=intermedio(a,med,inf,sup,res3);
			if(res1.getSumaOptima()>res2.getSumaOptima()&&res1.getSumaOptima()>res3.getSumaOptima()){
				ssam=res1;
			}else if(res2.getSumaOptima()>res3.getSumaOptima()){
				ssam=res2;
			}else{
				ssam=res3;
			}
		}
		return ssam;
	}

	private SolucionSubArrayMaximo intermedio(int[] a, int med, int inf, int sup, SolucionSubArrayMaximo ssam) {
		int sum=0;
		SolucionSubArrayMaximo aux= new SolucionSubArrayMaximo();
		for(int i=med;i>=inf;i--){
			sum+=a[i];
			if(aux.getSumaOptima()<sum){
				aux.setDiaCompra(i);
				aux.setDiaVenta(med+1);
				aux.setSumaOptima(sum);
			}
		}
		sum=0;
		for(int i=med+1;i<=sup;i++){
			sum+=a[i];
			if(ssam.getSumaOptima()<sum){
				ssam.setDiaCompra(med+1);
				ssam.setDiaVenta(i+1);
				ssam.setSumaOptima(sum);
			}
		}
		ssam.setDiaCompra(aux.getDiaCompra());
		ssam.setSumaOptima(ssam.getSumaOptima()+aux.getSumaOptima());
		return ssam;
	}

	private void rellenar(int[] array, int[] a) {
		for(int i=0; i<a.length;i++){
			a[i]=array[i+1]-array[i];
		}
	}
	
}
