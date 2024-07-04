package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem2103 extends LeetcodeProblem {

    int countPoints(String _rings) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < _rings.length() - 1; i += 2) {
            char color = _rings.charAt(i);
            int pos = Character.getNumericValue(_rings.charAt(i + 1));
            Set<Integer> set = map.getOrDefault(pos, new HashSet<>());
            if (color == 'R') {
                set.add(1);
            } else if (color == 'G') {
                set.add(2);
            } else {
                set.add(3);
            }
            map.put(pos, set);
        }
        int ans = 0;
        for (int pos : map.keySet()) {
            if (map.get(pos).size() == 3) {
                ans++;
            }
        }
        return ans;
    }

}
