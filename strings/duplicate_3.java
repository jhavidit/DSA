package strings;
import java.util.*;

public class duplicate_3 {

    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(h.containsKey(str.charAt(i)))
                h.put(str.charAt(i), h.get(str.charAt(i)) + 1);
            else
            h.put(str.charAt(i),1);
        }

        for(Map.Entry mapElement : h.entrySet())
        {
            char key = (char)mapElement.getKey();
            int value = ((int)mapElement.getValue());

           
            System.out.println(key + ", count = " + value);
        }

        in.close();
    }
    
}
