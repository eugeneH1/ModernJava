package Chapter3;

import java.util.function.BiFunction;
import static Chapter3.Color.*;
public class lambdaConstructorReferences {
    public static void main(String[] args) {
        BiFunction<Color, Integer, Apple> c3 = Apple::new;
        Apple a1 = c3.apply(GREEN,20 );

    }
}
