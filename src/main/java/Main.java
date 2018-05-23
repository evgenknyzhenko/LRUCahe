/**
 * Created by Евгений on 22.05.2018.
 */
public class Main {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.put(11, 111);


        int result = cache.get(14);

        cache.put(19,999);





        System.out.println(result);
        //System.out.println(result2);

    }
}
