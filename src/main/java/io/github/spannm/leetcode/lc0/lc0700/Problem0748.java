package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0748 extends LeetcodeProblem {

    String shortestCompletingWord(String _licensePlate, String[] _words) {
        int[] counts = new int[26];
        for (char c : _licensePlate.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                counts[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = "";
        for (String word : _words) {
            if (isComplete(word, counts)) {
                if (result.isEmpty()) {
                    result = word;
                } else if (word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    private static boolean isComplete(String _word, int[] _counts) {
        int[] tmp = _counts.clone();
        for (char c : _word.toCharArray()) {
            if (tmp[c - 'a'] > 0) {
                tmp[c - 'a']--;
            }
        }
        for (int i : tmp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
