package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0509 extends LeetcodeProblem {

    int fib(int _n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= _n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(_n);
    }

}
