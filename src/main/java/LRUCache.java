

/**
 * Created by Евгений on 22.05.2018.
 */

public class LRUCache {
    private Entry[] entries;

    public LRUCache() {
        entries = new Entry[5];
    }


    public void put(int key, int valuee) {

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].getKey() == key) {
                entries[i].setValuee(valuee);
                moveElements(i);
                return;
            }
        }

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                entries[i] = new Entry(key, valuee);
                moveElements(i);
                return;
            }
        }

        moveElements(4);
        entries[0] = new Entry(key, valuee);
    }




    public int get(int key) {

        int resultValue = -1;

        for (int i = 0; i < entries.length; i++) {

            if (entries[i] != null && entries[i].getKey() == key) {
                resultValue = entries[i].getValuee();
                moveElements(i);
            }
        }
        return resultValue;
    }


    private void moveElements(int position) {
        Entry actualElement = entries[position];
        for (int i = position; i > 0; i--) {
            entries[i] = entries[i - 1];
        }
        entries[0] = actualElement;
    }


}