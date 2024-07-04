package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1807 extends LeetcodeProblem {

    String evaluate(String _s, List<List<String>> _knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> know : _knowledge) {
            map.put(know.get(0), know.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == '(') {
                int start = i;
                while (i < _s.length() && _s.charAt(i) != ')') {
                    i++;
                }
                String key = _s.substring(start + 1, i);
                sb.append(map.getOrDefault(key, "?"));
            } else {
                sb.append(_s.charAt(i));
            }
        }
        return sb.toString();
    }

}
