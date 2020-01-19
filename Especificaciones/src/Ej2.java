import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		long num;
		Scanner sc = new Scanner (System.in);
		num=sc.nextInt();
		sc.close();
		boolean p=esFactorial(num);
		System.out.println("¿Es "+num+" un numero que desompuesto es un factorial?");
		System.out.println(p?"si":"no");
	}

	private static boolean esFactorial(long num) {
		int i=0;
		while(num!=fact(i)&& fact(i)<num){
			i++;
		}
		return (num==fact(i))?true:false;
	}

	private static long fact(int i) {
		int k=1;
		for(int j=1;j<=i;j++)k*=j;
		return k;
	}

}
