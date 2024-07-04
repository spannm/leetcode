package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1002 extends LeetcodeProblem {

    List<String> commonChars(String[] _words) {
        int len = _words.length;
        int[][] counts = new int[len][26];
        for (int i = 0; i < len; i++) {
            for (char c : _words[i].toCharArray()) {
                counts[i][c - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (counts[0][i] != 0) {
                char c = (char) (i + 'a');
                boolean valid = true;
                counts[0][i]--;
                for (int j = 1; j < len; j++) {
                    if (counts[j][i] == 0) {
                        valid = false;
                        break;
                    } else {
                        counts[j][i]--;
                    }
                }
                if (!valid) {
                    break;
                }
                result.add(Character.toString(c));
            }
        }
        return result;
    }

}
