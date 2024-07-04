package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2301. Match Substring After Replacement.
 */
class Problem2301 extends LeetcodeProblem {

    boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> d = new HashMap<>();
        for (var e : mappings) {
            d.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
        }
        int m = s.length();
        int n = sub.length();
        for (int i = 0; i < m - n + 1; i++) {
            boolean ok = true;
            for (int j = 0; j < n && ok; j++) {
                char a = s.charAt(i + j);
                char b = sub.charAt(j);
                if (a != b && !d.getOrDefault(b, Collections.emptySet()).contains(a)) {
                    ok = false;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

}
