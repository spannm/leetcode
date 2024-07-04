package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem2180 extends LeetcodeProblem {

    int countEven(int _num) {
        int ans = 0;
        for (int i = 1; i <= _num; i++) {
            List<Integer> list = getAllDigits(i);
            int sum = 0;
            for (int l : list) {
                sum += l;
            }
            if (sum % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    private List<Integer> getAllDigits(int _num) {
        List<Integer> ans = new ArrayList<>();
        while (_num != 0) {
            ans.add(_num % 10);
            _num /= 10;
        }
        return ans;
    }

}
