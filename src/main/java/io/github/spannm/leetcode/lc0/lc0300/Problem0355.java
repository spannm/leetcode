package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0355 extends LeetcodeProblem {

    static class Twitter {

        private static int               timestamp = 0;
        private final Map<Integer, User> map       = new HashMap<>();

        public void postTweet(int _userId, int _tweetId) {
            map.computeIfAbsent(_userId, User::new).postTweet(_tweetId);
        }

        public List<Integer> getNewsFeed(int _userId) {
            List<Integer> newsFeed = new LinkedList<>();
            if (!map.containsKey(_userId)) {
                return newsFeed;
            }
            Set<Integer> users = map.get(_userId).followed;
            Queue<Tweet> heap = new PriorityQueue<>(users.size(), (a, b) -> b.time - a.time);
            for (int user : users) {
                Tweet tweet = map.get(user).tweetHead;

                if (tweet != null) {
                    heap.offer(tweet);
                }
            }

            int count = 0;
            while (!heap.isEmpty() && count < 10) {
                Tweet tweet = heap.poll();
                newsFeed.add(tweet.id);
                count++;
                if (tweet.next != null) {
                    heap.offer(tweet.next);
                }
            }

            return newsFeed;
        }

        public void follow(int _followerId, int _followeeId) {
            map.computeIfAbsent(_followeeId, User::new);
            map.computeIfAbsent(_followerId, User::new).follow(_followeeId);
        }

        public void unfollow(int _followerId, int _followeeId) {
            if (!map.containsKey(_followerId) || _followeeId == _followerId) {
                return;
            }
            map.get(_followerId).unfollow(_followeeId);
        }

        static class Tweet {
            private final int time;
            private final int id;
            private Tweet     next;

            Tweet(int _id) {
                id = _id;
                time = timestamp++;
                next = null;
            }
        }

        static class User {
            private final int          id;
            private final Set<Integer> followed;
            private Tweet              tweetHead;

            User(int _id) {
                id = _id;
                followed = new HashSet<>();
                followed.add(_id);
                tweetHead = null;
            }

            public int getId() {
                return id;
            }

            public void follow(int _followeeId) {
                followed.add(_followeeId);
            }

            public void unfollow(int _followeeId) {
                followed.remove(_followeeId);
            }

            public void postTweet(int _tweetId) {
                Tweet head = new Tweet(_tweetId);
                head.next = tweetHead;
                tweetHead = head;
            }
        }

    }

}
