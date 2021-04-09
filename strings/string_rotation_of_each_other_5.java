package strings;

import java.util.*;

/* concate two string and check if other string is present*/
public class string_rotation_of_each_other_5 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int l = s2.length();
        s2 = s2+s2;
        if(s2.contains(s1)&&s1.length()==l)
        System.out.println("Yes");
        else
        System.out.println("No");
        
        in.close();
    }
    
}
