package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Problem1657 extends LeetcodeProblem {

    boolean closeStrings(String _word1, String _word2) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : _word1.toCharArray()) {
            counts1[c - 'a']++;
            set1.add(c);
        }
        Arrays.sort(counts1);
        for (char c : _word2.toCharArray()) {
            counts2[c - 'a']++;
            set2.add(c);
        }
        Arrays.sort(counts2);
        return set1.equals(set2) && Arrays.equals(counts1, counts2);
    }

}
