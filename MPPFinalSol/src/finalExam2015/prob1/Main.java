package finalExam2015.prob1;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBigInteger(5);
	}
	public static void printBigInteger(Integer n){
		Stream.iterate(BigInteger.ZERO, s -> s.add(BigInteger.ONE).add(BigInteger.ONE))
				.limit(n)
				.forEach(System.out::println);
	}

}
