package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/regular-expression-matching/">10. Regular Expression Matching</a>.
 */
class Problem0010 extends LeetcodeProblem {

    boolean isMatch(String _str, String _pattern) {
        return isMatch(_str, 0, _pattern, 0);
    }

    boolean isMatch(String _str, int _idxStr, String _pattern, int _idxPattern) {
        final int lenStr = _str.length();
        final int lenPattern = _pattern.length();
        if (_idxPattern == lenPattern) { // since * in p can match 0 of previous char, so empty string(i==sn) may match
                                         // p
            return _idxStr == lenStr;
        }
        char charPattern = _pattern.charAt(_idxPattern);
        if (_idxPattern + 1 < lenPattern && _pattern.charAt(_idxPattern + 1) == '*') { // match *, needs to look at the
                                                                                       // next char to repeate current
                                                                                       // char
            if (isMatch(_str, _idxStr, _pattern, _idxPattern + 2)) {
                return true;
            }
            while (_idxStr < lenStr && (charPattern == '.' || charPattern == _str.charAt(_idxStr))) {
                if (isMatch(_str, ++_idxStr, _pattern, _idxPattern + 2)) {
                    return true;
                }
            }
        } else if (_idxStr < lenStr && (_str.charAt(_idxStr) == charPattern // match char
            || charPattern == '.')) { // match dot
            return isMatch(_str, _idxStr + 1, _pattern, _idxPattern + 1);
        }
        return false;
    }

}
