import java.util.Arrays;

public class o {

	public static void main(String[] args) {
		int num=40111104;
		String temp = Integer.toString(num);
		int[] a = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
		    a[i] = temp.charAt(i) - '0';
		}
		System.out.println(esCapicua(a,a.length));
	}

	private static boolean esCapicua(int[] a, int n) {
		int i=0;
		boolean capicua=true;
		while((capicua)&&(i+1!=n/2)){
			System.out.println("i: "+i+" n: "+((n/2)));
			capicua=(a[i]==a[n-i-1]);
			i++;
		}
		System.out.println("i: "+i+" n: "+((n/2)));
		return capicua;
	}

}
