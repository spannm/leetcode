package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem0824 extends LeetcodeProblem {

    String toGoatLatin(String _s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels =
            Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] words = _s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0))) {
                String newWord = words[i] + "ma";
                int j = i + 1;
                while (j-- > 0) {
                    newWord += 'a';
                }
                sb.append(newWord);
                sb.append(" ");
            } else {
                StringBuilder subSb = new StringBuilder(words[i].substring(1));
                subSb.append(words[i].charAt(0));
                subSb.append("ma");
                int j = i + 1;
                while (j-- > 0) {
                    subSb.append("a");
                }
                sb.append(subSb);
                sb.append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

}
