package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">211. Design Add and Search Words
 * Data Structure</a>.
 */
class Problem0211 extends LeetcodeProblem {

    static class WordDictionary {
        private final TrieNode root;

        WordDictionary() {
            root = new TrieNode();
        }

        void addWord(String _word) {
            TrieNode node = root;
            for (int i = 0; i < _word.length(); i++) {
                final char c = _word.charAt(i);
                node.children.computeIfAbsent(c, x -> new TrieNode());
                node = node.children.get(c);
            }
            node.isCompleteWord = true;
        }

        boolean search(String _word) {
            return search(root, _word, 0);
        }

        static boolean search(TrieNode _node, String _word, int _index) {
            if (_index == _word.length()) {
                return _node.isCompleteWord;
            }
            char c = _word.charAt(_index);
            if (c == '.') {
                for (TrieNode child : _node.children.values()) {
                    if (search(child, _word, _index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode child = _node.children.get(c);
                return child != null && search(child, _word, _index + 1);
            }
        }

        @Override
        public String toString() {
            return String.format("%s[root=%s]", getClass().getSimpleName(), root);
        }

        static final class TrieNode {
            private boolean                        isCompleteWord;
            private final Map<Character, TrieNode> children;

            TrieNode() {
                isCompleteWord = false; // when the word is complete (mark that node as true)
                children = new LinkedHashMap<>();
            }

            @Override
            public String toString() {
                return String.format("%s[isCompleteWord=%s, children=%s]",
                    getClass().getSimpleName(), isCompleteWord, children.size());
            }

        }

    }

}
