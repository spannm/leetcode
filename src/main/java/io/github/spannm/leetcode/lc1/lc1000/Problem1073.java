package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1073. Adding Two Negabinary Numbers.
 */
class Problem1073 extends LeetcodeProblem {

    int[] addNegabinary(int[] _arr1, int[] _arr2) {
        int i1 = _arr1.length - 1;
        int i2 = _arr2.length - 1;
        List<Integer> ans = new ArrayList<>();
        for (int c = 0; i1 >= 0 || i2 >= 0 || c != 0; --i1, --i2) {
            int a = i1 < 0 ? 0 : _arr1[i1];
            int b = i2 < 0 ? 0 : _arr2[i2];
            int x = a + b + c;
            c = 0;
            if (x >= 2) {
                x -= 2;
                c -= 1;
            } else if (x == -1) {
                x = 1;
                c += 1;
            }
            ans.add(x);
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }

}
