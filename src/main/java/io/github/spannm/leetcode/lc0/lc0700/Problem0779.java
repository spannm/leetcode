package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0779 extends LeetcodeProblem {

    static int kthGrammar(int _n, int _k) {
        if (_n == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, _n - 1) / 2;

        if (_k <= mid) {
            return kthGrammar(_n - 1, _k);
        } else {
            return 1 - kthGrammar(_n - 1, _k - mid);
        }
    }

    int kthGrammar2(int _n, int _k) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(0));
        for (int i = 1; i <= _n; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = lists.get(i - 1);
            for (Integer integer : prev) {
                if (integer == 0) {
                    curr.add(0);
                    curr.add(1);
                } else {
                    curr.add(1);
                    curr.add(0);
                }
            }
            lists.add(curr);
        }
        Integer result = lists.get(_n).get(_k - 1);
        lists = null;
        System.gc();
        return result;
    }

}
