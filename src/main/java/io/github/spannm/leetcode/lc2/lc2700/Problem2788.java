package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 2788. Split Strings by Separator.
 */
class Problem2788 extends LeetcodeProblem {

    List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            for (var s : w.split(Pattern.quote(String.valueOf(separator)))) {
                if (!s.isEmpty()) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }

}
