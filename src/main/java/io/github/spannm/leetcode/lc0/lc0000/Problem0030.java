package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/"> 30. Substring with Concatenation
 * of All Words</a>.
 */
class Problem0030 extends LeetcodeProblem {

    List<Integer> findSubstring(String _s, String[] _words) {
        if (_words[0].length() * _words.length > _s.length()) {
            return List.of();
        }

        Map<String, Integer> wordFrqu = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // map store the frequency of every word in words[]
        for (String str : _words) {
            wordFrqu.put(str, wordFrqu.getOrDefault(str, 0) + 1);
        }

        int wordlen = _words[0].length();

        String[] str = new String[_s.length()];

        for (int i = 0; i < wordlen; i++) {
            Map<String, Integer> frq = new HashMap<>(); // count frequency of words inside the window

            int begin = i;
            int size = 0; // size is the no. of window and begin is the starting index of window

            // s.length()-wordlen -> based on observation

            for (int j = i; j <= _s.length() - wordlen; j += wordlen) {
                str[j] = _s.substring(j, j + wordlen); // window
                if (wordFrqu.containsKey(str[j])) {
                    begin = begin == -1 ? j : begin; // begin=-1 means new window need to be started
                    frq.put(str[j], frq.getOrDefault(str[j], 0) + 1);
                    size++;

                    if (size == _words.length) { // substring may be possible
                        if (frq.equals(wordFrqu)) {
                            ans.add(begin);
                        }

                        // sliding the window

                        frq.put(str[begin], frq.get(str[begin]) - 1);
                        begin += wordlen; // new starting index
                        size--;
                    }
                } else { // reset window
                    begin = -1;
                    size = 0;
                    frq.clear();
                }
            }
        }
        return ans;
    }

}
