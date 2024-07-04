package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1823 extends LeetcodeProblem {

    int findTheWinner(int _n, int _k) {
        List<Integer> list = new ArrayList<>(_n);
        for (int i = 0; i < _n; i++) {
            list.add(i + 1);
        }
        int startIndex = 0;
        while (list.size() != 1) {
            int removeIndex = (startIndex + _k - 1) % list.size();
            list.remove(removeIndex);
            startIndex = removeIndex;
        }
        return list.get(0);
    }

}
