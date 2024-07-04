package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0468Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "172.16.254.1; IPv4",
        "192.168.1.0; IPv4",
        "256.256.256.256; Neither",
        "192.168.01.1; Neither",
        "192.168.1.00; Neither",
        "192.168@1.1; Neither",
        "2001:0db8:85a3:0:0:8A2E:0370:7334; IPv6",
        "2001:0db8:85a3:0000:0000:8a2e:0370:7334; IPv6",
        "2001:db8:85a3:0:0:8A2E:0370:7334; IPv6",
        "2001:0db8:85a3::8A2E:037j:7334; Neither",
        "02001:0db8:85a3:0000:0000:8a2e:0370:7334; Neither"
    })
    void test(String queryIP, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0468().validIPAddress(queryIP));
    }

}
