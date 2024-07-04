package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1410. HTML Entity Parser
 * <p>
 * HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters
 * by the characters itself. The special characters and their entities for HTML are: Quotation Mark: the entity is
 * &quot; and symbol character is ". Single Quote Mark: the entity is &apos; and symbol character is '. Ampersand: the
 * entity is &amp; and symbol character is &. Greater Than Sign: the entity is &gt; and symbol character is >. Less Than
 * Sign: the entity is &lt; and symbol character is <. Slash: the entity is &frasl; and symbol character is /. Given the
 * input text string to the HTML parser, you have to implement the entity parser.
 * <p>
 * Return the text after replacing the entities by the special characters.
 * <p>
 * Example 1: Input: text = "&amp; is an HTML entity but &ambassador; is not." Output: "& is an HTML entity but
 * &ambassador; is not." Explanation: The parser will replace the &amp; entity by &
 * <p>
 * Example 2: Input: text = "and I quote: &quot;...&quot;" Output: "and I quote: \"...\""
 * <p>
 * Example 3: Input: text = "Stay home! Practice on Leetcode :)" Output: "Stay home! Practice on Leetcode :)"
 * <p>
 * Example 4: Input: text = "x &gt; y &amp;&amp; x &lt; y is always false" Output: "x > y && x < y is always false"
 * <p>
 * Example 5: Input: text = "leetcode.com&frasl;problemset&frasl;all" Output: "leetcode.com/problemset/all"
 * <p>
 * Constraints: 1 <= text.length <= 10^5 The string may contain any possible characters out of all the 256 ASCII
 * characters.
 */
class Problem1410 extends LeetcodeProblem {

    String entityParser(String _text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _text.length(); i++) {
            if (_text.charAt(i) != '&') {
                sb.append(_text.charAt(i));
            } else {
                if (i + 7 <= _text.length() && _text.startsWith("&frasl;", i)) {
                    sb.append("/");
                    i += 6;
                } else if (i + 6 <= _text.length() && _text.startsWith("&quot;", i)) {
                    sb.append("\"");
                    i += 5;
                } else if (i + 6 <= _text.length() && _text.startsWith("&apos;", i)) {
                    sb.append("'");
                    i += 5;
                } else if (i + 5 <= _text.length() && _text.startsWith("&amp;", i)) {
                    sb.append("&");
                    i += 4;
                } else if (i + 4 <= _text.length() && _text.startsWith("&gt;", i)) {
                    sb.append(">");
                    i += 3;
                } else if (i + 4 <= _text.length() && _text.startsWith("&lt;", i)) {
                    sb.append("<");
                    i += 3;
                } else {
                    sb.append(_text.charAt(i));
                }
            }
        }
        return sb.toString();
    }

}
