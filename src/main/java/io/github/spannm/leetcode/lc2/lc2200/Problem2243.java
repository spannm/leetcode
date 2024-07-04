package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2243 extends LeetcodeProblem {

    String digitSum(String _s, int _k) {
        StringBuilder sb = new StringBuilder();
        while (_s.length() > _k) {
            for (int i = 0; i < _s.length(); i += _k) {
                int sum = 0;
                for (int j = i; j < i + _k && j < _s.length(); j++) {
                    sum += Integer.parseInt(_s.charAt(j) + "");
                }
                sb.append(sum);
            }
            _s = sb.toString();
            sb.setLength(0);
        }
        return _s;
    }

}
