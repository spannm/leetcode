package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">2785. Sort Vowels in a String</a>.
 */
class Problem2785 extends LeetcodeProblem {

    String sortVowels(String _s) {
        if (_s == null) {
            return null;
        }
        int len = _s.length();
        if (len <= 1) {
            return _s;
        }

        List<Character> vowels = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        char[] chars = _s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels.add(c);
                indices.add(i);
            }
        }

        Collections.sort(vowels);

        for (int i = 0; i < indices.size(); i++) {
            chars[indices.get(i)] = vowels.get(i);
        }

        return new String(chars);
    }

}
