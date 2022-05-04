package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Temp {

    static void find(List<List<Integer>> a) {
        Integer[][] b = new Integer[a.size()][];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            List<Integer> x = a.get(i);
            b[i] = x.toArray(new Integer[0]);

        }
        for (int i = 0; i < b.length-2; i++) {
            for (int j = 0; j < b[i].length-2; j++) {
                int temp = b[i][j] + b[i][j + 1] + b[i][j + 2] +
                        b[i+1][j+1] +
                       b[i+2][j] + b[i+2][j+1] + b[i+2][j+2];
                if (temp > max) max = temp;
            }
        }
        System.out.println(max);
    }

    static void find2(List<List<Integer>> a) {
        List<Integer> b = new ArrayList<>();



    }
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()));
                ;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Temp.find(arr);


    }
}
