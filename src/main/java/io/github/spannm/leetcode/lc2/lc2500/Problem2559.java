package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem2559 extends LeetcodeProblem {

    int[] vowelStrings(String[] _words, int[][] _queries) {
        int[] ans = new int[_queries.length];
        boolean[] vowels = new boolean[_words.length];
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int i = 0;
        for (String word : _words) {
            if (word.length() == 1) {
                if (set.contains(word.charAt(0))) {
                    vowels[i] = true;
                }
            } else if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                vowels[i] = true;
            }
            i++;
        }
        int[] preSums = new int[_words.length];
        preSums[0] = vowels[0] ? 1 : 0;
        for (int k = 1; k < _words.length; k++) {
            if (vowels[k]) {
                preSums[k] = preSums[k - 1] + 1;
            } else {
                preSums[k] = preSums[k - 1];
            }
        }
        i = 0;
        for (int[] query : _queries) {
            int start = query[0];
            int end = query[1];
            if (start == 0) {
                ans[i++] = preSums[end];
            } else {
                ans[i++] = preSums[end] - preSums[start - 1];
            }
        }
        return ans;
    }

}
