package test;

import java.util.Arrays;

class DeadFish {
    public static int[] parse(String s) {



        int x = 0, y = 0;
        int[] arr = new int[(int) Arrays.stream(s.split("")).filter(str -> str.equals("o")).count()];
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            switch (c) {
                default: continue;
                case 'i': {
                    x++;
                    break;
                }
                case 'd': {
                    x--;
                    break;
                }
                case 's': {
                    x *= x;
                    break;
                }
                case 'o': arr[y++] = x;
            }
        }
        return arr;
    }
}

public class DF {
    public static void main(String[] args) {
        int arr[] = DeadFish.parse("iiisdoso");
        for(int i : arr) System.out.println(i);

    }
}
