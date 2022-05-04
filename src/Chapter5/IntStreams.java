package Chapter5;

import java.util.stream.IntStream;

public class IntStreams {
    public static void main(String[] args) {
        IntStream evenNumber = IntStream.rangeClosed(1, 100)
                .filter(n -> n%2==0);
        System.out.println(evenNumber.count());
    }
}
