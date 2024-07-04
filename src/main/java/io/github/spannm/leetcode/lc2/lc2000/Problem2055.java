package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

class Problem2055 extends LeetcodeProblem {

    int[] platesBetweenCandles(String _s, int[][] _queries) {
        int[] ans = new int[_queries.length];
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int left = 0;
        int right = 0;
        while (left < _s.length() && _s.charAt(left) != '|') {
            left++;
        }
        tmap.put(left, 0);
        int count = 0;
        while (left < _s.length()) {
            if (_s.charAt(left) == '|') {
                right = left + 1;
                while (right < _s.length() && _s.charAt(right) != '|') {
                    count++;
                    right++;
                }
                if (right < _s.length()) {
                    tmap.put(right, count);
                }
                left = right;
            } else {
                left++;
            }
        }
        for (int i = 0; i < _queries.length; i++) {
            int l = _queries[i][0];
            int r = _queries[i][1];
            Integer start = tmap.ceilingKey(l);
            Integer end = tmap.floorKey(r);
            if (start == null || end == null || start >= end) {
                continue;
            }
            ans[i] = tmap.get(end) - tmap.get(start);
        }
        return ans;
    }

}
