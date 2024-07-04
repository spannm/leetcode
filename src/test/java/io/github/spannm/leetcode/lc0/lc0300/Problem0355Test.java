package io.github.spannm.leetcode.lc0.lc0300;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Test;

class Problem0355Test extends LeetcodeBaseTest {

    @Test
    void test() {
        Problem0355.Twitter twitter = new Problem0355.Twitter();

        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        assertThatList(twitter.getNewsFeed(1)).containsExactly(5);

        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        assertThatList(twitter.getNewsFeed(1)).containsExactly(6, 5);

        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        assertThatList(twitter.getNewsFeed(1)).containsExactly(5);
    }

}
