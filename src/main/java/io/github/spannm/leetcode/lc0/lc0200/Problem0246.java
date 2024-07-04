package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0246 extends LeetcodeProblem {

    boolean isStrobogrammatic(String _num) {
        int i = 0;
        int j = _num.length() - 1;
        Map<Character, Character> map = new HashMap<>();
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        if (j == 0) {
            return map.containsKey(_num.charAt(i));
        }

        map.put('9', '6');
        map.put('6', '9');
        while (i < j) {
            if (!map.containsKey(_num.charAt(i)) || !map.containsKey(_num.charAt(j)) || map.get(_num.charAt(i)) != _num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return map.containsKey(_num.charAt(i));
    }

}
