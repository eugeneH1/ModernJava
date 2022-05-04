package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

class Primes {
    void checkPrime(int... n) {
        int z = 0; // index variable for solution array
        int[] solution = new int[5]; // solution array of primes in argument
        for (int i = 0; i < 5; i++) solution[i] = 0; // initialised to 0. if 0 not printed


        for(int x = 0; x < n.length; x++) { // loop through arguments testing if prime

            if(n[x] == 1) continue; //skip if argument is one
            if(n[x] <= 3) { // if argument is two or three then is prime -> add to solution and continue
                solution[z++] = n[x];
                continue;
            }

            boolean isPrime = true;
            for(int i = 3; i < (int)Math.sqrt(n[x]); i+=2) {
                if(n[x]% i == 0) {
                    isPrime = false;
                    break;
                }

            }
            if(isPrime)  solution[z++] = n[x];
        }
        for(int i: solution) {
            if(i != 0)
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class Test2 {
    public static void main(String[] args) throws IOException {
        Primes p = new Primes();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        int n4 = Integer.parseInt(br.readLine());
        int n5 = Integer.parseInt(br.readLine());

        p.checkPrime(n1);
        p.checkPrime(n1, n2);
        p.checkPrime(n1, n2, n3);
        p.checkPrime(n1, n2, n3, n4, n5);
    }

}

