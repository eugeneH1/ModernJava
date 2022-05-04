package test;

interface PerformOperation {
    boolean check(int a);
}
public class PerfOp {
    PerformOperation isOdd() {
        return n -> (n&1)==1;
    }
    public static void main(String[] args) {

    }
}
