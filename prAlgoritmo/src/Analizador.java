import java.util.*;

public class Analizador {

	//private static final int E4=10000;

	public static void main(String[] args) {
		List<Double> com = new ArrayList<>();
		Temporizador t = new Temporizador();
		int i=0;
		boolean ver=true;
		double l = 2;
		rellenar(com,t,20,30,1,4);	
		while(i<(com.size()-1)&&(ver)){
			l=com.get(i+1)/com.get(i);
			System.out.println("P");
			i++;
			if(com.get(i)<=0.1||l<=0.1||l>3){
			ver=false;
			}
			
		}
		if(ver){
			System.out.println("2^N");
		}else if(com.get(i)<=0.1||l<=0.1){
			Polinomico(com,t);
		}else{
			System.out.println("NF");
		}
	}

	private static void Polinomico(List<Double> com, Temporizador t) {
		com.removeAll(com);
		boolean ver=true;
		System.out.println("P");
		rellenar2(com,t,125,5000,2,10);
		int i=0;
		double l;
		while(i<(com.size()-1)&&(ver)){
			l=com.get(i+1)/com.get(i);
			System.out.println("P");
			i++;
			if(l<=4.5||com.get(i)<=0.1){
			ver=false;
			}
		}
		if(ver){
			System.out.println("N^3");
		}else{
			com.removeAll(com);
			System.out.println("P");
			rellenar2(com,t,10000,310000,2,25);
			i=0;
			while(i<(com.size()-1)&&(!ver)){
				l=com.get(i+1)/com.get(i);
				System.out.println("P");
				i++;
				if(l<=3||l>=5||com.get(i)<=0.1){
				ver=true;
				}
			}
			if(!ver){
				System.out.println("N^2");
			}else{
				i=0;
				while(i<(com.size()-1)&&(ver)){
					l=com.get(i+1)/com.get(i);
					System.out.println("P");
					i++;
					if(l<=1.5||l>=3||com.get(i)<=0.01){
					ver=false;
					}
				}
					if(ver){
						System.out.println("Nlog(N)");
					}else{
						com.removeAll(com);
						System.out.println("P");
						rellenar2(com,t,2000000,128000000,2,100);
						i=0;
						while(i<(com.size()-1)&&(!ver)){
							l=com.get(i+1)/com.get(i);
							System.out.println("P");
							i++;
							if(l<=1.5||l>=3||com.get(i)<=0.01){
							ver=true;
							}
						}
						if(!ver){
							System.out.println("N");
						}else{
						PolP(com);
						}
					}
				}
			}
	}


	private static void PolP(List<Double> com) {
		com.removeAll(com);
		double l=0;
		boolean ver=true;
		Temponano t= new Temponano();
		rellenar3(com,t,1,200000000,2,10000);
		com.remove(0);
		int i=0;
		while(i<(com.size()-1)&&ver){
			l=com.get(i+1)/com.get(i);
			if(l<1||l>1.5){
				ver=false;
			}
			i++;
		}
		if(ver){
			System.out.println("logN");
		}else{
			System.out.println("1");
		}
	}

	private static void rellenar3(List<Double> com, Temponano t, int emp, int n,int e, int vec) {
		long t1;
		for(int i=emp;i<=n;i*=e){			
			t1=0;
			for(int j=1;j<=vec;j++){
				t.iniciar();
				Algoritmo.f(i);
				t.parar();
				t1+=t.tiempoPasado();
				t.reiniciar();
			}
			System.out.println(t1);
			com.add((double) t1/(double)vec);			
		}
		System.out.println(com.toString());
		System.out.println();
		for(int i=0;i<com.size()-1;i++){
			double l=com.get(i+1)/com.get(i);
			System.out.println(l);
		}
		
	}

	private static void rellenar2(List<Double> com, Temporizador t, int emp, int n,int e, int vec) {
		long t1;
		for(int i=emp;i<=n;i*=e){			
			t1=0;
			for(int j=1;j<=vec;j++){
				t.iniciar();
				Algoritmo.f(i);
				t.parar();
				t1+=t.tiempoPasado();
				t.reiniciar();
			}
			System.out.println(t1);
			com.add((double) t1/(double)vec);			
		}
		System.out.println(com.toString());
		System.out.println();
		for(int i=0;i<com.size()-1;i++){
			double l=com.get(i+1)/com.get(i);
			System.out.println(l);
		}
		
	}

	private static void rellenar (List<Double> com, Temporizador t, int emp, int n,int e, int vec) {
		long t1;
		for(int i=emp;i<=n;i+=e){			
			t1=0;
			for(int j=1;j<=vec;j++){
				t.iniciar();
				Algoritmo.f(i);
				t.parar();
				t1+=t.tiempoPasado();
				t.reiniciar();
			}
			System.out.println(t1);
			com.add((double) t1/(double)vec);			
		}
		System.out.println(com.toString());
		System.out.println();
		for(int i=0;i<com.size()-1;i++){
			double l=com.get(i+1)/com.get(i);
			System.out.println(l);
		}
		
	}

}
