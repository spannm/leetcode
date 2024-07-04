package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1736 extends LeetcodeProblem {

    String maximumTime(String _time) {
        StringBuilder sb = new StringBuilder();
        String[] strs = _time.split(":");
        String hour = strs[0];
        String min = strs[1];
        if (hour.charAt(0) == '?') {
            if (hour.charAt(1) == '?') {
                sb.append("23");
            } else if (hour.charAt(1) > '3') {
                sb.append("1");
                sb.append(hour.charAt(1));
            } else {
                sb.append("2");
                sb.append(hour.charAt(1));
            }
        } else if (hour.charAt(0) == '0' || hour.charAt(0) == '1') {
            if (hour.charAt(1) == '?') {
                sb.append(hour.charAt(0));
                sb.append("9");
            } else {
                sb.append(hour);
            }
        } else if (hour.charAt(0) == '2') {
            if (hour.charAt(1) == '?') {
                sb.append("23");
            } else {
                sb.append(hour);
            }
        }
        sb.append(":");
        if (min.charAt(0) == '?') {
            if (min.charAt(1) == '?') {
                sb.append("59");
            } else {
                sb.append("5");
                sb.append(min.charAt(1));
            }
            return sb.toString();
        }
        sb.append(min.charAt(0));
        if (min.charAt(1) == '?') {
            sb.append("9");
        } else {
            sb.append(min.charAt(1));
        }
        return sb.toString();
    }

}
