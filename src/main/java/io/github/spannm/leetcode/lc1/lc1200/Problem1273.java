package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1273 extends LeetcodeProblem {

    int deleteTreeNodes(int _nodes, int[] _parent, int[] _value) {
        int len = _parent.length;
        for (int i = len - 1; i > 0;) {
            int sum = 0;
            int parentIndex = _parent[i];
            while (i > 0 && _parent[i] == parentIndex) {
                sum += _value[i--];
            }

            _value[parentIndex] = _value[parentIndex] + sum;
        }

        for (int i = 0; i < _value.length; i++) {
            if (_value[i] == 0) {
                for (int j = 0; j < _parent.length; j++) {
                    if (_parent[j] == i) {
                        _value[j] = 0;
                    }
                }
            }
        }
        return (int) Arrays.stream(_value).filter(i -> i != 0).count();
    }

}
