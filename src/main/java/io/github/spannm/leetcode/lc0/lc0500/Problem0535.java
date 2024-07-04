package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0535 extends LeetcodeProblem {

    static class Codec {
        public static final String         PREFIX = "http://tinyurl/";

        private int                        i      = 0;
        private final Map<Integer, String> map    = new HashMap<>();

        public String encode(String _longUrl) {
            map.put(i, _longUrl);
            return PREFIX + i++;
        }

        public String decode(String _shortUrl) {
            return map.get(Integer.parseInt(_shortUrl.substring(PREFIX.length())));
        }
    }

}
