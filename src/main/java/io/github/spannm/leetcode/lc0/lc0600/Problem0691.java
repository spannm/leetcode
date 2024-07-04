package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0691 extends LeetcodeProblem {

    int minStickers(String[] _stickers, String _target) {
        int m = _stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (char c : _stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        dp.put("", 0);
        return helper(dp, mp, _target);
    }

    static int helper(Map<String, Integer> _dp, int[][] _mp, String _target) {
        if (_dp.containsKey(_target)) {
            return _dp.get(_target);
        }
        int ans = Integer.MAX_VALUE;
        int[] tar = new int[26];
        for (char c : _target.toCharArray()) {
            tar[c - 'a']++;
        }

        for (int[] ints : _mp) {

            if (ints[_target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    sb.append(String.valueOf((char) ('a' + j)).repeat(Math.max(0, Math.max(0, tar[j] - ints[j]))));
                }
            }
            String s = sb.toString();
            int tmp = helper(_dp, _mp, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        _dp.put(_target, ans == Integer.MAX_VALUE ? -1 : ans);
        return _dp.get(_target);
    }

}
