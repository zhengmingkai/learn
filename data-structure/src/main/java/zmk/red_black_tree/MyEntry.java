package zmk.red_black_tree;

import java.util.Map;

/**
 * Created by Administrator on 2018/8/3/003.
 */
public class MyEntry<K,V> implements Map.Entry<K,V>{

    public static final boolean BLACK = true;
    public static final boolean RED = false;

    public MyEntry<K,V> parent;
    public MyEntry<K,V> left;
    public MyEntry<K,V> right;
    public K key;
    public V value;
    public boolean color = RED;

    public MyEntry( K key, V value,MyEntry<K, V> parent) {
        this.parent = parent;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
