package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2086 extends LeetcodeProblem {

    int minimumBuckets(String _street) {
        int minBuckets = 0;
        int[] buckets = new int[_street.length()];
        for (int i = 0; i < _street.length(); i++) {
            if (_street.charAt(i) == 'H') {
                if (i + 1 < _street.length() && _street.charAt(i + 1) == '.') {
                    if (i - 1 >= 0 && buckets[i - 1] == 1) {
                        continue;
                    }
                    buckets[i + 1] = 1;
                    minBuckets++;
                } else if (i + 1 < _street.length() && _street.charAt(i + 1) == 'H') {
                    if (i - 1 < 0) {
                        return -1;
                    } else if (i - 1 >= 0 && _street.charAt(i - 1) == 'H') {
                        return -1;
                    } else {
                        if (buckets[i - 1] != 1) {
                            buckets[i - 1] = 1;
                            minBuckets++;
                        }
                    }
                } else if (i + 1 >= _street.length() && i - 1 < 0) {
                    return -1;
                } else if (i - 1 >= 0 && _street.charAt(i - 1) == '.') {
                    if (buckets[i - 1] != 1) {
                        minBuckets++;
                        buckets[i - 1] = 1;
                    }
                } else if (i + 1 >= _street.length() && i - 1 >= 0 && _street.charAt(i - 1) == 'H') {
                    return -1;
                }
            }
        }
        return minBuckets;
    }

}
