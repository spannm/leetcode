package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1805 extends LeetcodeProblem {

    int numDifferentIntegers(String _word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _word.length(); i++) {
            if (!Character.isDigit(_word.charAt(i))) {
                sb.append(" ");
            } else {
                sb.append(_word.charAt(i));
            }
        }
        String[] numbers = sb.toString().split("\\s+");
        Set<String> set = new HashSet<>();
        for (String num : numbers) {
            if (!num.isEmpty()) {
                set.add(num.replaceFirst("^0+(?!$)", ""));
            }
        }
        return set.size();
    }

}
