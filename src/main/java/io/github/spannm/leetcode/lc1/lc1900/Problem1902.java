package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

/**
 * 1902. Depth of BST Given Insertion Order.
 */
class Problem1902 extends LeetcodeProblem {

    int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        tm.put(Integer.MAX_VALUE, 0);
        tm.put(order[0], 1);
        int ans = 1;
        for (int i = 1; i < order.length; i++) {
            int v = order[i];
            Map.Entry<Integer, Integer> lower = tm.lowerEntry(v);
            Map.Entry<Integer, Integer> higher = tm.higherEntry(v);
            int depth = 1 + Math.max(lower.getValue(), higher.getValue());
            ans = Math.max(ans, depth);
            tm.put(v, depth);
        }
        return ans;
    }

}
