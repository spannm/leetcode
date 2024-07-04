package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1944. Number of Visible People in a Queue.
 */
class Problem1944 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    int[] canSeePersonsCount(int[] _heights) {
        int nbHeights = _heights.length;
        int[] ans = new int[nbHeights];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = nbHeights - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() < _heights[i]) {
                stk.pop();
                ans[i]++;
            }
            if (!stk.isEmpty()) {
                ans[i]++;
            }
            stk.push(_heights[i]);
        }
        return ans;
    }

}
