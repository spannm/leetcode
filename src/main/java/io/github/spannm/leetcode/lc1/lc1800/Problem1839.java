package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1839. Longest Substring Of All Vowels in Order.
 */
class Problem1839 extends LeetcodeProblem {

    int longestBeautifulSubstring(String word) {
        int n = word.length();
        List<Node> arr = new ArrayList<>();
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            arr.add(new Node(word.charAt(i), j - i));
            i = j;
        }
        int ans = 0;
        for (int i = 0; i < arr.size() - 4; i++) {
            Node a = arr.get(i);
            Node b = arr.get(i + 1);
            Node c = arr.get(i + 2);
            Node d = arr.get(i + 3);
            Node e = arr.get(i + 4);
            if (a.c == 'a' && b.c == 'e' && c.c == 'i' && d.c == 'o' && e.c == 'u') {
                ans = Math.max(ans, a.v + b.v + c.v + d.v + e.v);
            }
        }
        return ans;
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        final char c;
        final int  v;

        Node(char _c, int _v) {
            c = _c;
            v = _v;
        }

    }

}
