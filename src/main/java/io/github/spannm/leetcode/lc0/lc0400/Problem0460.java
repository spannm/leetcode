package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Problem0460 extends LeetcodeProblem {

    static class LFUCache {

        private final Map<Integer, Integer>      keyToValue;
        private final Map<Integer, Integer>      keyToCount;
        private final Map<Integer, Set<Integer>> countToLruKeys;
        private final int                        cap;
        private int                              minimumCount;

        LFUCache(int _capacity) {
            minimumCount = -1;
            cap = _capacity;
            keyToValue = new HashMap<>();
            keyToCount = new HashMap<>();
            countToLruKeys = new HashMap<>();
            countToLruKeys.put(1, new LinkedHashSet<>());
        }

        int get(int _key) {
            if (!keyToValue.containsKey(_key)) {
                return -1;
            }
            int count = keyToCount.get(_key);
            keyToCount.put(_key, count + 1);
            countToLruKeys.get(count).remove(_key);

            if (count == minimumCount && countToLruKeys.get(count).isEmpty()) {
                minimumCount++;
            }

            countToLruKeys.computeIfAbsent(count + 1, k -> new LinkedHashSet<>()).add(_key);

            return keyToValue.get(_key);
        }

        public void put(int _key, int _value) {
            if (cap <= 0) {
                return;
            }

            if (keyToValue.containsKey(_key)) {
                keyToValue.put(_key, _value);
                get(_key);
                return;
            }

            if (keyToValue.size() >= cap) {
                int evit = countToLruKeys.get(minimumCount).iterator().next();
                countToLruKeys.get(minimumCount).remove(evit);
                keyToValue.remove(evit);
            }
            keyToValue.put(_key, _value);
            keyToCount.put(_key, 1);
            countToLruKeys.get(1).add(_key);
            minimumCount = 1;
        }
    }

}
