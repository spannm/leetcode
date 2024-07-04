package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Problem2309 extends LeetcodeProblem {

    String greatestLetter(String _s) {
        List<Character> lowercase = new ArrayList<>();
        List<Character> uppercase = new ArrayList<>();
        for (char c : _s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase.add(c);
            } else {
                uppercase.add(c);
            }
        }
        uppercase.sort(Comparator.reverseOrder());
        lowercase.sort(Comparator.reverseOrder());
        for (Character element : uppercase) {
            for (Character element2 : lowercase) {
                if (Character.toLowerCase(element) == element2) {
                    return element + "";
                }
            }
        }
        return "";
    }

}
