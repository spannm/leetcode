package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0527 extends LeetcodeProblem {

    List<String> wordsAbbreviation(List<String> _dict) {
        int len = _dict.size();
        String[] ans = new String[len];
        int[] prefix = new int[len];
        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            ans[i] = abbreviate(_dict.get(i), 1);
        }
        for (int i = 0; i < len; i++) {
            while (true) {
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < len; j++) {
                    if (ans[j].equals(ans[i])) {
                        set.add(j);
                    }
                }
                if (set.isEmpty()) {
                    break;
                }
                set.add(i);
                for (int k : set) {
                    ans[k] = abbreviate(_dict.get(k), ++prefix[k]);
                }
            }
        }
        return List.of(ans);
    }

    static String abbreviate(String _word, int _k) {
        if (_k + 2 >= _word.length()) {
            return _word;
        }
        return _word.substring(0, _k)
            + (_word.length() - 1 - _k)
            + _word.substring(_word.length() - 1);
    }

}
