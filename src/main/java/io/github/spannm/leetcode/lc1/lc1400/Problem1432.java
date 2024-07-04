package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1432 extends LeetcodeProblem {

    int maxDiff(int _num) {
        int smallest = getSmallest(_num);
        int biggest = getBiggest(_num);
        return biggest - smallest;
    }

    private int getBiggest(int _num) {
        int firstDigit = Integer.parseInt(Integer.toString(_num).substring(0, 1));
        if (firstDigit == 9) {
            String remainder = Integer.toString(_num).substring(1);
            int numberToChangeToNine = 0;
            for (char c : remainder.toCharArray()) {
                if (c != '9') {
                    numberToChangeToNine = Integer.parseInt("" + c);
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append('9');
            for (char c : remainder.toCharArray()) {
                if (Integer.parseInt(c + "") == numberToChangeToNine) {
                    sb.append("9");
                } else {
                    sb.append(c);
                }
            }
            return Integer.parseInt(sb.toString());
        } else {
            int numberToChangeToNine = firstDigit;
            StringBuilder sb = new StringBuilder();
            for (char c : Integer.toString(_num).toCharArray()) {
                if (Integer.parseInt("" + c) == numberToChangeToNine) {
                    sb.append("9");
                } else {
                    sb.append(c);
                }
            }
            return Integer.parseInt(sb.toString());
        }
    }

    private int getSmallest(int _num) {
        int firstDigit = Integer.parseInt(Integer.toString(_num).substring(0, 1));
        if (firstDigit == 1) {
            String remainder = Integer.toString(_num).substring(1);
            int numberToChangeToZero = 0;
            for (char c : remainder.toCharArray()) {
                if (c == '0' || c == '1') {
                    continue;
                } else {
                    numberToChangeToZero = Integer.parseInt("" + c);
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (char c : remainder.toCharArray()) {
                if (Integer.parseInt(c + "") == numberToChangeToZero) {
                    sb.append("0");
                } else {
                    sb.append(c);
                }
            }
            return Integer.parseInt(sb.toString());
        } else {
            int numberToChangeToOne = firstDigit;
            StringBuilder sb = new StringBuilder();
            for (char c : Integer.toString(_num).toCharArray()) {
                if (Integer.parseInt("" + c) == numberToChangeToOne) {
                    sb.append("1");
                } else {
                    sb.append(c);
                }
            }
            return Integer.parseInt(sb.toString());
        }
    }

}
