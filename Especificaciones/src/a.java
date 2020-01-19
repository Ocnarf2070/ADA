
public class a {

	public static void main(String[] args) {
		System.out.println(factorial(7));

	}

	private static int factorial(int x) {
		int a=1,y=1;
		while(a<x){
			System.out.println("ak: "+a+" x: "+x+" y: "+y);
			a=a+1;
			y=y*a;
		}
		System.out.println("as: "+a+" x: "+x+" y: "+y);
		return y;
	}

}
