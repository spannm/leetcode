package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0925 extends LeetcodeProblem {

    boolean isLongPressedName(String _name, String _typed) {
        int i = 0;
        for (int j = 0; i < _name.length() && j < _typed.length(); i++) {
            if (_name.charAt(i) != _typed.charAt(j)) {
                return false;
            } else if (i < _name.length() - 1 && _name.charAt(i) != _name.charAt(i + 1)) {
                j++;
                while (j < _typed.length() && _name.charAt(i) == _typed.charAt(j)) {
                    j++;
                }
            } else {
                j++;
            }

        }
        return i == _name.length();
    }

}
