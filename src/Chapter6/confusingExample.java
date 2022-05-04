package Chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class confusingExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(), // 1st arg

                (List<Integer> l, Integer e) -> { // 2nd arg
                l.add(e);
                return  l;},

                (List<Integer> l1, List<Integer> l2) -> { // 3rd arg
                l1.addAll(l2);
                return l1;
                }
                );
        System.out.println(numbers);

    }
}
