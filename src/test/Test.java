package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;

class Prime {
    void checkPrime(int... n) {
        int low = n[0];
        ArrayList<Integer> solution = new ArrayList<>(5);
        for(int k = 0; k<n.length; k++) {
            if(n[k] < 2) continue;
            boolean[] prime = new boolean[(n[k])+1];
            for(int i = 0; i <= n[k]; i++) prime[i] = true;

            for(int p = 2; p * p <= n[k]; p++) {
                if(prime[p]) {
                    for(int i = p * p; i <= n[k]; i += p) {
                        prime[i] = false;
                    }
                }
            }
            for(int i = 2; i <= n[k]; i++) {
                if(prime[i]) {
                    if (solution.contains(i)) continue;
                    solution.add(i);
                }
            }
        }
        for(int i: solution) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        int n1 = Integer.parseInt(br.readLine());
//        int n2 = Integer.parseInt(br.readLine());
//        int n3 = Integer.parseInt(br.readLine());
//        int n4 = Integer.parseInt(br.readLine());
//        int n5 = Integer.parseInt(br.readLine());

        Prime ob = new Prime();
        ob.checkPrime(7, 2);
//        ob.checkPrime(n1, n2);
//        ob.checkPrime(n1, n2, n3);
//        ob.checkPrime(n1, n2, n3, n4, n5);
    }
}
