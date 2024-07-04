package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2766. Relocate Marbles.
 */
class Problem2766 extends LeetcodeProblem {

    List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> pos = new HashSet<>();
        for (int x : nums) {
            pos.add(x);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            pos.remove(moveFrom[i]);
            pos.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(pos);
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }

}
