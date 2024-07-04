package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem2273 extends LeetcodeProblem {

    List<String> removeAnagrams(String[] _words) {
        List<String> result = new ArrayList<>();
        result.add(_words[0]);
        for (int i = 1; i < _words.length; i++) {
            String sorted0 = sortWord(_words[i - 1]);
            String sorted1 = sortWord(_words[i]);
            if (!sorted0.equals(sorted1)) {
                result.add(_words[i]);
            }
        }
        return result;
    }

    private static String sortWord(String _words) {
        char[] chars = _words.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
