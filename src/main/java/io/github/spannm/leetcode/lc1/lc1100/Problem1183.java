package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1183. Maximum Number of Ones.
 */
class Problem1183 extends LeetcodeProblem {

    int maximumNumberOfOnes(int _width, int _height, int _sideLength, int _maxOnes) {
        int x = _sideLength;
        int[] cnt = new int[x * x];
        for (int i = 0; i < _width; i++) {
            for (int j = 0; j < _height; j++) {
                int k = i % x * x + j % x;
                cnt[k]++;
            }
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < _maxOnes; i++) {
            ans += cnt[cnt.length - i - 1];
        }
        return ans;
    }

}
