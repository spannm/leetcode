package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0356 extends LeetcodeProblem {

    boolean isReflected(int[][] _points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : _points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String str = point[0] + "a" + point[1];
            set.add(str);
        }
        int sum = max + min;
        for (int[] p : _points) {
            String str = sum - p[0] + "a" + p[1];
            if (!set.contains(str)) {
                return false;
            }
        }
        return true;
    }

}
