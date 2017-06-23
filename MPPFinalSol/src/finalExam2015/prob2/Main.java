package finalExam2015.prob2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;

public class Main {

	public static final List<Dish> menu=
			Arrays.asList(new Dish("pork",false,800,Type.MEAT),
					new Dish("beef",false,700,Type.MEAT),
					new Dish("chicken",false,400,Type.MEAT),
					new Dish("french fires",true,530,Type.MEAT),
					new Dish("rice",true,350,Type.OTHER),
					new Dish("season fruit",true,120,Type.OTHER),
					new Dish("pizza",true,550,Type.OTHER),
					new Dish("prawns",false,400,Type.FISH),
					new Dish("salmon",false,450,Type.FISH)
					);
	public static void main(String[] args) {
		System.out.println(listDish(menu));
		//System.out.println(listDish3(menu));
		//System.out.println(listDishName(menu));
		//System.out.println(isContains(menu, "french"));
		//System.out.println(maxCalories(menu));
	}
	public static List<String> listDish(List<Dish> dishes){
//		return dishes.stream()
//							.filter(x -> x.getCalories()>400)
//							.filter(x -> x.isVegeterian() == false)
//							.map(x -> x.toString())
//							.collect(Collectors.toList());
		return LibraryMember.LISTDISH.apply(menu, 400);
	}
	public static List<Dish> listDish3(List<Dish> dishes){
		return dishes.stream()
							.filter(x -> x.getType() == Type.MEAT)
							.sorted(Comparator.comparing(x -> x.getCalories()))
							.limit(3)
							.collect(Collectors.toList());
	}
	public static String listDishName(List<Dish> dishes){
		return dishes.stream()
							.map(x -> x.getName())
							.collect(Collectors.joining(",","[","]"));
	}
	public static boolean isContains(List<Dish> dishes, String dishName){
		Optional<Dish> check = dishes.stream().filter(x -> x.getName().equals(dishName))
				                        .findAny();
		if(check.isPresent()) return true;
		else return false;
	}
	public static Optional<Dish> maxCalories(List<Dish> dishes){
		//return dishes.stream().mapToInt(x -> x.getCalories()).max();
//		return dishes.stream().map(x -> x.getCalories())
//		               .reduce(Integer::max);
		return dishes.stream().max(Comparator.comparing(x -> x.getCalories()));
	}
}
