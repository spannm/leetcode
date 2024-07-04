package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem1297 extends LeetcodeProblem {

    int maxFreq(String _s, int _maxLetters, int _minSize, int _maxSize) {
        int maxFreq = 0;
        for (int size = _minSize; size <= _maxSize; size++) {
            maxFreq = Math.max(maxFreq, getMaxFreqWithThisSize(_s, _maxLetters, size));
        }
        return maxFreq;
    }

    private int getMaxFreqWithThisSize(String _str, int _maxLetters, int _size) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= _str.length() - _size; i++) {
            String substring = _str.substring(i, i + _size);
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < substring.length(); j++) {
                set.add(substring.charAt(j));
                if (set.size() > _maxLetters) {
                    break;
                }
            }
            if (set.size() <= _maxLetters) {
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }
        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }

}
