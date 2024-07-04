package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1366 extends LeetcodeProblem {
    static class Node {
        private final int[] count = new int[26];
        private final char  c;

        Node(char _c) {
            c = _c;
        }
    }

    String rankTeams(String[] _votes) {
        Node[] nodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node((char) (i + 'A'));
        }
        for (String vote : _votes) {
            for (int i = 0; i < vote.length(); i++) {
                nodes[vote.charAt(i) - 'A'].count[i]++;
            }
        }
        Arrays.sort(nodes, (o1, o2) -> {
            for (int i = 0; i < 26; i++) {
                if (o1.count[i] != o2.count[i]) {
                    return o2.count[i] - o1.count[i];
                }
            }
            return o1.c - o2.c;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _votes[0].length(); i++) {
            sb.append(nodes[i].c);
        }
        return sb.toString();
    }

}
