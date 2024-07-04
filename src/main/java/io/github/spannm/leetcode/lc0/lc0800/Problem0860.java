package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0860 extends LeetcodeProblem {

    boolean lemonadeChange(int[] _bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : _bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (!map.containsKey(5)) {
                    return false;
                } else {
                    map.put(5, map.get(5) - 1);
                    if (map.get(5) == 0) {
                        map.remove(5);
                    }
                    map.put(10, map.getOrDefault(10, 0) + 1);
                }
            } else {
                if (!map.containsKey(5)) {
                    return false;
                } else {
                    if (!map.containsKey(10)) {
                        if (!map.containsKey(5) || map.get(5) < 3) {
                            return false;
                        } else {
                            map.put(5, map.get(5) - 3);
                            if (map.get(5) == 0) {
                                map.remove(5);
                            }
                        }
                    } else {
                        if (!map.containsKey(5)) {
                            return false;
                        } else {
                            map.put(5, map.get(5) - 1);
                            if (map.get(5) == 0) {
                                map.remove(5);
                            }
                            map.put(10, map.get(10) - 1);
                            if (map.get(10) == 0) {
                                map.remove(10);
                            }
                        }
                    }
                }
                map.put(20, map.getOrDefault(20, 0) + 1);
            }
        }
        return true;
    }

}
