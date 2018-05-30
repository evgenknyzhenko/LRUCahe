import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

/**
 * Created by Евгений on 30.05.2018.
 */
@RunWith(JUnit4.class)
public class LRUCacheTest {
    private LRUCache cache;

    @Before
    public void setUp() throws Exception {
        cache = new LRUCache(5);
    }


    @Test
    public void testGetSize() throws Exception {
        cache.put(1, 11);
        assertEquals(1, cache.getSize());
        cache.put(2, 12);
        cache.put(1, 11);
        cache.put(3, 11);
        cache.put(5, 11);
        assertEquals(4, cache.getSize());
        cache.get(2);
        cache.put(6, 12);
        assertEquals(5, cache.getSize());
        cache.put(7, 13);
        assertEquals(5, cache.getSize());
    }


    @Test
    public void testGet() throws Exception {

        cache.put(1, 11);
        cache.put(2, 12);
        cache.put(3, 13);
        cache.put(3, 33);
        cache.put(5, 15);
        cache.put(6, 16);
        cache.put(7, 17);
        assertEquals(-1, cache.get(40));
        assertEquals(-1, cache.get(1));
        assertEquals(33, cache.get(3));
        assertEquals(17, cache.get(7));
    }


    @Test
    public void testPut() throws Exception {
        assertEquals(-1, cache.get(4));
        cache.put(4, 11);
        assertEquals(11, cache.get(4));
        cache.put(5, 12);
        assertEquals(12, cache.get(5));
    }

}