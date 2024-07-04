package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0667 extends LeetcodeProblem {

    int[] constructArray(int _n, int _k) {
        List<Integer> list = new ArrayList<>();
        int maxSoFar = 1;
        list.add(1);
        boolean plus = true;
        while (_k > 0) {
            if (plus) {
                plus = false;
                int num = list.get(list.size() - 1) + _k;
                maxSoFar = Math.max(maxSoFar, num);
                list.add(num);
            } else {
                plus = true;
                list.add(list.get(list.size() - 1) - _k);
            }
            _k--;
        }
        for (int start = maxSoFar + 1; start <= _n; start++) {
            list.add(start);
        }
        int[] result = new int[_n];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
