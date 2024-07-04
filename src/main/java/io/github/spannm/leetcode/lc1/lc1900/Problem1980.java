package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-unique-binary-string/">1980. Find Unique Binary String</a>.
 */
class Problem1980 extends LeetcodeProblem {

    String findDifferentBinaryString(String[] _nums) {
        Set<String> set = new HashSet<>(List.of(_nums));
        int len = _nums[0].length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            sb.append(1);
            i++;
        }
        int max = Integer.parseInt(sb.toString(), 2);
        for (int num = 0; num <= max; num++) {
            String binary = Integer.toBinaryString(num);
            if (binary.length() < len) {
                sb.setLength(0);
                sb.append(binary);
                while (sb.length() < len) {
                    sb.insert(0, "0");
                }
                binary = sb.toString();
            }
            if (!set.contains(binary)) {
                return binary;
            }
        }
        return null;
    }

}
