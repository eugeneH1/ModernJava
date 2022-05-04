package Chapter6;


import Dishes.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Arrays.asList;

enum CaloricLevel {DIET, NORMAL, FAT}

public class CollectingDishes {
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
                new Dish("salmon", false, 450, Dish.Type.FISH));

        /**
         * counting dishes
         */

        long howManyDishes1 = menu.stream().collect(Collectors.counting());
        long howManyDishes2 = menu.stream().count();
        long howManyDishes = menu.size();


        /**
         * finding max and min values
         */
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloricDish1 = menu.stream()
                .collect(maxBy(dishCaloriesComparator));

        //Recommended
        Optional<Dish> mostCaloricDish = menu.stream().max(dishCaloriesComparator);


        /**
         * summarization
         */
        int totalCalories1 = menu.stream().collect(summingInt(Dish::getCalories));
        //recommended
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();


        double averageCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        // summary statistics object
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        // map to string using Collectors.joining
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        // System.out.println(shortMenu);

        // sum of calories
        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        //recommended
        int totalCalories3 = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);

        Optional<Dish> maxCalories = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        Optional<Dish> maxCalories2 = menu.stream()
                .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);

        int totalCalories4  = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        /**
         * grouping
         */
        //dishes by type
        Map<Dish.Type, List<Dish>> dishByType = menu.stream().collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));


        //problematic because if no element satisfies filter criteria no map key will be created
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));

        //add an empty Fish key
        Map<Dish.Type, List<Dish>> caloricDishByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));

        //dishe names by type
        Map<Dish.Type, List<String>> dishNamesByType = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<Dish.Type, Set<String>> dishNamesByTypes =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
                                toSet())));

        /**
         * multilevel grouping
         */

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesbyTypeCaloricLevel =
                menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));

        /**
         * collecting data in subgroups
         */
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));

        //Most caloric by type
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(Comparator.comparingInt(Dish::getCalories))));
       //without optional
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        //intellij suggestion
        Map<Dish.Type, Dish> mostCaloricByType3 = menu.stream()
                .collect(toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));



        //total calories by type
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));


        //        Caloric level by type;
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;},
                                toSet())));

//        Caloric level by type 2
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType2 = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;},
                                toCollection(HashSet::new))));


        /**
         * partitioning
         */
//        Partitioned by vegetarian
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        List<Dish> vegetarianDishes = partitionedMenu.get(true);

        List<Dish> vegetarianDishes2 = menu.stream().filter(Dish::isVegetarian).collect(toList());

        /**
         * advantages of partitioning
         */
        //veg dish by type
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(
                        Dish::isVegetarian, groupingBy(Dish::getType)));

        //most caloric partioned by vegetarian
        Map<Boolean, Dish> mostCaloricByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));

//        Veg over 500 calories
        Map<Boolean, Map<Boolean, List<Dish> >> isVegOver500 = menu.stream()
                .collect(
                        partitioningBy(Dish::isVegetarian, partitioningBy(dish -> dish.getCalories() > 500)));

//        Number of veg
        Map<Boolean,Long> numberOfVeg = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
//        System.out.println(numberOfVeg);


    }
}
