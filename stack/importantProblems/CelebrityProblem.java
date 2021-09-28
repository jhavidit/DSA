package stack.importantProblems;

import java.util.Stack;

public class CelebrityProblem {

    public int findCelebrity(int[][] M, int n) {

        int i = 0, j = n - 1;
        while (i < j) {
            if (M[j][i] == 1)
                j--;
            else
                i++;
        }
        int candidate = i;

        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[i][candidate] == 0
                        || M[candidate][i] == 1)
                    return -1;
            }
        }

        return candidate;

    }

    boolean knows(int a,int b,int[][] M){
        return M[a][b] == 1;
    }

    public int findCelebrityUsingStack(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while (stack.size()>1){
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a,b,M))
                stack.push(b);
            else if(knows(b,a,M))
                stack.push(a);

        }
        if (stack.isEmpty()){
            return -1;
        }
        int c = stack.pop();
        for(int i = 0;i<n;i++) {
            if (i != c && (knows(c, i, M) ||
                    !knows(i, c, M)))
                return -1;
        }
        return c;


    }


}
