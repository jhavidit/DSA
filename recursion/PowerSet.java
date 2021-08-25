package recursion;


import java.util.ArrayList;

public class PowerSet {

    public static void powerSet(ArrayList<Character> input, ArrayList<Character> output, int index) {

        if (index >= input.size()) {
            System.out.println(output);
            return;
        }

        powerSet(input, output, index + 1);
        output.add(input.get(index));

        powerSet(input, output, index + 1);


    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        input.add('a');
        input.add('b');
        input.add('c');
        powerSet(input, output, 0);
    }

}
