package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Problem0981 extends LeetcodeProblem {

    static class TimeMap {

        private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void set(String _key, String _value, int _timestamp) {
            Map<Integer, String> timestampMap = map.computeIfAbsent(_key, k -> new TreeMap<>());
            timestampMap.put(_timestamp, _value);
        }

        public String get(String _key, int _timestamp) {
            TreeMap<Integer, String> timestampMap = map.get(_key);
            Integer prevTimestamp = java.util.Optional.ofNullable(timestampMap).map(m -> m.floorKey(_timestamp)).orElse(null);
            return prevTimestamp == null ? "" : timestampMap.get(prevTimestamp);
        }

    }

}
