package sample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ints = {1,2,3,4};
		Stream<Integer> strofints = Stream.of(ints);
		Stream<String> song = Stream.of("gently", "down", "the","stream");
		Stream<String> echoes = Stream.generate(() -> "Echo");
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<BigInteger> naturalNums = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
		Stream<Integer> stream2 = Stream.iterate(1, n -> n + 1);
		
		Stream<Character> combined =
				Stream.concat(characterStream("Hello"),characterStream("World"));
	
		Optional<Integer> max = strofints.reduce(Integer::max);
		if (max.isPresent())
			System.out.println("largest: " + max.get());
		
		
		
		List<String> list = Arrays.asList("Joe", "Tom", "Abe");
		Stream<Stream<Character>> result = list.stream().map(s ->characterStream(s));

		
		Stream<String> uniqueWords= Stream.of("merrily", "merrily", "merrily", "gently").distinct();
		uniqueWords.forEach(x -> System.out.println(x));
		
		List<String> words = Arrays.asList("Tom", "Joseph", "Richard");
		Stream<String> longestFirst = words.stream().sorted((String x, String y) -> (new Integer(y.length()).compareTo(new Integer(x.length()))));
		
		Stream<String> longestFirst2 = words.stream().sorted(Comparator.comparing(String::length).reversed());
		System.out.println( words.stream().max(Comparator.comparing(String::length)));
		

		List<String> words1 = Arrays.asList("Joe", "Tom", "Abee");
		int numLongWords = (int) words1.stream().filter(w -> w.length() > 12).count();
		
		Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
		if (largest.isPresent())
				System.out.println("largest: " + largest.get());
		
		Optional<String> largest2 = words.stream().max(Comparator.comparing(String::length));
		if (largest.isPresent())
				System.out.println("largest2: " + largest2.get());
		
		Optional<String> startsWithQ = words.stream().filter(s -> s.startsWith("T")).findFirst();
		if (startsWithQ.isPresent())
			System.out.println("startsWithQ: " + startsWithQ.get());

		
	
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println); 
		

		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		Map<Integer, List<Person>> personsByAge = persons
			    .stream()
			    .collect(Collectors.groupingBy(p -> p.age));

			personsByAge
			    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
			
		Map<Integer, List<Person>> personsByAge1 = persons
				    .stream()
				    .collect(Collectors.groupingBy(p -> p.age));

				personsByAge1
				    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		String phrase = persons
					    .stream()
					    .filter(p -> p.age >= 18)
					    .map(p -> p.name)
					    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

					System.out.println(phrase);
					// In Germany Max and Peter and Pamela are of legal age.
		persons
				    .stream()
				    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
				    .ifPresent(System.out::println);    
		Integer ageSum = persons
			    .stream()
			    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
		
		Integer ageSum2 = persons
			    .stream()
			    .map(p ->p.age)
			    .reduce(0,(a,b) -> a+b);

			System.out.println(ageSum);  // 76

			

			
	}
	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) result.add(c);
		return result.stream();
	}
	
	public static void pickName(List<String> names, String startingLetter) {
			final Optional<String> foundName = names.stream()
															.filter(name ->name.startsWith(startingLetter))
															.findFirst();
			foundName.ifPresent(name -> System.out.println("Hello " +name));
	}
	


	

}
