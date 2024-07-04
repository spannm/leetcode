package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0616 extends LeetcodeProblem {

    String addBoldTag(String _s, String[] _dict) {
        boolean[] shouldBold = new boolean[_s.length()];
        for (int i = 0, end = 0; i < _s.length(); i++) {
            for (String word : _dict) {
                if (_s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            shouldBold[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i++) {
            if (!shouldBold[i]) {
                sb.append(_s.charAt(i));
                continue;
            }
            int j = i;
            while (j < _s.length() && shouldBold[j]) {
                j++;
            }
            sb.append("<b>")
                .append(_s, i, j)
                .append("</b>");
            i = j - 1;
        }
        return sb.toString();
    }

}
