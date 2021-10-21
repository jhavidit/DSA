package backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        gP(n, new StringBuilder(), 0, 0,0);
        return list;
    }

    public void gP(int n, StringBuilder result, int l, int r,int i) {
        if (result.length() == 2 * n) {
            list.add(result.toString());
        } else {
            if (l >= 0 && l < n ) {
                result.append("(");
                gP(n, result, l + 1, r,i+1);
                result.deleteCharAt(result.length() - 1);
            }
            if (l > 0 && r < n && i>0) {
                result.append(")");
                gP(n, result, l, r + 1,i-1);
                result.deleteCharAt(result.length() - 1);
            }

        }

    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
    }
}
