package test;

import java.util.stream.IntStream;
interface Convert {
    void map(int i);
}

public class FizzBuzz {
    public static void fb(int i) {
        StringBuilder a = new StringBuilder();
        if(i%3==0) a.append("Fizz");
        if(i%5==0) a.append("Buzz");
        if(!a.isEmpty()) System.out.println(a);
        else System.out.println(i);
    }

    public static void main(String[] args) {
        IntStream.range(1, 100).forEach(FizzBuzz::fb);

    }
}
