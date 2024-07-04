package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0809 extends LeetcodeProblem {

    int expressiveWords(String _s, String[] _words) {
        int ans = 0;
        for (String w : _words) {
            if (check(_s, w)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(String _s, String _word) {
        int i = 0;
        int j = 0;
        while (i < _s.length() && j < _word.length()) {
            char ch1 = _s.charAt(i);
            char ch2 = _word.charAt(j);

            int len1 = getLen(_s, i);
            int len2 = getLen(_word, j);
            if (ch1 == ch2) {
                if (len1 == len2) {
                    i = i + len1;
                    j = j + len2;
                } else if (len1 >= 3 && len2 < len1) {
                    i = i + len1;
                    j = j + len2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == _s.length() && j == _word.length();
    }

    private int getLen(String _value, int _i) {
        _i = _i + 1;
        int count = 1;
        for (int j = _i; j < _value.length(); j++) {
            if (_value.charAt(j) == _value.charAt(_i - 1)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
