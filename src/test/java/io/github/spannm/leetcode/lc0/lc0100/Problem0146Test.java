package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc0.lc0100.Problem0146.LRUCache;
import org.junit.jupiter.api.Test;

class Problem0146Test extends LeetcodeBaseTest {

    @Test
    void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertEquals(LRUCache.NOT_FOUND, lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertEquals(LRUCache.NOT_FOUND, lruCache.get(1)); // return -1 (not found)
        assertEquals(3, lruCache.get(3));
        lruCache.get(3); // return 3
        assertEquals(4, lruCache.get(4));
    }

}
