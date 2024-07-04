package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2053 extends LeetcodeProblem {

    String kthDistinct(String[] _arr, int _k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : _arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for (String s : _arr) {
            if (map.get(s) == 1) {
                count++;
                if (_k == count) {
                    return s;
                }
            }
        }
        return "";
    }

}
