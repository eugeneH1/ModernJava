package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigInt {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BigInteger b1 = new BigInteger(br.readLine());
            BigInteger b2 = new BigInteger(br.readLine());

            BigInteger a1 = b1.add(b2);
            BigInteger a2 = b1.multiply(b2);

            System.out.println(a1);
            System.out.println(a2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }








    }
}
