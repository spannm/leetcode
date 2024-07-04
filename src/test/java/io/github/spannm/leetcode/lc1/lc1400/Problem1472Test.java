package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc1.lc1400.Problem1472.BrowserHistory;
import org.junit.jupiter.api.Test;

class Problem1472Test extends LeetcodeBaseTest {

    @Test
    void test() {

        String url;

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");     // in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");   // in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");    // in "facebook.com". Visit "youtube.com"

        url = browserHistory.back(1);           // in "youtube.com", move back to "facebook.com" return "facebook.com"
        assertEquals("facebook.com", url);

        url = browserHistory.back(1);           // in "facebook.com", move back to "google.com" return "google.com"
        assertEquals("google.com", url);

        url = browserHistory.forward(1);        // in "google.com", move forward to "facebook.com" return "facebook.com"
        assertEquals("facebook.com", url);

        browserHistory.visit("linkedin.com");   // in "facebook.com". Visit "linkedin.com"

        url = browserHistory.forward(2);        // in "linkedin.com", you cannot move forward any steps.
        assertEquals("linkedin.com", url);

        url = browserHistory.back(2);           // in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        assertEquals("google.com", url);

        url = browserHistory.back(7);           // in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
        assertEquals("leetcode.com", url);
    }

}
