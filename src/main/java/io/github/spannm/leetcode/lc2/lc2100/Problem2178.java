package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2178. Maximum Split of Positive Even Integers.
 */
class Problem2178 extends LeetcodeProblem {

    List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return ans;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.add(ans.remove(ans.size() - 1) + finalSum);
        return ans;
    }

}
