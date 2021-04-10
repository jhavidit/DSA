package strings;

import java.util.*;
public class count_and_say_7 {

    /* brute force checking in string if letters are same sequentialy increasing frequency till another letter come 
    concatenation of frequency and letter */

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(countAndSay(n));
        in.close();
    }
    public static String countAndSay(int n) {
        int c  = 1 ;
        String ans = "1";
        String a = "";
       while(n>1)
       {
             
        for(int i=0;i<ans.length()-1;i++)
        {
            if(ans.charAt(i)==ans.charAt(i+1))
                c++;
            else
            {
                a = a+""+c+""+ans.charAt(i);
                c = 1;
            }
        }
            a = a+""+c+""+ans.charAt(ans.length()-1);
           ans = a;
           a="";
           c=1;
           n--;
       }
       
        return ans;
        
    }
    
    
}
