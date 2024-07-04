package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0676 extends LeetcodeProblem {

    static class MagicDictionary {

        private final Set<String> wordSet = new HashSet<>();

        void buildDict(String[] _dict) {
            wordSet.addAll(List.of(_dict));
        }

        boolean search(String _word) {
            for (String candidate : wordSet) {
                if (modifyOneChar(_word, candidate)) {
                    return true;
                }
            }
            return false;
        }

        static boolean modifyOneChar(String _word, String _candidate) {
            if (_word.length() != _candidate.length()) {
                return false;
            }
            int diff = 0;
            for (int i = 0; i < _word.length(); i++) {
                if (_word.charAt(i) != _candidate.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return diff == 1;
        }
    }

}
