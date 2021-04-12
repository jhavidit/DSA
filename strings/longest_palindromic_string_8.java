package strings;

import java.util.*;
public class longest_palindromic_string_8 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(longestPalin(str));
        in.close();
    }

    public static String longestPalin(String S){
        if(S.length()<1)
        return "";
        int start =0;
        int end   = 0;
        int max =0;
        for(int i=0;i<S.length();i++)
        {
            int len1 = expandFromMiddle(S,i,i);
            int len2 = expandFromMiddle(S,i,i+1);
            int len  = Math.max(len1,len2);
            if(len > (end-start) && len>max)
            {
                max = len;
                start = i - (len - 1) / 2;
               end = i + len / 2;
            }
        }
        return S.substring(start,end+1);
        
     }
     
     static int expandFromMiddle(String s, int left, int right){ 
      if(left>right)
     return 0;
     int l = left,r=right;
     while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r)))
     {
         l--;
         r++;
     }
     
     return r- l-1;
         
     }
}
