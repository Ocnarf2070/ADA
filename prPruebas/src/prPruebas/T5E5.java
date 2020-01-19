package prPruebas;

import java.util.Scanner;

public class T5E5 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int [] k={100,300,500,100,800,400,100};
		System.out.println("Escribe el tamaño del deposito:");
		Scanner teclado = new Scanner (System. in);
		int M=teclado.nextInt();
		int num=Algoritmo(k,M);
		System.out.println("El minimo de paradas es: "+num);
		
	}

	private static int Algoritmo(int[] k, int m) {
		int sum=m,num=0,n=0;
		while(n<k.length){
			sum-=k[n];
			if(sum<0){
				sum=m-k[n];
				num++;
			}
			if(k[n]>m){
				System.out.println("Deposito agotado");
				return num;
			}
			n++;
		}
		return num;
	}

}
