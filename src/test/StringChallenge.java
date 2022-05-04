package test;

public class StringChallenge {
    public static void main(String[] args) {
        String myString = "good";
        char[] myCharArray = {'g', 'o', 'o', 'd'};
        String newString = null;
        System.out.println(newString);

        for(char ch: myCharArray) {
            newString = newString + ch;
        }

        System.out.println((myString == newString) + " " + myString.equals(newString));
        System.out.println(newString);
    }
}
