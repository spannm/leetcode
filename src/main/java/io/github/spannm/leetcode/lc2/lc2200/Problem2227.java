package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2227 extends LeetcodeProblem {

    static class Encrypter {
        private final Map<Character, String> mp  = new HashMap<>();
        private final Map<String, Integer>   cnt = new HashMap<>();

        Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                mp.put(keys[i], values[i]);
            }
            for (String w : dictionary) {
                w = encrypt(w);
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
            }
        }

        String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                if (!mp.containsKey(c)) {
                    return "";
                }
                sb.append(mp.get(c));
            }
            return sb.toString();
        }

        int decrypt(String word2) {
            return cnt.getOrDefault(word2, 0);
        }

    }

}
