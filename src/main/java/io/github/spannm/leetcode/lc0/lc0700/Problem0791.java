package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0791 extends LeetcodeProblem {

    String customSortString(String _order, String _s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : _s.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : ++v);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : _order.toCharArray()) {
            Integer count = map.remove(c);
            if (count != null) {
                String s = String.valueOf(c);
                sb.append(s.repeat(count));
            }
        }
        map.entrySet().forEach(e -> {
            int count = e.getValue();
            String s = String.valueOf(e.getKey());
            sb.append(s.repeat(count));
        });
        return sb.toString();
    }

}
