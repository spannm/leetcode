package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1813 extends LeetcodeProblem {

    boolean areSentencesSimilar(String _sentence1, String _sentence2) {
        String shorter = _sentence1.length() < _sentence2.length() ? _sentence1 : _sentence2;
        String longer = shorter.equals(_sentence1) ? _sentence2 : _sentence1;
        String[] shortWords = shorter.split(" ");
        String[] longWords = longer.split(" ");
        int breaks = 0;
        int j = 0;
        int i = 0;
        while (i < shortWords.length && j < longWords.length) {
            if (shortWords[i].equals(longWords[j])) {
                j++;
                i++;
            } else {
                breaks++;
                if (breaks > 1) {
                    break;
                }
                while (j < longWords.length && !longWords[j].equals(shortWords[i])) {
                    j++;
                }
            }
        }
        if (breaks == 1 && i == shortWords.length && j == longWords.length || i == shortWords.length && breaks == 0) {
            return true;
        }

        i = shortWords.length - 1;
        j = longWords.length - 1;
        breaks = 0;
        while (i >= 0 && j >= 0) {
            if (shortWords[i].equals(longWords[j])) {
                i--;
                j--;
            } else {
                breaks++;
                if (breaks > 1) {
                    return false;
                }
                while (j >= 0 && !longWords[j].equals(shortWords[i])) {
                    j--;
                }
            }
        }
        return breaks == 1 && i == -1 && j == -1 || breaks == 0 && i == -1;
    }

}
