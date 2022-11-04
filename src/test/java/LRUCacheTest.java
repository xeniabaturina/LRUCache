import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    LRUCache<Integer, String> LRUCache;
    int INITIAL_CAPACITY = 5;

    @BeforeEach
    void setUp() {
        LRUCache = new LRUCache<>(INITIAL_CAPACITY);
    }

    @Test
    @DisplayName("Capacity is correct")
    public void capacityIsCorrect() {
        assertEquals(INITIAL_CAPACITY, LRUCache.capacity);
    }

    @Test
    @DisplayName("Get from empty returns null")
    public void getFromEmptyReturnNull() {
        assertNull(LRUCache.get(7));
    }

    @Test
    @DisplayName("Put to cache works correctly")
    public void putToCacheIsCorrect() {
        LRUCache.put(3, "cat");

        assertEquals("cat", LRUCache.get(3));
    }

    @Test
    @DisplayName("Key-value is changing correctly")
    public void changeValueByKeyIsCorrect() {
        LRUCache.put(3, "cat");
        LRUCache.put(3, "dog");

        assertEquals("dog", LRUCache.get(3));
    }

    @Test
    @DisplayName("Last recently used key is deleted")
    public void lastRecentlyUsedIsDeleted() {
        LRUCache.put(7, "dog");
        LRUCache.put(3, "cat");
        LRUCache.put(6, "emu");
        LRUCache.put(2, "chicken");
        LRUCache.put(4, "panda");
        LRUCache.put(5, "capybara");

        assertNull(LRUCache.get(7));
    }
}
