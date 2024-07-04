package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2062 extends LeetcodeProblem {

    int countVowelSubstrings(String _word) {
        int count = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < _word.length(); i++) {
            window.clear();
            if (vowels.contains(_word.charAt(i))) {
                window.add(_word.charAt(i));
                for (int j = i + 1; j < _word.length(); j++) {
                    if (!vowels.contains(_word.charAt(j))) {
                        break;
                    } else {
                        window.add(_word.charAt(j));
                        if (window.size() == 5) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
