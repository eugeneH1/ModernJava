package test;

import java.util.stream.IntStream;

public class StreamingInts {
    public static void main(String[] args) {
        IntStream.iterate(3, s-> s < 100, s -> s += 2);

    }
}
