
public class p1 {
	private static final int A=2,B=30;
	public static void main(String[] args) {
		int x=A,y=B,z=1;
		while(y>0){
			System.out.println("x: "+x+" y: "+y+" z: "+z);
			if((y%2)==0){
				y=y/2;x=x*x;
			}else{
				y--;z=z*x;
			}
		}
		System.out.println("x: "+x+" y: "+y+" z: "+z);
		System.out.println((int)(Math.pow(A, B)));
	}
	

}
