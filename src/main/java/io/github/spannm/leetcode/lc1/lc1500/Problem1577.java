package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1577 extends LeetcodeProblem {

    int numTriplets(int[] _nums1, int[] _nums2) {
        long result = 0;
        for (long num : _nums1) {
            result += twoProduct(num * num, _nums2);
        }
        for (long num : _nums2) {
            result += twoProduct(num * num, _nums1);
        }
        return (int) result;
    }

    private long twoProduct(long _product, int[] _nums) {
        Map<Long, Long> map = new HashMap<>();
        long count = 0;
        for (long num : _nums) {
            if (_product % num == 0) {
                count += map.getOrDefault(_product / num, 0L);
            }
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }
        return count;
    }

}
