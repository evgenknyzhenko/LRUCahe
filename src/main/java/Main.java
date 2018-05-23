/**
 * Created by Евгений on 22.05.2018.
 */
public class Main {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.put(11, 111);
        cache.put(12,222);
        cache.put(13, 333);
        cache.put(14,444);
        cache.put(15, 555);

        cache.put(16,666);
        cache.put(17, 777);
        cache.put(18,888);

        int result = cache.get(14);

        cache.put(19,999);

        int result2 = cache.get(15);




        System.out.println(result);
        System.out.println(result2);

    }
}
