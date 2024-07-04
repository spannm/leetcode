package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>.
 */
class Problem0049 extends LeetcodeProblem {

    List<List<String>> groupAnagrams(String[] _strs) {
        Map<List<String>, List<String>> grouped = new LinkedHashMap<>();
        for (String s : _strs) {
            List<String> chars = Arrays.stream(s.split("")).sorted().toList();
            grouped.computeIfAbsent(chars, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> result = grouped.values().stream().toList();

        _strs = null;
        grouped = null;
        System.gc();

        return result;
    }

}
