package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0838 extends LeetcodeProblem {

    String pushDominoes(String _dominoes) {
        StringBuilder currentSb = new StringBuilder(_dominoes);
        Set<String> visited = new HashSet<>();
        visited.add(_dominoes);
        do {
            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < currentSb.length(); i++) {
                if (currentSb.charAt(i) == 'L') {
                    newSb.append('L');
                    if (i == 1 && currentSb.charAt(i - 1) == '.') {
                        newSb.replace(i - 1, i, "L");
                    } else if (i > 1 && currentSb.charAt(i - 1) == '.' && currentSb.charAt(i - 2) != 'R') {
                        newSb.replace(i - 1, i, "L");
                    }
                } else if (currentSb.charAt(i) == 'R') {
                    newSb.append('R');
                    if (i == currentSb.length() - 2 && currentSb.charAt(i + 1) == '.') {
                        newSb.replace(i + 1, i + 2, "R");
                        i++;
                    } else if (i < currentSb.length() - 2 && currentSb.charAt(i + 1) == '.' && currentSb.charAt(i + 2) != 'L') {
                        newSb.replace(i + 1, i + 2, "R");
                        i++;
                    }
                } else {
                    newSb.append('.');
                }
            }
            currentSb.setLength(0);
            currentSb = newSb;
        } while (visited.add(currentSb.toString()));
        return currentSb.toString();
    }

}
