package test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    static int functionalMerchant(List<Integer> ar) {
        return 3; //figure out how to do this in a stream
    }
    static int sockMerchant(int n, List<Integer> ar) {
        int count = 0;
        for (int i = 0; i < ar.size(); i++) {
            int c = ar.get(i);
            for (int j = i + 1; j < ar.size(); j++) {
                if(c == ar.get(j)) {
                    ar.remove(i);
                    ar.remove(j - 1);
                    count++;
                    i = -1;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>(List.of(10, 20, 20, 10, 10, 30, 50, 10, 20));

        System.out.println(Test3.sockMerchant(9, ar));


    }
}
