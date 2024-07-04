package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1352 extends LeetcodeProblem {

    static class ProductOfNumbers {

        private List<Integer> list;

        ProductOfNumbers() {
            add(0);
        }

        void add(int _num) {
            if (_num > 0) {
                list.add(list.get(list.size() - 1) * _num);
            } else {
                list = new ArrayList<>();
                list.add(1);
            }
        }

        int getProduct(int _k) {
            int size = list.size();
            return _k >= size ? 0 : list.get(size - 1) / list.get(size - _k - 1);
        }
    }

}
