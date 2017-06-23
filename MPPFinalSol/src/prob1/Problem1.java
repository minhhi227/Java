package prob1;

import java.util.function.BiFunction;

//work with this lambda expression:   (Double x, Double y) -> x * y < x + y
public class Problem1 {
	// name and type of lambda goes here
	BiFunction<Double, Double, Boolean> f1 = (x, y) -> x * y < x + y;
	
	// representing lambda as a method refrence
	BiFunction<Double, Double, Boolean> f2 = Problem1::check;
	
	
	//representing lambda as a static nested class
	class myBifunction implements BiFunction<Double,Double,Boolean>{

		@Override
		public Boolean apply(Double t, Double u) {
			// TODO Auto-generated method stub
			return t*u < t+u;
		}
		
	}
	
	public static Boolean check(Double x, Double y){
		return x*y<x+y;
	}
	//evaluate with Double inputs 2.1, 0.35
	public void evaluator() {
		System.out.println(f1.apply(2.1, 0.35));
		System.out.println(f2.apply(2.1, 0.35));
		myBifunction f3 = new myBifunction();
		System.out.println(f3.apply(2.1, 0.35));
		
	}
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.evaluator();
	}
	
	
}
