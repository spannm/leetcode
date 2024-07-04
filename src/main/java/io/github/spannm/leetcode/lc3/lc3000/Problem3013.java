package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

/**
 * 3013. Divide an Array Into Subarrays With Minimum Cost II.
 */
class Problem3013 extends LeetcodeProblem {

    long minimumCost(int[] nums, int k, int dist) {
        long result = Long.MAX_VALUE;
        long sum = 0L;
        int len = nums.length;
        TreeSet<Integer> set1 = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        TreeSet<Integer> set2 = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        for (int i = 1; i < len; i++) {
            set1.add(i);
            sum += nums[i];
            if (set1.size() >= k) {
                int x = set1.pollLast();
                sum -= nums[x];
                set2.add(x);
            }
            if (i - dist > 0) {
                result = Math.min(result, sum);
                int temp = i - dist;
                if (set1.contains(temp)) {
                    set1.remove(temp);
                    sum -= nums[temp];
                    if (!set2.isEmpty()) {
                        int y = set2.pollFirst();
                        sum += nums[y];
                        set1.add(y);
                    }
                } else {
                    set2.remove(i - dist);
                }
            }
        }
        return result + nums[0];
    }

}
