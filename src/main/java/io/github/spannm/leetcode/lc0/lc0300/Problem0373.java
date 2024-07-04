package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">373. Find K Pairs with Smallest Sums</a>.
 */
class Problem0373 extends LeetcodeProblem {

    static List<List<Integer>> kSmallestPairs(final int[] _nums1, final int[] _nums2, int _k) {

        final int len1 = _nums1.length;
        final int len2 = _nums2.length;
        final Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.sum));

        for (int i = 0; i < len1; i++) {
            q.offer(new Node(_nums1[i] + _nums2[0], i, 0));
        }

        final List<List<Integer>> result = new ArrayList<>();

        while (_k > 0 && !q.isEmpty()) {
            Node val = q.poll();
            List<Integer> list = new ArrayList<>();
            list.add(_nums1[val.i]);
            list.add(_nums2[val.j]);
            result.add(list);
            if (val.j < len2 - 1) {
                q.offer(new Node(_nums1[val.i] + _nums2[val.j + 1], val.i, val.j + 1));
            }
            _k -= 1;
        }

        return result;
    }

    static class Node {
        private final int sum;
        private final int i;
        private final int j;

        Node(int _sum, int _i, int _j) {
            sum = _sum;
            i = _i;
            j = _j;
        }
    }

}
