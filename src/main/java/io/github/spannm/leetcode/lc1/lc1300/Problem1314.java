package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1314 extends LeetcodeProblem {

    int[][] matrixBlockSum(int[][] _mat, int _k) {
        int m = _mat.length;
        int n = _mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> iRange = findRange(i, _k, m);
                List<Integer> jRange = findRange(j, _k, n);
                int sum = 0;
                for (Integer element : iRange) {
                    for (Integer element2 : jRange) {
                        sum += _mat[element][element2];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    private List<Integer> findRange(int _iOrJ, int _k, int _upper) {
        int min = Math.max(_iOrJ - _k, 0);
        int max = _iOrJ + _k >= _upper ? _upper - 1 : _iOrJ + _k;
        List<Integer> range = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            range.add(i);
        }
        return range;
    }

}
