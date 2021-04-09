package strings;

import java.util.Arrays;
import java.util.Scanner;

public class reverse_string_1 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char s[]  = str.toCharArray();
        System.out.println(Arrays.toString(rev(s,0,s.length -1)));
        
        in.close();

        
    }

    public static char[] rev(char s[], int left, int right)
    {
        if(left>right)
        return s;
        
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            return rev(s,left+1,right-1);
        
    }
    
}
