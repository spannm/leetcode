package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

class Problem1773 extends LeetcodeProblem {

    int countMatches(List<List<String>> _items, String _ruleKey, String _ruleValue) {
        int match = 0;
        for (List<String> item : _items) {
            if ("type".equals(_ruleKey) && item.get(0).equals(_ruleValue)) {
                match++;
            } else if ("color".equals(_ruleKey) && item.get(1).equals(_ruleValue)) {
                match++;
            } else if ("name".equals(_ruleKey) && item.get(2).equals(_ruleValue)) {
                match++;
            }
        }
        return match;
    }

}
