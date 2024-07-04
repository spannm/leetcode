package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Problem2034 extends LeetcodeProblem {
    static class StockPrice {
        private final TreeSet<Integer>      treeSet;
        private final Map<Integer, Integer> map;
        private final Map<Integer, Integer> countMap;
        private int                         current;

        StockPrice() {
            treeSet = new TreeSet<>();
            map = new HashMap<>();
            countMap = new HashMap<>();
            current = 0;
        }

        public void update(int _timestamp, int _price) {
            if (map.containsKey(_timestamp)) {
                int previousPrice = map.get(_timestamp);
                countMap.put(previousPrice, countMap.getOrDefault(previousPrice, 0) - 1);
                if (countMap.get(previousPrice) <= 0) {
                    countMap.remove(previousPrice);
                    treeSet.remove(previousPrice);
                }
            }
            map.put(_timestamp, _price);
            treeSet.add(_price);
            countMap.put(_price, countMap.getOrDefault(_price, 0) + 1);
            if (current < _timestamp) {
                current = _timestamp;
            }
        }

        public int current() {
            return map.get(current);
        }

        public int maximum() {
            return treeSet.last();
        }

        public int minimum() {
            return treeSet.first();
        }
    }

}
