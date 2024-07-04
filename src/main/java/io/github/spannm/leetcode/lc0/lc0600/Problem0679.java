package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem0679 extends LeetcodeProblem {

    boolean judgePoint24(int[] _nums) {
        return dfs(IntStream.of(_nums).mapToDouble(n -> n).toArray());
    }

    static boolean dfs(double[] _nums) {
        int sz = _nums.length;
        if (sz == 1) {
            return Math.abs(_nums[0] - 24) < 1e-8;
        }

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (i != j) {
                    int len = 0;
                    double[] a = new double[sz - 1];
                    for (int k = 0; k < sz; k++) {
                        if (k != i && k != j) {
                            a[len++] = _nums[k];
                        }
                    }

                    a[len] = _nums[i] + _nums[j];
                    if (dfs(a)) {
                        return true;
                    }

                    a[len] = _nums[i] - _nums[j];
                    if (dfs(a)) {
                        return true;
                    }

                    a[len] = _nums[i] * _nums[j];
                    if (dfs(a)) {
                        return true;
                    }

                    if (_nums[j] > 1e-8) {
                        a[len] = _nums[i] / _nums[j];
                        if (dfs(a)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
