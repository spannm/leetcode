package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2554 extends LeetcodeProblem {

    int maxCount(int[] _banned, int _n, int _maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int b : _banned) {
            set.add(b);
        }
        int maxCnt = 0;
        int sum = 0;
        for (int i = 1; i <= _n; i++) {
            if (!set.contains(i)) {
                if (sum + i > _maxSum) {
                    return maxCnt;
                } else {
                    sum += i;
                    maxCnt++;
                }
            }
        }
        return maxCnt;
    }

}
