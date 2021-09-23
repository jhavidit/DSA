package queue.importantQuestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstNonRepeatingCharacterInAStream {

    public String FirstNonRepeating(String A)
    {
        StringBuilder s = new StringBuilder();
        int[] freq = new int[26];
        Deque<Character> queue = new LinkedList<>();
        for(int i = 0;i<A.length();i++){
            char ch = A.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a']==1){
                queue.add(ch);
            }else if(freq[ch-'a']==2){
                Stack<Character> stack = new Stack<>();
                while(!queue.isEmpty() && queue.getFirst()!=ch){
                    stack.push(queue.removeFirst());
                }
                if(!queue.isEmpty())
                queue.removeFirst();
                while (!stack.isEmpty()){
                    queue.addFirst(stack.pop());
                }
            }
            if(queue.isEmpty())
                s.append("#");
            else s.append(queue.getFirst());
        }
        return s.toString();
    }

    public static void main(String[] args){
        FirstNonRepeatingCharacterInAStream obj = new FirstNonRepeatingCharacterInAStream();
        System.out.println(obj.FirstNonRepeating("aabcab"));
    }



}
