package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0533 extends LeetcodeProblem {

    int findBlackPixel(char[][] _picture, int _n) {
        if (_picture == null || _picture.length == 0 || _picture[0].length == 0) {
            return 0;
        }
        int n = _picture[0].length;
        int[] cols = new int[n];
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char[] chars : _picture) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (chars[j] == 'B') {
                    count++;
                    cols[j]++;
                }
                sb.append(chars[j]);
            }
            if (count == _n) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
            sb.setLength(0);
        }

        int answer = 0;
        for (String key : map.keySet()) {
            if (map.get(key) != _n) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (key.charAt(i) == 'B' && cols[i] == _n) {
                    answer += _n;
                }
            }
        }
        return answer;
    }

}
