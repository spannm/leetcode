package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0888 extends LeetcodeProblem {

    int[] fairCandySwap(int[] _a, int[] _b) {
        int aSum = 0;
        int bSum = 0;
        int diff = 0;
        int[] ans = new int[2];
        for (int bar : _a) {
            aSum += bar;
        }
        for (int bar : _b) {
            bSum += bar;
        }
        diff = aSum - bSum;
        Set<Integer> set = new HashSet<>();
        for (int bar : _a) {
            set.add(bar);
        }
        for (int bar : _b) {
            if (set.contains(bar + diff / 2)) {
                ans[0] = bar + diff / 2;
                ans[1] = bar;
                break;
            }
        }
        return ans;
    }

}
