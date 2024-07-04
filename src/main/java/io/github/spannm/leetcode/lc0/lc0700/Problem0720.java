package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0720 extends LeetcodeProblem {

    String longestWord(String[] _words) {
        TrieNode root = buildTrie(_words);
        return findLongestWord(root, _words);
    }

    private String findLongestWord(TrieNode _root, String[] _words) {
        String longestWord = "";
        for (String word : _words) {
            if (longestWord.length() > word.length() || longestWord.length() == word.length() && longestWord.compareToIgnoreCase(word) < 0) {
                continue;
            }
            TrieNode tmp = _root;
            boolean validWord = true;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] != null) {
                    tmp = tmp.children[c - 'a'];
                    if (!tmp.isWord) {
                        validWord = false;
                        break;
                    }
                }
            }
            if (validWord) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private TrieNode buildTrie(String[] _words) {
        TrieNode root = new TrieNode(' ');
        for (String word : _words) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode(c);
                }
                tmp = tmp.children[c - 'a'];
            }
            tmp.isWord = true;
        }
        return root;
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class TrieNode {
        final char       val;
        boolean          isWord;
        final TrieNode[] children;

        TrieNode(char _val) {
            val = _val;
            isWord = false;
            children = new TrieNode[26];
        }
    }

}
