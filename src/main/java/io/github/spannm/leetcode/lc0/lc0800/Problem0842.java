package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence.
 */
class Problem0842 extends LeetcodeProblem {

    private final List<Integer> ans = new ArrayList<>();
    private String              num;

    List<Integer> splitIntoFibonacci(String _num) {
        num = _num;
        dfs(0);
        return ans;
    }

    private boolean dfs(int _i) {
        if (_i == num.length()) {
            return ans.size() >= 3;
        }
        long x = 0;
        for (int j = _i; j < num.length(); j++) {
            if (j > _i && num.charAt(_i) == '0') {
                break;
            }
            x = x * 10 + num.charAt(j) - '0';
            if (x > Integer.MAX_VALUE
                || ans.size() >= 2 && x > ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                break;
            }
            if (ans.size() < 2 || x == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                ans.add((int) x);
                if (dfs(j + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

}
