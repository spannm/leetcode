package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem0299 extends LeetcodeProblem {

    String getHint(String _secret, String _guess) {
        int[] secretCows = new int[10];
        int[] guessCows = new int[10];
        int bulls = 0;
        for (int i = 0; i < _secret.length(); i++) {
            char s = _secret.charAt(i);
            char g = _guess.charAt(i);
            if (g == s) {
                bulls++;
            } else {
                secretCows[Character.getNumericValue(s)]++;
                guessCows[Character.getNumericValue(g)]++;
            }
        }

        int cows = IntStream.range(0, 10).map(i -> Math.min(secretCows[i], guessCows[i])).sum();
        return bulls + "A" + cows + "B";
    }

}
