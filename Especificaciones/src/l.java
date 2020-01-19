
public class l {

	public static void main(String[] args) {
		int [] a = {1,5,3,2,6,1,2};
		int n=5;
		System.out.println(MaximoHasta(a,n));

	}

	private static int MaximoHasta(int[] a, int n) {
		int x=a[0],i=1;
		while(i<n){
			System.out.println("i: "+i+" n: "+n+" x: "+x);
			if(x<a[i])x=a[i];
			i++;
		}
		System.out.println("i: "+i+" n: "+n+" x: "+x);
		return x;
	}

}
