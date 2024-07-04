package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0677 extends LeetcodeProblem {

    static class MapSum {

        private final Map<String, Integer> map = new HashMap<>();

        void insert(String _key, int _val) {
            map.put(_key, _val);
        }

        int sum(String _prefix) {
            return map.entrySet().stream().filter(e -> e.getKey().startsWith(_prefix)).map(Map.Entry::getValue).mapToInt(i -> i).sum();
        }
    }

}
