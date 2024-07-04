package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1694 extends LeetcodeProblem {

    String reformatNumber(String _number) {
        StringBuilder sb = new StringBuilder();
        for (char c : _number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String cleaned = sb.toString();
        sb.setLength(0);
        for (int i = 0; i < cleaned.length();) {
            if (i + 4 == cleaned.length()) {
                sb.append(cleaned, i, i + 2);
                sb.append("-");
                sb.append(cleaned.substring(i + 2));
                break;
            } else if (i + 3 <= cleaned.length()) {
                sb.append(cleaned, i, i + 3);
                sb.append("-");
                i += 3;
            } else {
                sb.append(cleaned.substring(i));
                break;
            }
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

}
