package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem1833 extends LeetcodeProblem {

    int maxIceCream(int[] _costs, int _coins) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int cost : _costs) {
            map.put(cost, map.getOrDefault(cost, 0) + 1);
        }
        int maxIceCream = 0;
        for (int cost : map.keySet()) {
            if (cost * map.get(cost) <= _coins) {
                maxIceCream += map.get(cost);
                _coins -= cost * map.get(cost);
            } else {
                while (_coins > 0 && _coins - cost >= 0) {
                    _coins -= cost;
                    maxIceCream++;
                }
                break;
            }
        }
        return maxIceCream;
    }

}
