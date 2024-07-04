package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">1160. Find Words That Can Be
 * Formed by Characters</a>.
 */
class Problem1160 extends LeetcodeProblem {

    int countCharacters(String[] _words, String _chars) {
        Map<Character, Integer> charCounts = java.nio.CharBuffer.wrap(_chars.toCharArray()).chars()
            .mapToObj(c -> (char) c).collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1)));

        return Arrays.stream(_words).mapToInt(w -> count(w, charCounts)).sum();
    }

    static int count(String _word, final Map<Character, Integer> _charCounts) {
        Map<Character, Integer> charCounts = new HashMap<>(_charCounts);
        for (Character c : _word.toCharArray()) {
            int charCount = Objects.requireNonNullElse(charCounts.get(c), 0);
            if (charCount == 0) {
                return 0;
            }
            charCounts.put(c, charCount - 1);
        }
        return _word.length();
    }

}
