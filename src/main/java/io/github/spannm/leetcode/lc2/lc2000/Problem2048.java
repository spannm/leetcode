package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2048 extends LeetcodeProblem {

    int nextBeautifulNumber(int _n) {
        int ans = _n;
        do {
            ans++;
            if (isNumeric(ans)) {
                return ans;
            }
        } while (true);
    }

    private static boolean isNumeric(int _number) {
        Map<Integer, Integer> map = new HashMap<>();
        while (_number != 0) {
            int digit = _number % 10;
            map.put(digit, map.getOrDefault(digit, 0) + 1);
            _number /= 10;
        }
        for (int key : map.keySet()) {
            if (key != map.get(key) || key == 0 && map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

}
