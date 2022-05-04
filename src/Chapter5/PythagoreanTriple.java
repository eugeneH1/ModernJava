package Chapter5;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {
    public static void main(String[] args) {
        AtomicInteger z = new AtomicInteger(1);
        Stream<int[]> pyTuples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                            .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[] {a, b, (int) Math.sqrt(a*a + b*b)})
                            );
        pyTuples.forEach(ints -> System.out.println(ints[0] + ", " + ints[1] + ", " + ints[2] + " count: " + z.getAndIncrement()));

        Stream<double[]> better = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
                                .filter(t -> t[2]%1 == 0));
        // imperative
        int x = 0, y = 0;
        int[][] pTups = new int[63][3];
        for (int i = 1; i < 100; i++) {
            for (int j = i; j <= 100; j++) {
                double sqrt = Math.sqrt(i * i + j * j);
                if(sqrt % 1 ==0) {
                    pTups[x][y++] = i;
                    pTups[x][y++] = j;
                    pTups[x++][y] = (int) sqrt;
                    y = 0;
                }
            }
        }

        System.out.println("Imperative:");
        int c = 1;
        for(int[] a: pTups) {
            if(a[0]>0)
                System.out.println(a[0] + ", " + a[1] + ", " + a[2] + " count: " + c++);
            }

    }
}
