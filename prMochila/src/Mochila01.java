import java.util.Arrays;

public class Mochila01{
	public static class Objetos{//Clase de los objetos que hay que meter en la mochila
	private  int peso;
	private int valor;
	private double razon;
	public Objetos(int p,int v){
		peso=p;
		valor=v;
		razon=(double)v/(double)p;
	}
	public int getPeso() {
		return peso;
	}
	public int getValor() {
		return valor;
	}
	public double getRazon() {
		return razon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + peso;
		long temp;
		temp = Double.doubleToLongBits(razon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objetos other = (Objetos) obj;
		if (peso != other.peso)
			return false;
		if (Double.doubleToLongBits(razon) != Double.doubleToLongBits(other.razon))
			return false;
		return true;
	}
	public String toString(){
		return "(Peso: "+getPeso()+", Valor: "+getValor()+")";
	}
	
	}

	public static void AV(Objetos[] obj,Objetos[] obj2, int M, boolean[] sol, Objetos[] sol2){
		int cap=0;
		int n=0;
		for(int i=0;i<obj2.length;i++){
			cap+=obj2[i].peso;
			if(cap<=M){
				sol2[n]=obj2[i];
				n++;
			}else{
				cap-=obj2[i].peso;
			}
		}
		sol2=Arrays.copyOf(sol2, n);
		busqueda(obj,sol,sol2);
	}

	private static void Ordenar(Objetos[] obj2, int ref) {
		switch(ref){
		case 1:
			for(int i=0;i<(obj2.length-1);i++){
				for(int j=i+1;j<obj2.length;j++){
					if(obj2[i].getPeso()>obj2[j].getPeso()){
						Objetos variableauxiliar=obj2[i];
						obj2[i]=obj2[j];
						obj2[j]=variableauxiliar;

					}else if(obj2[i].getPeso()==obj2[j].getPeso()&&obj2[i].getValor()<obj2[j].getValor()){
						Objetos variableauxiliar=obj2[i];
						obj2[i]=obj2[j];
						obj2[j]=variableauxiliar;

					}
				}
			}
			break;
		case 2:
			for(int i=0;i<(obj2.length-1);i++){
				for(int j=i+1;j<obj2.length;j++){
					if(obj2[i].getValor()<obj2[j].getValor()){
						Objetos variableauxiliar=obj2[i];
						obj2[i]=obj2[j];
						obj2[j]=variableauxiliar;

					}else if(obj2[i].getValor()==obj2[j].getValor()&&obj2[i].getPeso()>obj2[j].getPeso()){
							Objetos variableauxiliar=obj2[i];
							obj2[i]=obj2[j];
							obj2[j]=variableauxiliar;

						}
					}
				}
			break;
		case 3:
			for(int i=0;i<(obj2.length-1);i++){
				for(int j=i+1;j<obj2.length;j++){
					if(obj2[i].getRazon()<obj2[j].getRazon()){
						Objetos variableauxiliar=obj2[i];
						obj2[i]=obj2[j];
						obj2[j]=variableauxiliar;

					}
				}
			}
			break;
		}
		
	}
	private static void busqueda(Objetos[] obj, boolean[] sol, Objetos[] sol2) {
		Objetos[] aux=sol2;
		int i=0,j;
		for(i=0;i<obj.length;i++){
			j=0;
			while(sol[i]==false&&j<aux.length){
				if(obj[i].equals(aux[j])){
					sol[i]=true;
					for(int k=j;k<aux.length-1;k++)aux[k]=aux[k+1];
					aux=Arrays.copyOf(aux, aux.length-1);
				}
				j++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int [][] o={{2,12},{1,10},{3,20},{2,15},{1,5}};
		Objetos [] obj=new Objetos [o.length];
		for(int i=0; i<obj.length;i++){
			int p=o[i][0];
			int v=o[i][1];
			Objetos k=new Objetos(p, v);
			obj[i]=k;
		}
		Objetos [] obj2=Arrays.copyOf(obj, obj.length);
		Ordenar(obj2,1);
		boolean [] sol=new boolean [obj.length];
		Objetos [] sol2=new Objetos [obj.length];
		int M = 5,i=0;
		AV(obj,obj2,M,sol,sol2);
		System.out.println("Por Peso");
		System.out.println();
		for(i=0;i<obj.length;i++)System.out.println(((sol[i]==false)?"0":"1")+" "+obj[i].toString());
		System.out.println();
		
		obj2=Arrays.copyOf(obj, obj.length);
		sol=new boolean [obj.length];
		sol2=new Objetos [obj.length];
		Ordenar(obj2,2);
		AV(obj,obj2,M,sol,sol2);
		System.out.println("Por Valor");
		System.out.println();
		for(i=0;i<obj.length;i++)System.out.println(((sol[i]==false)?"0":"1")+" "+obj[i].toString());
		System.out.println();
		
		obj2=Arrays.copyOf(obj, obj.length);
		sol=new boolean [obj.length];
		sol2=new Objetos [obj.length];
		Ordenar(obj2,3);
		AV(obj,obj2,M,sol,sol2);
		System.out.println("Por Razon Valor-Peso");
		System.out.println();
		for(i=0;i<obj.length;i++)System.out.println(((sol[i]==false)?"0":"1")+" "+obj[i].toString());
		System.out.println();
	}
}
