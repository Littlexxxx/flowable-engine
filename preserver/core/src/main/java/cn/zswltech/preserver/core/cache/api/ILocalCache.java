package cn.zswltech.preserver.core.cache.api;

public interface ILocalCache<K, V> {

    V get(K key);

    void put(K key, V value);

    V remove(K key);
}