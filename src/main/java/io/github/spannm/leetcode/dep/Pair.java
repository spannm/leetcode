package io.github.spannm.leetcode.dep;

public class Pair<K, V> {
    private final K key;
    private final V val;

    public Pair(K _key, V _val) {
        key = _key;
        val = _val;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return val;
    }
}
