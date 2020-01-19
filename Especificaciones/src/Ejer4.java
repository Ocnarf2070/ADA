
public class Ejer4 {

	public static void main(String[] args) {
		int [] v={1,4,9,3,5,2,-1,-6,-7,1,2,3,8,2};
		int n=9;
		ordenar(v,n-1);
		for(int i=0;i<v.length;i++)System.out.print(v[i]+" ");
	}

	private static void ordenar(int[] v, int n) {
		int aux=0;
		for(int i=0;i<=n;i++){
			for(int j=i+1;j<=n;j++){
				if(v[i]>v[j]){
					aux=v[j];
					v[j]=v[i];
					v[i]=aux;
				}
			}
		}
	}

}
