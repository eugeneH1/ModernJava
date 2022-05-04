package Chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;

import static Chapter3.Color.*;

public class comparingListItems {
    public static void main(String[] args) {
        BiFunction<Color, Integer, Apple> createApple = Apple::new;
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Color c;
            if(i%2==0) c = GREEN;
            else c = RED;
            apples.add(createApple.apply(c, c.equals(GREEN) ? i*10 : i*5));
        }
//        List<Integer> list = Stream.of(1, 2, 3, 4, 5).toList();
//        List<Integer> list2 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
//        for(Integer i : list) System.out.println(i);
//        list2.forEach(System.out::println);

        apples.sort(comparing(Apple::getWeight));
        apples.stream().map(Apple::toString).forEach(System.out::println);




    }
}
