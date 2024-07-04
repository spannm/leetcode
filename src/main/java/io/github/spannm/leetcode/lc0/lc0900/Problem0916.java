package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. Word Subsets.
 */
class Problem0916 extends LeetcodeProblem {

    List<String> wordSubsets(String[] _words1, String[] _words2) {
        int[] cnt = new int[26];
        for (var b : _words2) {
            int[] t = new int[26];
            for (int i = 0; i < b.length(); i++) {
                t[b.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnt[i] = Math.max(cnt[i], t[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (var a : _words1) {
            int[] t = new int[26];
            for (int i = 0; i < a.length(); i++) {
                t[a.charAt(i) - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > t[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(a);
            }
        }
        return ans;
    }

}
