package test;

import java.util.Locale;
import java.util.Scanner;

public class ScanTest {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String name = scan.next();
       System.out.println(name);
       scan.close();



    }
}
