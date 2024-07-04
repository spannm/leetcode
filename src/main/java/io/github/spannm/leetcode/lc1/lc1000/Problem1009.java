package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1009 extends LeetcodeProblem {

    int bitwiseComplement(int _n) {
        if (_n == 0) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        while (_n != 0) {
            list.add(_n & 1);
            _n >>= 1;
        }
        int result = 0;
        int exp = list.size() - 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0) {
                result += Math.pow(2, exp);
            }
            exp--;
        }
        return result;
    }

}
