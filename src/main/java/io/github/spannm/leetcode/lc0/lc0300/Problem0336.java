package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0336 extends LeetcodeProblem {

    List<List<Integer>> palindromePairs(String[] _words) {
        final int nbWords = _words.length;
        List<List<Integer>> pairs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nbWords; i++) {
            map.put(_words[i], i);
        }

        for (int i = 0; i < nbWords; i++) {
            int l = 0;
            int r = 0;
            while (l <= r) {
                String s = _words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && j != i && isPalindrome(_words[i].substring(l == 0 ? r : 0, l == 0 ? _words[i].length() : l))) {
                    pairs.add(List.of(l == 0 ? new Integer[] {i, j} : new Integer[] {j, i}));
                }
                if (r < _words[i].length()) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return pairs;
    }

    private static boolean isPalindrome(String _word) {
        int len = _word.length();
        for (int i = 0; i < len / 2; i++) {
            if (_word.charAt(i) != _word.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
