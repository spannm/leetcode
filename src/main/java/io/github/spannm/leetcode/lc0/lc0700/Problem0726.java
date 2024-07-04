package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/number-of-atoms/">726. Number of Atoms</a>.
 */
class Problem0726 extends LeetcodeProblem {

    String countOfAtoms(String _formula) {
        if (_formula == null || _formula.isBlank() || _formula.length() > 1000) {
            throw new IllegalArgumentException("Invalid formula: " + _formula);
        }
        String f = "(" + _formula + ")";

        // pattern to match a formula sequenced in parenthesis followed an optional multiplier
        java.util.regex.Pattern pattParens = java.util.regex.Pattern.compile("\\(([A-Za-z0-9]+)\\)([0-9]*)");

        // pattern to match the formula content found in parenthesis
        java.util.regex.Pattern pattContent1 = java.util.regex.Pattern.compile("([A-Z][a-z]*)([0-9]*)");

        final Map<String, Integer> results = new TreeMap<>();

        // resolve formulas inside out (resolve innermost formula first)
        java.util.regex.Matcher matcherParens = pattParens.matcher(f);
        while (matcherParens.find()) {

            String matched = matcherParens.group();
            String content = matcherParens.group(1);
            java.util.regex.Matcher matcherContent = pattContent1.matcher(content);
            while (matcherContent.find()) {
                String elem = matcherContent.group(1);
                String count = matcherContent.group(2);
                results.merge(elem,
                    count.isBlank() ? 1 : Integer.parseInt(count),
                    Integer::sum);
            }
            int multiplier = matcherParens.group(2).isBlank() ? 1 : Integer.parseInt(matcherParens.group(2));
            if (multiplier > 1) {
                results.replaceAll((k, v) -> v * multiplier);
            }
            int idx = f.indexOf(matched);
            f = new StringBuilder(f)
                .delete(idx, idx + matched.length())
                .insert(idx, results.entrySet().stream().map(e -> e.getKey() + (e.getValue() <= 1 ? "" : e.getValue())).collect(Collectors.joining())).toString();
            results.clear();

            // reset the matcher
            matcherParens = pattParens.matcher(f);
        }
        return f;
    }

}
