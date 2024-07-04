package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0187 extends LeetcodeProblem {

    List<String> findRepeatedDnaSequences(String _s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < _s.length() - 9; i++) {
            String sequence = _s.substring(i, i + 10);
            map.compute(sequence, (k, v) -> v == null ? 1 : v + 1);
        }
        List<String> repeatedSequences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                repeatedSequences.add(entry.getKey());
            }
        }
        return repeatedSequences;
    }

}
