package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1492 extends LeetcodeProblem {

    int kthFactor(int _n, int _k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= _n; i++) {
            if (_n % i == 0) {
                list.add(i);
            }
        }
        return list.size() >= _k ? list.get(_k - 1) : -1;
    }

}
