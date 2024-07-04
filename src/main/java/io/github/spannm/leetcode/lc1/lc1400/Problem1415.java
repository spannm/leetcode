package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * <p>
 * A happy string is a string that: consists only of letters of the set ['a', 'b', 'c']. s[i] != s[i + 1] for all values
 * of i from 1 to s.length - 1 (string is 1-indexed).
 * <p>
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are
 * not happy strings. Given two integers n and k, consider a list of all happy strings of length n sorted in
 * lexicographical order. Return the kth string of this list or return an empty string if there are less than k happy
 * strings of length n.
 * <p>
 * Example 1: Input: n = 1, k = 3 Output: "c" Explanation: The list ["a", "b", "c"] contains all happy strings of length
 * 1. The third string is "c".
 * <p>
 * Example 2: Input: n = 1, k = 4 Output: "" Explanation: There are only 3 happy strings of length 1.
 * <p>
 * Example 3: Input: n = 3, k = 9 Output: "cab" Explanation: There are 12 different happy string of length 3 ["aba",
 * "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 * <p>
 * Example 4: Input: n = 2, k = 7 Output: ""
 * <p>
 * Example 5: Input: n = 10, k = 100 Output: "abacbabacb"
 * <p>
 * Constraints: 1 <= n <= 10 1 <= k <= 100
 */
class Problem1415 extends LeetcodeProblem {

    String getHappyString(int _n, int _k) {
        char[] chars = new char[] {'a', 'b', 'c'};
        List<String> happyStrings = new ArrayList<>();
        happyStrings.add("");
        happyStrings = findAllHappyStrings(chars, _n, happyStrings);
        return happyStrings.size() < _k ? "" : happyStrings.get(_k - 1);
    }

    private List<String> findAllHappyStrings(char[] _chars, int _n, List<String> _happyStrings) {
        if (_happyStrings.get(0).length() == _n) {
            return _happyStrings;
        }
        List<String> newHappyStrings = new ArrayList<>();
        for (String str : _happyStrings) {
            for (char c : _chars) {
                if (str.isEmpty() || str.charAt(str.length() - 1) != c) {
                    newHappyStrings.add(str + c);
                }
            }
        }
        _happyStrings = newHappyStrings;
        return findAllHappyStrings(_chars, _n, _happyStrings);
    }

}
