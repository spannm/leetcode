package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0588 extends LeetcodeProblem {

    static class FileSystem {

        private final TrieNode root = new TrieNode("");

        FileSystem() {
        }

        List<String> ls(String _path) {
            TrieNode node = dfs(_path);
            if (node.isFile) {
                return List.of(node.name);
            } else {
                List<String> files = new ArrayList<>(node.map.keySet());
                Collections.sort(files);
                return files;
            }
        }

        void mkdir(String _path) {
            dfs(_path);
        }

        void addContentToFile(String _filePath, String _content) {
            TrieNode node = dfs(_filePath);
            node.isFile = true;
            node.sb.append(_content);
        }

        String readContentFromFile(String _filePath) {
            return dfs(_filePath).sb.toString();
        }

        TrieNode dfs(String _path) {
            TrieNode node = root;
            for (String eachPath : _path.split("/")) {
                if (!eachPath.isEmpty()) {
                    node = node.map.computeIfAbsent(eachPath, k -> new TrieNode(eachPath));
                }
            }
            return node;
        }

        @SuppressWarnings("checkstyle:VisibilityModifierCheck")
        static class TrieNode {
            boolean                     isFile = false;
            final Map<String, TrieNode> map;
            final String                name;
            final StringBuilder         sb;

            TrieNode(String _name) {
                name = _name;
                map = new HashMap<>();
                sb = new StringBuilder();
            }
        }
    }

}
