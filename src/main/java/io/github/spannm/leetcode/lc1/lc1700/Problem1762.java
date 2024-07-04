package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1762. Buildings With an Ocean View.
 */
class Problem1762 extends LeetcodeProblem {

    int[] findBuildings(int[] _heights) {
        List<Integer> ans = new ArrayList<>();
        int mx = 0;
        for (int i = _heights.length - 1; i >= 0; i--) {
            if (_heights[i] > mx) {
                ans.add(i);
                mx = _heights[i];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
