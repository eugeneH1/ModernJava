package Dishes;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import static java.util.stream.Collectors.toList;



public class Demo1 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                     new Dish("pork", false, 800, Dish.Type.MEAT),
      new Dish("beef", false, 700, Dish.Type.MEAT),
      new Dish("chicken", false, 400, Dish.Type.MEAT),
      new Dish("french fries", true, 530, Dish.Type.OTHER),
      new Dish("rice", true, 350, Dish.Type.OTHER),
      new Dish("season fruit", true, 120, Dish.Type.OTHER),
      new Dish("pizza", true, 550, Dish.Type.OTHER),
      new Dish("prawns", false, 300, Dish.Type.FISH),
      new Dish("salmon", false, 450, Dish.Type.FISH) );

    List<String> threeHighCaloricDishNames =
            menu.stream()
                    .filter(
                            x -> {
                                System.out.println("filtering: " + x.getName());
                                return x.getCalories() > 300;
                    })
                    .map(x -> {
                        System.out.println("mapping: " + x.getName());
                        return  x.getName();
                    })
                    .limit(3)
                    .collect(toList());
        // System.out.println(threeHighCaloricDishNames);


        // count of dishes
        int dishes = menu.stream()
                .mapToInt(i -> 1)
                //.reduce(0, Integer::sum);
                        .sum();
//        System.out.println(dishes);
        int dishCount = menu.size();

//      max calories
        Optional<Integer> maxCalories = menu.parallelStream()
                .map(Dish::getCalories)
                .reduce(Integer::max);
        System.out.println(maxCalories.isPresent() ? maxCalories.get() : "oops");

        // total calories
        int totalCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(totalCalories);

        long howManyDishes = menu.size();
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().max(dishCaloriesComparator);


    }
}
