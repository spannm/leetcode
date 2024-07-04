package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1341 extends LeetcodeProblem {

    int[] kWeakestRows(int[][] _mat, int _k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < _mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < _mat[0].length; j++) {
                if (_mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break;
                }
            }
            list.add(new int[] {i, soldiers});
        }
        list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] result = new int[_k];
        int i = 0;
        while (i < _k) {
            result[i] = list.get(i++)[0];
        }
        return result;
    }

}
