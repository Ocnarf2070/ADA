
import java.util.*;

public class Complejidad{
	public Complejidad(){
		
	}
	public Map<Integer,List<Double>> tabla() {

		Map<Integer,List<Double>> res=new TreeMap<>();
		for(int i=1;i<=8;i++){
			int n=5;
				List<Double> num= new ArrayList<>();
				switch(i){
				case 1: for(int j=1;j<=n;j++) num.add((double) 1);break;
				case 2: for(int j=1;j<=n;j++) num.add(Math.log(j)/Math.log(2));break;
				case 3: for(int j=1;j<=n;j++) num.add((double)j);break;
				case 4: for(int j=1;j<=n;j++) num.add(j*Math.log(j)/Math.log(2));break;
				case 5: for(int j=1;j<=n;j++) num.add((double)j*j);break;
				case 6: for(int j=1;j<=n;j++) num.add((double)j*j*j);break;
				case 7: for(int j=1;j<=n;j++) num.add((double)Math.pow(2, j));break;
				case 8: for(int j=1;j<=n;j++) num.add((double)factorial(j));break;
				}
				res.put(i, num);
			}
		return res;
	}

	private static int factorial(int i) {
		int res;
		if(i==0){
			res=1;
		}else{
			res=i*factorial(i-1);
		}
		return res;
	}

}