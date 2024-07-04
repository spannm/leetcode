package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem0388 extends LeetcodeProblem {

    int lengthLongestPath(String _input) {
        int maxLen = 0;
        int currDirLen = 0;
        int currLvl = 0;
        int nextLvl = 0;
        boolean isFile = false;
        Character period = '.';
        Character space = ' ';
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < _input.length()) {
            currLvl = nextLvl;
            int currStrLen = 0;
            for (; i < _input.length(); i++) {
                char c = _input.charAt(i);
                if (!Character.isLetterOrDigit(c) && !period.equals(c) && !space.equals(c)) {
                    break;
                }
                if (period.equals(c)) {
                    isFile = true;
                }
                currStrLen++;
            }

            if (isFile) {
                maxLen = Math.max(maxLen, currDirLen + currStrLen);
            } else {
                currDirLen += currStrLen + 1;
                stack.push(currStrLen + 1);
            }

            nextLvl = 0;
            i = i + 1;
            while (i < _input.length() - 1 && _input.charAt(i) == '\t') {
                nextLvl++;
                i = i + 1;
            }

            if (nextLvl < currLvl) {
                int j = 0;
                if (isFile) {
                    while (!stack.isEmpty() && j < currLvl - nextLvl) {
                        currDirLen -= stack.pop();
                        j++;
                    }
                } else {
                    while (!stack.isEmpty() && j <= currLvl - nextLvl) {
                        currDirLen -= stack.pop();
                        j++;
                    }
                }
            } else if (nextLvl == currLvl) {
                if (!isFile && !stack.isEmpty()) {
                    currDirLen -= stack.pop();
                }
            }

            if (nextLvl == 0) {
                currDirLen = 0;
                stack.clear();
            }

            isFile = false;
        }

        return maxLen;
    }

}
