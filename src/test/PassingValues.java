package test;

public class PassingValues {
    public static void main(String[] args) {
        int pritiveInt = 2;
        Integer referenceInt = 2;
        inc(pritiveInt);
        System.out.println(pritiveInt);
        refInc(referenceInt);
        System.out.println(referenceInt);

    }
    static void inc(int i) {
        i++;
    }
    static void refInc(Integer i) {
        i = i+1;
    }
    <T extends Number> void increment(T i) {

    }
}
