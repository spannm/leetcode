package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1756 extends LeetcodeProblem {
    static class MRUQueue {
        private final List<Integer> list;

        MRUQueue(int _n) {
            list = new ArrayList<>(_n);
            for (int i = 1; i <= _n; i++) {
                list.add(i);
            }
        }

        public int fetch(int _k) {
            int fetched = list.remove(_k - 1);
            list.add(fetched);
            return fetched;
        }
    }

}
