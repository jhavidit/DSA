package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class Permutations {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permutations(int[] nums) {
        perm(nums, 0, nums.length - 1);
        return list;
    }

    public List<Integer> arrToList(int[] arr) {
        List<Integer> a = new ArrayList<>();
        for (int j : arr) {
            a.add(j);
        }
        return a;
    }

    public void perm(int[] num, int l, int r) {
        if (l == r) {
            List<Integer> c = new ArrayList<>();
            list.add(arrToList(num));
        } else {
            for (int i = l; i <= r; i++) {
                swap(num, l, i);
                perm(num, l + 1, r);
                swap(num, l, i);
            }
        }

    }

    public int[] swap(int[] s, int l, int r) {
        int temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        return s;
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] arr = {1, 2, 3};
        System.out.println(obj.permutations(arr));
    }

}
