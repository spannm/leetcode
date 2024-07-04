package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0383 extends LeetcodeProblem {

    boolean canConstruct(String _ransomNote, String _magazine) {
        char[] mchars = _magazine.toCharArray();
        int[] mcnt = new int[256];
        for (char mchar : mchars) {
            mcnt[mchar - 'a']++;
        }

        char[] rchars = _ransomNote.toCharArray();
        for (char rchar : rchars) {
            if (mcnt[rchar - 'a'] <= 0) {
                return false;
            }
            mcnt[rchar - 'a']--;
        }
        return true;
    }

}
