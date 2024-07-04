package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1381 extends LeetcodeProblem {

    static class CustomStack {
        private final List<Integer> list;
        private final int           maxSize;

        CustomStack(int _maxSize) {
            list = new ArrayList<>();
            maxSize = _maxSize;
        }

        void push(int _x) {
            if (list.size() < maxSize) {
                list.add(_x);
            }
        }

        int pop() {
            return list.isEmpty() ? -1 : list.remove(list.size() - 1);
        }

        void increment(int _k, int _val) {
            for (int i = 0; i < _k && i < list.size(); i++) {
                list.set(i, list.get(i) + _val);
            }
        }
    }

}
