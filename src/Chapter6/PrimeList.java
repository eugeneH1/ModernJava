package Chapter6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// test range... figure out threshold. check against boolean array

public class PrimeList {
    static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate%i == 0);
    }
    static boolean isPrime2(int candidate) {
        int root = (int) Math.sqrt(candidate);
        return IntStream.range(2, root).noneMatch(i -> candidate%i == 0);
    }
    static boolean isPrime3(int candidate) {
        if(candidate <= 3) {
            return candidate != 1;
        }
        int root = (int) Math.sqrt(candidate);
        return IntStream.iterate(3, s -> s <= root, s -> s += 2).noneMatch(i -> candidate%i == 0);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Map<Boolean, List<Integer>> partitionedPrimes = IntStream.rangeClosed(2, 1000).boxed()
                .collect(Collectors.partitioningBy(PrimeList::isPrime2));
        long otherTime = System.nanoTime() - startTime;
        System.out.println(otherTime);


        System.out.println(partitionedPrimes);
        long myTime = System.nanoTime();

        Map<Boolean, List<Integer>> partitionedPrimes2 = IntStream.rangeClosed(2, 1000).boxed()
                .collect(Collectors.partitioningBy(PrimeList::isPrime2));
        long difference = otherTime - (System.nanoTime() - myTime);
        System.out.println("faster by: " + difference);
        System.out.println(partitionedPrimes2);



    }
}
