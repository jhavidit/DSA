package strings;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean areIsomorphic(String str1, String str2) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (!hashMap.containsKey(c1)) {
                if(hashMap.containsValue(c2))
                    return false;
                hashMap.put(c1, c2);
            } else {
                if (hashMap.get(c1) != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(areIsomorphic("paper","title"));
    }

}
