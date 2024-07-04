package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 768. Max Chunks To Make Sorted II.
 */
class Problem0768 extends LeetcodeProblem {

    int maxChunksToSorted(int[] _arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int v : _arr) {
            if (stk.isEmpty() || stk.peek() <= v) {
                stk.push(v);
            } else {
                int mx = stk.pop();
                while (!stk.isEmpty() && stk.peek() > v) {
                    stk.pop();
                }
                stk.push(mx);
            }
        }
        return stk.size();
    }

}
