package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0380 extends LeetcodeProblem {

    static class RandomizedSet {
        private final Map<Integer, Integer> map;
        private final List<Integer>         list;
        private final Random                random;

        RandomizedSet() {
            map = new HashMap<>();
            random = new Random();
            list = new ArrayList<>();
        }

        boolean insert(int _val) {
            if (map.containsKey(_val)) {
                return false;
            }
            map.put(_val, list.size());
            list.add(list.size(), _val);
            return true;
        }

        boolean remove(int _val) {
            Integer val = map.get(_val);
            if (val == null) {
                return false;
            } else {
                int removeIndex = val;
                if (removeIndex != list.size() - 1) {

                    int lastElement = list.get(list.size() - 1);
                    list.set(removeIndex, lastElement);
                    map.put(lastElement, removeIndex);
                }
                map.remove(_val);
                list.remove(list.size() - 1);
                return true;
            }
        }

        int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
