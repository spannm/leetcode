package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0804 extends LeetcodeProblem {

    int uniqueMorseRepresentations(String[] _words) {
        String[] morseCodes = new String[] {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        Set<String> concatenation = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : _words) {
            sb.setLength(0);
            for (char c : word.toCharArray()) {
                sb.append(morseCodes[c - 'a']);
            }
            concatenation.add(sb.toString());
        }
        return concatenation.size();
    }

}
