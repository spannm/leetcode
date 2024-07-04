package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1945 extends LeetcodeProblem {

    int getLucky(String _s, int _k) {
        List<Integer> list = new ArrayList<>();
        for (char c : _s.toCharArray()) {
            list.add(c - 'a' + 1);
        }
        int sum = 0;
        for (int i : list) {
            if (i >= 10) {
                sum += i / 10;
            }
            sum += i % 10;
        }
        while (_k-- > 1) {
            int newSum = 0;
            while (sum != 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            sum = newSum;
        }
        return sum;
    }

}
