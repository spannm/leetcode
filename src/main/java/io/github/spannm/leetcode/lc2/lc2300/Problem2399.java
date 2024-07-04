package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2399 extends LeetcodeProblem {

    boolean checkDistances(String _s, int[] _distance) {
        Map<Character, int[]> map = new HashMap<>();
        int i = 0;
        for (char c : _s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, new int[] {-1, -1});
            }
            int[] indices = map.get(c);
            if (indices[0] == -1) {
                indices[0] = i;
            } else {
                indices[1] = i;
            }
            i++;
        }
        for (char c : map.keySet()) {
            int index = c - 'a';
            int[] indices = map.get(c);
            if (_distance[index] + 1 != indices[1] - indices[0]) {
                return false;
            }
        }
        return true;
    }

}
