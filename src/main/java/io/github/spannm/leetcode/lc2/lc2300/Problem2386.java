package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2386. Find the K-Sum of an Array.
 */
class Problem2386 extends LeetcodeProblem {

    long kSum(int[] nums, int k) {
        long mx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                mx += nums[i];
            } else {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        Queue<Pair<Long, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.offer(new Pair<>(0L, 0));
        while (--k > 0) {
            var p = pq.poll();
            long s = p.getKey();
            int i = p.getValue();
            if (i < n) {
                pq.offer(new Pair<>(s + nums[i], i + 1));
                if (i > 0) {
                    pq.offer(new Pair<>(s + nums[i] - nums[i - 1], i + 1));
                }
            }
        }
        return mx - pq.peek().getKey();
    }

    static class Pair<K, V> {
        private final K key;
        private final V val;

        Pair(K _key, V _val) {
            key = _key;
            val = _val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

}
