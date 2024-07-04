package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0555 extends LeetcodeProblem {

    String splitLoopedString(String[] _strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _strs.length; i++) {
            sb.setLength(0);
            String reverse = sb.append(_strs[i]).reverse().toString();
            if (_strs[i].compareTo(reverse) < 0) {
                _strs[i] = reverse;
            }
        }
        String result = "";
        for (int i = 0; i < _strs.length; i++) {
            sb.setLength(0);
            String reverse = sb.append(_strs[i]).reverse().toString();
            for (String str : new String[] {_strs[i], reverse}) {
                for (int k = 0; k < str.length(); k++) {
                    sb.setLength(0);
                    sb.append(str.substring(k));
                    for (int j = i + 1; j < _strs.length; j++) {
                        sb.append(_strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        sb.append(_strs[j]);
                    }
                    sb.append(str, 0, k);
                    if (sb.toString().compareTo(result) > 0) {
                        result = sb.toString();
                    }
                }
            }
        }
        return result;
    }

}
