package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String processFile(BuffereReaderProcessor p ) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/eugeneheynike/Desktop/DoYouBelieve/plan.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String a = processFile((BufferedReader::readLine));
        System.out.println(a);
    }
    public static double doubleMeth(double a) {
        return a;
    }
    public String toString() {
        return Double.toString(doubleMeth(2.0));
    }
}
