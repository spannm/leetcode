package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://leetcode.com/problems/validate-ip-address/">468. Validate IP Address</a>.
 */
class Problem0468 extends LeetcodeProblem {

    private static final Pattern IPV4PATTERN = Pattern.compile("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");
    private static final Pattern IPV6PATTERN = Pattern.compile("(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
    private static final String  NEITHER     = "Neither";
    private static final String  IPV4        = "IPv4";
    private static final String  IPV6        = "IPv6";

    String validIPAddress(String _queryIP) {
        if (_queryIP == null || _queryIP.length() < 7) {
            return NEITHER;
        }

        Matcher ipv4Matcher = IPV4PATTERN.matcher(_queryIP);
        if (ipv4Matcher.matches()) {
            for (int i = 1; i <= ipv4Matcher.groupCount(); i++) {
                String grp = ipv4Matcher.group(i);
                int grpLen = grp.length();
                if (grpLen > 1) {
                    if (grp.startsWith("0")) {
                        return NEITHER;
                    } else if (grpLen == 3 && Integer.parseInt(grp) > 255) {
                        return NEITHER;
                    }
                }
            }
            return IPV4;
        }

        return IPV6PATTERN.matcher(_queryIP).matches() ? IPV6 : NEITHER;
    }

}
