package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Problem0648 extends LeetcodeProblem {

    String replaceWords(List<String> _dict, String _sentence) {
        return replaceWords(_sentence.split(" "), buildTrie(_dict));
    }

    static String replaceWords(String[] _tokens, TrieNode _trieDict) {
        return Arrays.stream(_tokens).map(s -> getShortestReplacement(s, _trieDict)).collect(Collectors.joining(" "));
    }

    static String getShortestReplacement(String _token, TrieNode _trieDict) {
        TrieNode temp = _trieDict;
        StringBuilder sb = new StringBuilder();
        for (char c : _token.toCharArray()) {
            sb.append(c);
            if (temp.getChild(c - 'a') != null) {
                if (temp.getChild(c - 'a').isWord()) {
                    return sb.toString();
                }
                temp = temp.getChild(c - 'a');
            } else {
                return _token;
            }
        }
        return _token;
    }

    static TrieNode buildTrie(List<String> _dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : _dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.hasChild(c - 'a')) {
                    temp = temp.addChild(c - 'a', c);
                } else {
                    temp = temp.getChild(c - 'a');
                }
            }
            temp.setWord(true);
        }
        return root;
    }

    static class TrieNode {
        private final char       val;
        private final TrieNode[] children;
        private boolean          isWord;

        TrieNode(char _val) {
            val = _val;
            children = new TrieNode[26];
            isWord = false;
        }

        char getVal() {
            return val;
        }

        boolean hasChild(int _i) {
            return null != children[_i];
        }

        TrieNode addChild(int _i, char _c) {
            children[_i] = new TrieNode(_c);
            return children[_i];
        }

        TrieNode getChild(int _i) {
            return children[_i];
        }

        boolean isWord() {
            return isWord;
        }

        void setWord(boolean _isWord) {
            isWord = _isWord;
        }
    }

}
