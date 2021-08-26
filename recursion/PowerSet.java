package recursion;


import java.util.ArrayList;

public class PowerSet {

    public static void powerSet(String input, String output, int index) {

        if (index >= input.length()) {
            System.out.print("{"+output+"}, ");
            return;
        }

        powerSet(input, output, index + 1);
        output+=input.charAt(index);

        powerSet(input, output, index + 1);


    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        input.add('a');
        input.add('b');
        input.add('c');
        powerSet("abc", "", 0);
    }

}
