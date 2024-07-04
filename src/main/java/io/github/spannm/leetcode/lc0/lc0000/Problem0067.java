package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/add-binary/">67. Add Binary</a>.
 */
class Problem0067 extends LeetcodeProblem {

    static final char ZERO = '0';
    static final char ONE  = '1';

    String addBinary(String _a, String _b) {
        return addBinaryJdk(_a, _b);
    }

    String addBinaryJdk(String _a, String _b) {
        java.math.BigInteger value1 = new java.math.BigInteger(_a, 2);
        java.math.BigInteger value2 = new java.math.BigInteger(_b, 2);
        return value1.add(value2).toString(2);
    }

    String addBinaryStringAdd(String _a, String _b) {
        int lenA = _a.length();
        int lenB = _b.length();
        int lenMin = Math.min(lenA, lenB);

        StringBuilder sbA = new StringBuilder(_a).reverse();
        StringBuilder sbB = new StringBuilder(_b).reverse();
        StringBuilder sbSum = new StringBuilder();

        char carry = ZERO;
        int i = 0;

        for (i = 0; i < lenMin; i++) {
            if (sbA.charAt(i) == ONE && sbB.charAt(i) == ONE) {
                if (carry == ONE) {
                    sbSum.append(ONE);
                } else {
                    sbSum.append(ZERO);
                }
                carry = ONE;
            } else if (sbA.charAt(i) == ONE || sbB.charAt(i) == ONE) {
                if (carry == ONE) {
                    sbSum.append(ZERO);
                    carry = ONE;
                } else {
                    sbSum.append(ONE);
                    carry = ZERO;
                }
            } else {
                if (carry == ONE) {
                    sbSum.append(ONE);
                } else {
                    sbSum.append(ZERO);
                }
                carry = ZERO;
            }
        }

        if (lenA != lenB) {
            StringBuilder sbRemainder = lenA > lenB ? sbA : sbB;
            for (; i < sbRemainder.length(); i++) {
                if (sbRemainder.charAt(i) == ONE) {
                    if (carry == ONE) {
                        sbSum.append(ZERO);
                        carry = ONE;
                    } else {
                        sbSum.append(ONE);
                        carry = ZERO;
                    }
                } else if (sbRemainder.charAt(i) == ZERO) {
                    if (carry == ONE) {
                        sbSum.append(ONE);
                        carry = ZERO;
                    } else {
                        sbSum.append(ZERO);
                    }
                }
            }
        }
        if (carry == ONE) {
            sbSum.append(ONE);
        }
        return sbSum.reverse().toString();
    }

    static java.math.BigInteger binToDec(String _str) {
        java.math.BigInteger dec = java.math.BigInteger.ZERO;
        long pow = 1L;
        for (int i = _str.length() - 1; i >= 0; i--) {
            char c = _str.charAt(i);
            dec = dec.add(java.math.BigInteger.valueOf(Long.parseLong(c + "") * pow));
            pow *= 2;
        }
        return dec;
    }

}
