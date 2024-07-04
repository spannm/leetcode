package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">1048. Longest String Chain</a>.
 */
class Problem1048 extends LeetcodeProblem {

    int longestStrChain(String[] _words) {
        // Sort the array in increasing order of word length
        List<String> words = Arrays.stream(_words).sorted(Comparator.comparingInt(String::length)).distinct().toList();

        // Create a map to store the longest chain ending at each word
        Map<String, Integer> dp = new LinkedHashMap<>();
        int maxChainLen = 1;

        // Iterate through each word in the array
        for (String word : words) {
            // Initialize the longest chain for the current word as 1
            int chainLen = 1;
            // Generate all possible predecessor words of the current word
            for (int i = 0; i < word.length(); i++) {
                String predecessor = new StringBuilder(word).deleteCharAt(i).toString();

                // If the predecessor word is in the map, update the longest chain for the current word
                Integer predLen = dp.get(predecessor);
                if (predLen != null) {
                    chainLen = Math.max(chainLen, 1 + predLen);
                }
            }
            // Update the map with the longest chain ending at the current word
            dp.put(word, chainLen);
            // Update the maximum chain length seen so far
            maxChainLen = Math.max(maxChainLen, chainLen);
        }

        words = null;
        dp = null;

        return maxChainLen;
    }

}
