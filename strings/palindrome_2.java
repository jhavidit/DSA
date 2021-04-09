package strings;

import java.util.*;

public class palindrome_2 {
    public static void main(String args[])
    {
        // reversing string by converting to char array and swapping using two pointer recursively 
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char s[]  = str.toCharArray();
        if(String.valueOf(rev(s,0,s.length -1)).compareTo(str)==0) 
        System.out.println("Palindrome");
        else 
        System.out.println("Not Palindrome");       
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
