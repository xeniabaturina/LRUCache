import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> {
    int capacity;
    private final LinkedList<K> list;
    private final HashMap<K, V> map;

    public LRUCache(int capacity) {
        assert capacity > 0 : "capacity must be positive";

        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public V get(K key) {
        assert key != null;

        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);

            assert list.getFirst() == key : "first value in list is not key";
            assert map.get(key) != null : "map.get(key) returned null";

            return map.get(key);
        }
        assert map.get(key) == null : "map.get(key) is not null";

        return map.get(key);
    }

    public void put(K key, V value) {
        assert key != null : "key is null";
        assert value != null : "value is null";

        if (map.containsKey(key)) {
            list.remove(key);
        } else {
            if (list.size() == capacity) {
                K last = list.removeLast();
                map.remove(last);

                assert map.get(last) == null : "map still contains last used key";
            }
        }
        assert list.size() < capacity : "overflow";

        list.addFirst(key);
        map.put(key, value);

        assert map.get(key) == value : "map.get(key) != value";
        assert list.getFirst() == key : "first value in list is not key";
    }
}
