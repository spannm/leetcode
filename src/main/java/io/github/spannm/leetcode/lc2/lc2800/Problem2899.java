package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2899. Last Visited Integers.
 */
class Problem2899 extends LeetcodeProblem {

    List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (var w : words) {
            if ("prev".equals(w)) {
                k++;
                int i = nums.size() - k;
                ans.add(i < 0 ? -1 : nums.get(i));
            } else {
                k = 0;
                nums.add(Integer.valueOf(w));
            }
        }
        return ans;
    }

}
