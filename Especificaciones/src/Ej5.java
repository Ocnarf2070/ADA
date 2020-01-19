
public class Ej5 {

	public static void main(String[] args) {
		Object [] v={'a','c','b','j',"bc","gh",'n'};
		alRevez(v);
		for(int i=0;i<v.length;i++)System.out.print(v[i]+" ");
	}

	private static void alRevez(Object[] v) {
		Object aux;
		for(int i=0;i<=v.length/2;i++){
			aux=v[i];
			v[i]=v[v.length-i-1];
			v[v.length-i-1]= aux;
		}
	}

}
