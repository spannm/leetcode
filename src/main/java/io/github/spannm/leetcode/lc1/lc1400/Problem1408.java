package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1408. String Matching in an Array
 * <p>
 * Given an array of string words. Return all strings in words which is substring of another word in any order. String
 * words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 * <p>
 * Example 1: Input: words = ["mass","as","hero","superhero"] Output: ["as","hero"] Explanation: "as" is substring of
 * "mass" and "hero" is substring of "superhero". ["hero","as"] is also a valid answer.
 * <p>
 * Example 2: Input: words = ["leetcode","et","code"] Output: ["et","code"] Explanation: "et", "code" are substring of
 * "leetcode".
 * <p>
 * Example 3: Input: words = ["blue","green","bu"] Output: []
 * <p>
 * Constraints: 1 <= words.length <= 100 1 <= words[i].length <= 30 words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 */
class Problem1408 extends LeetcodeProblem {

    List<String> stringMatching(String[] _words) {
        Set<String> set = new HashSet<>();
        for (String word : _words) {
            for (String word2 : _words) {
                if (!word.equals(word2) && word.length() < word2.length()) {
                    if (word2.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
