package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-flowers-in-full-bloom/">2251. Number of Flowers in Full Bloom</a>.
 */
class Problem2251 extends LeetcodeProblem {

    int[] fullBloomFlowers(int[][] _flowers, int[] _people) {
        final int len = _flowers.length;
        int[] st = new int[len];
        int[] en = new int[len];

        for (int i = 0; i < len; i++) {
            st[i] = _flowers[i][0];
            en[i] = _flowers[i][1];
        }

        Arrays.sort(st);
        Arrays.sort(en);

        int i = 0;
        int[] answer = new int[_people.length];

        for (int p : _people) {
            answer[i] = binarySearch(st, p) - binarySearch(en, p - 1);
            i++;
        }
        return answer;
    }

    static int binarySearch(int[] _arr, int _t) {
        int l = 0;
        int r = _arr.length - 1;
        int ind = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (_arr[m] > _t) {
                r = m - 1;
            } else {
                ind = Math.max(ind, m);
                l = m + 1;
            }
        }
        return ind + 1;
    }

}
