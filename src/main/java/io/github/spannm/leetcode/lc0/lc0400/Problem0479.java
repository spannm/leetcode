package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0479 extends LeetcodeProblem {

    int largestPalindrome(int _n) {
        if (_n == 1) {
            return 9;
        }

        int upperBound = (int) Math.pow(10, _n) - 1;
        int lowerBound = upperBound / 10;
        long maxNumber = upperBound * (long) upperBound;

        int firstHalf = (int) (maxNumber / (long) Math.pow(10, _n));

        boolean palindromFound = false;
        long palindrom = 0;

        while (!palindromFound) {

            palindrom = createPalindrom(firstHalf);

            for (long i = upperBound; i > lowerBound; i--) {

                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }

                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }
        return (int) (palindrom % 1337);
    }

    static long createPalindrom(long _num) {
        String str = _num + new StringBuilder().append(_num).reverse().toString();
        return Long.parseLong(str);
    }

}
