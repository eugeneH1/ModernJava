package Chapter5;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);
        printFibonacci(100);


    }
    public static void printFibonacci(int limit) {
        System.out.println(Stream.iterate(new int[] {0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(15)
                .map(t -> String.valueOf(t[0]))
                .collect(Collectors.joining(", ")));
    }
}
