package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. Reformat The String
 * <p>
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed
 * by another digit. That is, no two adjacent characters have the same type. Return the reformatted string or return an
 * empty string if it is impossible to reformat the string.
 * <p>
 * Example 1: Input: s = "a0b1c2" Output: "0a1b2c" Explanation: No two adjacent characters have the same type in
 * "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * <p>
 * Example 2: Input: s = "leetcode" Output: "" Explanation: "leetcode" has only characters so we cannot separate them by
 * digits.
 * <p>
 * Example 3: Input: s = "1229857369" Output: "" Explanation: "1229857369" has only digits so we cannot separate them by
 * characters.
 * <p>
 * Example 4: Input: s = "covid2019" Output: "c2o0v1i9d"
 * <p>
 * Example 5: Input: s = "ab123" Output: "1a2b3"
 * <p>
 * Constraints: 1 <= s.length <= 500 s consists of only lowercase English letters and/or digits.
 */
class Problem1417 extends LeetcodeProblem {

    String reformat(String _s) {
        List<Character> characterList = new ArrayList<>();
        List<Character> numberList = new ArrayList<>();
        for (char c : _s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                characterList.add(c);
            } else {
                numberList.add(c);
            }
        }
        if (Math.abs(characterList.size() - numberList.size()) > 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (characterList.size() > numberList.size()) {
                for (int i = 0; i < characterList.size() - 1; i++) {
                    sb.append(characterList.get(i));
                    sb.append(numberList.get(i));
                }
                sb.append(characterList.get(characterList.size() - 1));
            } else if (characterList.size() == numberList.size()) {
                for (int i = 0; i < numberList.size(); i++) {
                    sb.append(numberList.get(i));
                    sb.append(characterList.get(i));
                }
            } else {
                for (int i = 0; i < numberList.size() - 1; i++) {
                    sb.append(numberList.get(i));
                    sb.append(characterList.get(i));
                }
                sb.append(numberList.get(numberList.size() - 1));
            }
            return sb.toString();
        }
    }

}
