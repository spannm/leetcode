package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Problem0500 extends LeetcodeProblem {

    String[] findWords(String[] _words) {
        final Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        final Set<Character> row2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        final Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');
        final List<Set<Character>> setList = List.of(row1, row2, row3);
        List<String> wordList = new ArrayList<>();
        for (String word : _words) {
            String lowerCaseWord = word.toLowerCase();
            boolean can = true;
            for (Set<Character> row : setList) {
                for (char c : lowerCaseWord.toCharArray()) {
                    if (!row.contains(c)) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    wordList.add(word);
                    break;
                }
                can = true;
            }
        }
        String[] result = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            result[i] = wordList.get(i);
        }
        return result;
    }

}
