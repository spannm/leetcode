package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem2070 extends LeetcodeProblem {

    int[] maximumBeauty(int[][] _items, int[] _queries) {
        int len = _queries.length;
        Arrays.sort(_items, Comparator.comparingInt(a -> a[0]));
        int[][] queryPairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            queryPairs[i] = new int[] {_queries[i], i};
        }
        Arrays.sort(queryPairs, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[len];
        int j = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int[] queryPair = queryPairs[i];
            int price = queryPair[0];
            int index = queryPair[1];
            while (j < _items.length && _items[j][0] <= price) {
                max = Math.max(max, _items[j][1]);
                j++;
            }
            ans[index] = max;
        }
        return ans;
    }

}
