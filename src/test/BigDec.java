package test;

import java.math.BigDecimal;
import java.util.*;

public class BigDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n+2];
        for(int i =0; i< n; i++) {
            s[i] = sc.next();
        }
        sc.close();
        s = Arrays.stream(s).filter(Objects::nonNull).toArray(String[]::new);

        Arrays.sort(s, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));

        Arrays.sort(s, (s1, s2) -> {
            BigDecimal a = new BigDecimal(s1);
            BigDecimal b = new BigDecimal(s2);
            return a.compareTo(b);
        });

        Arrays.sort(s, Comparator.comparing(BigDecimal::new));

        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                BigDecimal a = new BigDecimal(o1);
                BigDecimal b = new BigDecimal(o2);
                return a.compareTo(b);
            }
        }));

        for(String wow: s) {
            System.out.println(wow);
        }



    }
}
