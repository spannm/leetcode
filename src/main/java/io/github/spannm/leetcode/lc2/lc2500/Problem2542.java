package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/">2542. Maximum Subsequence Score</a>.
 */
class Problem2542 extends LeetcodeProblem {

    static long maxScore(final int[] _nums1, final int[] _nums2, final int _k) {
        final int len = _nums1.length;
        final int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i] = new int[] {_nums1[i], _nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        final Queue<Integer> topKHeap = new PriorityQueue<>();
        long topKSum = IntStream.range(0, _k).mapToLong(i -> {
            topKHeap.add(pairs[i][0]);
            return pairs[i][0];
        }).sum();

        long ans = topKSum * pairs[_k - 1][1];

        for (int i = _k; i < len; i++) {
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);

            ans = Math.max(ans, topKSum * pairs[i][1]);
        }

        return ans;
    }

}
