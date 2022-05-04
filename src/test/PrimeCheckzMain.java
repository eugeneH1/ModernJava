package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
//test times of finding single prime and making boolean array
class Primee {
    public boolean isPrime(int number) {
        if(number <= 3)
            return number == 1;
        int candidate = (int) Math.sqrt(number);
        return IntStream.rangeClosed(2, candidate).noneMatch(i -> number%i==0);
    }

    Map<Boolean, Integer> isInPrimeArray(int limit) {
        List<Boolean> Prime = new ArrayList<>(limit + 2);
        for(int i = 0; i <=limit; i++) {
            Prime.set(i, true);
        }
        for(int p = 2; p * p < limit + 1; p++) {
            if(Prime.get(p)) {
                for(int i = p; i <= limit; i += p) Prime.set(i, false);
            }
        }


        return new HashMap<>();

    }
}

public class PrimeCheckzMain {
    public static void main(String[] args) {
        Primee p = new Primee();
        System.out.println(p.isPrime(7));

    }
}
