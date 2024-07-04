package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1170 extends LeetcodeProblem {

    int[] numSmallerByFrequency(String[] _queries, String[] _words) {
        int[] queriesMinFrequecies = new int[_queries.length];
        for (int i = 0; i < _queries.length; i++) {
            queriesMinFrequecies[i] = computeLowestFrequency(_queries[i]);
        }

        int[] wordsMinFrequecies = new int[_words.length];
        for (int i = 0; i < _words.length; i++) {
            wordsMinFrequecies[i] = computeLowestFrequency(_words[i]);
        }
        Arrays.sort(wordsMinFrequecies);

        int[] result = new int[_queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = search(wordsMinFrequecies, queriesMinFrequecies[i]);
        }
        return result;
    }

    private int search(int[] _nums, int _target) {
        int count = 0;
        for (int i = _nums.length - 1; i >= 0; i--) {
            if (_nums[i] > _target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int computeLowestFrequency(String _string) {
        char[] str = _string.toCharArray();
        Arrays.sort(str);
        String sortedString = new String(str);
        int frequency = 1;
        for (int i = 1; i < sortedString.length(); i++) {
            if (sortedString.charAt(i) == sortedString.charAt(0)) {
                frequency++;
            } else {
                break;
            }
        }
        return frequency;
    }

}
