package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.List;

/**
 * 2895. Minimum Processing Time.
 */
class Problem2895 extends LeetcodeProblem {

    int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Comparator.comparingInt(a -> a));
        tasks.sort(Comparator.comparingInt(a -> a));
        int ans = 0;
        int i = tasks.size() - 1;
        for (int t : processorTime) {
            ans = Math.max(ans, t + tasks.get(i));
            i -= 4;
        }
        return ans;
    }

}
