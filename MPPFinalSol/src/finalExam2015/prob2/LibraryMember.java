package finalExam2015.prob2;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LibraryMember {

	public static BiFunction<List<Dish>, Integer, List<String>> LISTDISH=
			(dishes,calorie) -> dishes.stream()
											.filter(x -> x.getCalories()>calorie)
											.filter(x -> x.isVegeterian() == false)
											.map(x -> x.toString())
											.collect(Collectors.toList());
}
