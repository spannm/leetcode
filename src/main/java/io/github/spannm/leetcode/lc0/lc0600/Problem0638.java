package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0638 extends LeetcodeProblem {

    int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs) {
        return shopping(_price, _special, _needs, 0);
    }

    static int shopping(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs, int _i) {
        if (_i == _special.size()) {
            return dot(_needs, _price);
        }
        List<Integer> clone = new ArrayList<>(_needs);
        int j = 0;
        for (; j < _special.get(_i).size() - 1; j++) {
            int diff = clone.get(j) - _special.get(_i).get(j);
            if (diff < 0) {
                break;
            }
            clone.set(j, diff);
        }
        if (j == _special.get(_i).size() - 1) {
            return Math.min(_special.get(_i).get(j) + shopping(_price, _special, clone, _i), shopping(_price, _special, _needs, _i + 1));
        } else {
            return shopping(_price, _special, _needs, _i + 1);
        }
    }

    static int dot(List<Integer> _a, List<Integer> _b) {
        int sum = 0;
        for (int i = 0; i < _a.size(); i++) {
            sum += _a.get(i) * _b.get(i);
        }
        return sum;
    }

}
