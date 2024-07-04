package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 826. Most Profit Assigning Work.
 */
class Problem0826 extends LeetcodeProblem {

    int maxProfitAssignment(int[] _difficulty, int[] _profit, int[] _worker) {
        int count = _difficulty.length;
        List<int[]> jobs = IntStream.range(0, count).mapToObj(i -> new int[] {_difficulty[i], _profit[i]}).sorted(Comparator.comparing(a -> a[0])).toList();
        Arrays.sort(_worker);
        int result = 0;
        int i = 0;
        int t = 0;
        for (int w : _worker) {
            while (i < count && jobs.get(i)[0] <= w) {
                t = Math.max(t, jobs.get(i++)[1]);
            }
            result += t;
        }
        return result;
    }

}
