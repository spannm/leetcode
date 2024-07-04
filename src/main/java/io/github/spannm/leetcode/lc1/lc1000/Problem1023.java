package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/camelcase-matching/">1023. Camelcase Matching</a>.
 */
class Problem1023 extends LeetcodeProblem {

    List<Boolean> camelMatch(String[] _queries, String _pattern) {
        String lcPatt = "[a-z]*";
        Pattern p = Pattern.compile(
            lcPatt + _pattern.chars().mapToObj(i -> (char) i + "").collect(Collectors.joining(lcPatt)) + lcPatt);

        return Arrays.stream(_queries).map(p::matcher).map(Matcher::matches).toList();
    }

}
