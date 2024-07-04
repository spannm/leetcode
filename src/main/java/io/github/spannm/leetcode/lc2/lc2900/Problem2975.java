package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2975. Maximum Square Area by Removing Fences From a Field.
 */
class Problem2975 extends LeetcodeProblem {

    int maximizeSquareArea(int _m, int _n, int[] _hFences, int[] _vFences) {
        Set<Integer> hs = calc(_hFences, _m);
        hs.retainAll(calc(_vFences, _n));
        int ans = hs.stream().mapToInt(i -> i).max().orElse(-1);
        return ans > 0 ? (int) (1L * ans * ans % ((int) 1e9 + 7)) : -1;
    }

    static Set<Integer> calc(int[] _nums, int _k) {
        int len = _nums.length;
        _nums = Arrays.copyOf(_nums, len + 2);
        _nums[len] = 1;
        _nums[len + 1] = _k;
        Arrays.sort(_nums);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < _nums.length; i++) {
            for (int j = 0; j < i; j++) {
                s.add(_nums[i] - _nums[j]);
            }
        }
        return s;
    }

}
