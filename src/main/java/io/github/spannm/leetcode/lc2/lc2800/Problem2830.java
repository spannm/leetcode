package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.List;

/**
 * 2830. Maximize the Profit as the Salesman.
 */
class Problem2830 extends LeetcodeProblem {

    int maximizeTheProfit(int _n, List<List<Integer>> _offers) {
        _offers.sort(Comparator.comparingInt(a -> a.get(1)));
        int nbOffers = _offers.size();
        int[] f = new int[nbOffers + 1];
        int[] g = new int[nbOffers];
        for (int i = 0; i < nbOffers; i++) {
            g[i] = _offers.get(i).get(1);
        }
        for (int i = 1; i <= nbOffers; i++) {
            List<Integer> o = _offers.get(i - 1);
            int j = search(g, o.get(0));
            f[i] = Math.max(f[i - 1], f[j] + o.get(2));
        }
        return f[nbOffers];
    }

    static int search(int[] _nums, int _x) {
        int l = 0;
        int r = _nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (_nums[mid] >= _x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
