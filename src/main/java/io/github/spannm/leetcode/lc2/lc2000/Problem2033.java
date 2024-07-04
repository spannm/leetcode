package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem2033 extends LeetcodeProblem {

    int minOperations(int[][] _grid, int _x) {
        List<Integer> list = new ArrayList<>();
        for (int[] element : _grid) {
            for (int j = 0; j < _grid[0].length; j++) {
                list.add(element[j]);
            }
        }
        if (list.size() <= 1) {
            return 0;
        }
        Collections.sort(list);
        int median = list.get(list.size() / 2);
        int ops = 0;
        for (Integer element : list) {
            int diff = Math.abs(element - median);
            if (diff % _x != 0) {
                return -1;
            }
            ops += diff;
        }
        return ops / _x;
    }

}
