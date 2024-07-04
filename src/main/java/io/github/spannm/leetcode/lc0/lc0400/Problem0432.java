package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem0432 extends LeetcodeProblem {

    static class AllOne {

        private final Bucket               head;
        private final Bucket               tail;

        private final Map<Integer, Bucket> countBucketMap;

        private final Map<String, Integer> keyCountMap;

        private static class Bucket {
            private final int         count;
            private final Set<String> keySet;
            private Bucket            next;
            private Bucket            pre;

            Bucket(int _count) {
                count = _count;
                keySet = new HashSet<>();
            }
        }

        AllOne() {
            head = new Bucket(Integer.MIN_VALUE);
            tail = new Bucket(Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            countBucketMap = new HashMap<>();
            keyCountMap = new HashMap<>();
        }

        public void inc(String _key) {
            if (keyCountMap.containsKey(_key)) {
                changeKey(_key, 1);
            } else {
                keyCountMap.put(_key, 1);
                if (head.next.count != 1) {
                    addBucketAfter(new Bucket(1), head);
                }
                head.next.keySet.add(_key);
                countBucketMap.put(1, head.next);
            }
        }

        public void dec(String _key) {
            if (keyCountMap.containsKey(_key)) {
                int count = keyCountMap.get(_key);
                if (count == 1) {
                    keyCountMap.remove(_key);
                    removeKeyFromBucket(countBucketMap.get(count), _key);
                } else {
                    changeKey(_key, -1);
                }
            }
        }

        public String getMaxKey() {
            return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
        }

        public String getMinKey() {
            return head.next == tail ? "" : head.next.keySet.iterator().next();
        }

        private void changeKey(String _key, int _offset) {
            int count = keyCountMap.get(_key);
            keyCountMap.put(_key, count + _offset);
            Bucket curBucket = countBucketMap.get(count);
            Bucket newBucket;
            if (countBucketMap.containsKey(count + _offset)) {

                newBucket = countBucketMap.get(count + _offset);
            } else {

                newBucket = new Bucket(count + _offset);
                countBucketMap.put(count + _offset, newBucket);
                addBucketAfter(newBucket, _offset == 1 ? curBucket : curBucket.pre);
            }
            newBucket.keySet.add(_key);
            removeKeyFromBucket(curBucket, _key);
        }

        private void removeKeyFromBucket(Bucket _bucket, String _key) {
            _bucket.keySet.remove(_key);
            if (_bucket.keySet.isEmpty()) {
                removeBucketFromList(_bucket);
                countBucketMap.remove(_bucket.count);
            }
        }

        private void removeBucketFromList(Bucket _bucket) {
            _bucket.pre.next = _bucket.next;
            _bucket.next.pre = _bucket.pre;
            _bucket.next = null;
            _bucket.pre = null;
        }

        private void addBucketAfter(Bucket _newBucket, Bucket _preBucket) {
            _newBucket.pre = _preBucket;
            _newBucket.next = _preBucket.next;
            _preBucket.next.pre = _newBucket;
            _preBucket.next = _newBucket;
        }
    }

}
