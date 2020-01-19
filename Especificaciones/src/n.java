
public class n {

	public static void main(String[] args) {
		int [] a ={5,7,8,1,3};
		int x=6,n=4;
		int men=menoresQue(a,x,n);
		System.out.println(men);

	}

	private static int menoresQue(int[] a, int x, int n) {
		int i=0;
		int res=0;
		while(i<n){
			System.out.println("i: "+i+" n: "+n+"// res: "+res);
			if(a[i]<x)res++;
			i++;
		}
		System.out.println("i: "+i+" n: "+n+" res: "+res);
		return res;
	}

}
