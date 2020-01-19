package prPruebas;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int [] [] C = {{1,2,8},{4,5,3},{1,7,9}};
		int [] st = new int [C.length];
		for(int i=0;i<st.length;i++){
			st[i]=-1;
		}
		int [] s=new int [C.length]; 
		for(int i=0;i<s.length;i++){
			s[i]=Integer.MAX_VALUE;
		}
		s=Algoritmo(C,st,0,s);
		System.out.println(sum(s,C)+" ");
		for (int i=0;i<s.length;i++) System.out.print(s[i]+1+",");
	}

	public static int[] Algoritmo(int[][] c, int[] st, int n,int [] s) {
		for(int i=0;i<c[0].length;i++){
			if(valido(i,st)&&n!=s.length){
					st[n]=i;
					s=Algoritmo(c,st,n+1,s);
					if(n==s.length-1){
						if(s[0]==Integer.MAX_VALUE || sum(s,c)>sum(st,c))s=Arrays.copyOf(st, st.length);
					}
					st[n]=0;
					
			}
		}
		return s; // busca otras soluciones, ya que buscamos el minimo
		
	}

	private static boolean valido(int i, int[] s) {
		int j=0;
		while(j<s.length&&i!=s[j])j++;
		return (j>=s.length);
	}

	private static int sum(int[] s, int[][] c) {
		int sum=0;
		for (int i=0;i<s.length;i++){
			sum+=c[i][s[i]];
		}
		return sum;
	}

}
