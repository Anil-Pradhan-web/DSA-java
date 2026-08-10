import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class q20 {
    /*
     * Pattern: Heap / Design + Max Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #355: Design Twitter
     *
     * Problem samajh lo:
     * Humein Twitter jaisa system design karna hai jisme:
     * - User tweets post kar sakta hai
     * - User kisi ko follow karta hai
     * - User apne feed me recent 10 tweets dekh sakta hai
     * (apne + jo follow kar raha hai, sabse new se purane tak)
     *
     * Example:
     * postTweet(1, 5) -> user 1 ne tweet 5 post kiya
     * getNewsFeed(1) -> [5]
     * follow(1, 2) -> user 1 ne user 2 ko follow kiya
     * postTweet(2, 6) -> user 2 ne tweet 6 post kiya
     * getNewsFeed(1) -> [6, 5]
     *
     * Best idea:
     * Step 1: Har user ke tweets store karo (timestamp ke saath).
     * Step 2: Har user ka follow set maintain karo.
     * Step 3: Feed ke liye max heap use karo — sabse naya tweet pehle.
     * Step 4: Apne aur followed users ke tweets heap me daalo, top 10 nikalo.
     *
     * Time Complexity: getNewsFeed O(n log n) where n = tweets
     * Space Complexity: O(total tweets + total follows)
     */
    static class Twitter {
        private Map<Integer, List<int[]>> tweets; // userId -> [(timestamp, tweetId)]
        private Map<Integer, Set<Integer>> following; // userId -> set of followed users
        private int timestamp;

        public Twitter() {
            tweets = new HashMap<>();
            following = new HashMap<>();
            timestamp = 0;
        }

        public void postTweet(int userId, int tweetId) {
            tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] { timestamp++, tweetId });
        }

        public List<Integer> getNewsFeed(int userId) {
            // Max heap by timestamp (sabse naya pehle)
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b[0], a[0]));

            // Apne tweets
            addUserTweets(userId, maxHeap);

            // Followed users ke tweets
            if (following.containsKey(userId)) {
                for (int followedId : following.get(userId)) {
                    addUserTweets(followedId, maxHeap);
                }
            }

            // Top 10 nikaalo
            List<Integer> feed = new ArrayList<>();
            while (!maxHeap.isEmpty() && feed.size() < 10) {
                feed.add(maxHeap.poll()[1]);
            }
            return feed;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return; // khud ko follow nahi kar sakte
            }
            following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId)) {
                following.get(followerId).remove(followeeId);
            }
        }

        private void addUserTweets(int userId, PriorityQueue<int[]> maxHeap) {
            if (!tweets.containsKey(userId)) {
                return;
            }
            for (int[] tweet : tweets.get(userId)) {
                maxHeap.add(tweet);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println("User 1 feed = " + twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("User 1 feed after following 2 = " + twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println("User 1 feed after unfollowing 2 = " + twitter.getNewsFeed(1));
    }
}