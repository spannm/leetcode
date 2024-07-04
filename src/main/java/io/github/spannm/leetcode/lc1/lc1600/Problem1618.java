package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1618. Maximum Font to Fit a Sentence in a Screen.
 */
class Problem1618 extends LeetcodeProblem {

    int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(text, fonts[mid], w, h, fontInfo)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return check(text, fonts[left], w, h, fontInfo) ? fonts[left] : -1;
    }

    static boolean check(String text, int size, int w, int h, FontInfo fontInfo) {
        if (fontInfo.getHeight(size) > h) {
            return false;
        }
        int width = 0;
        for (char c : text.toCharArray()) {
            width += fontInfo.getWidth(size, c);
        }
        return width <= w;
    }

    @SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
    interface FontInfo {

        int getWidth(int fontSize, char ch);

        int getHeight(int fontSize);
    }

}
