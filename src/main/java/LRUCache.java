/**
 * Created by Евгений on 22.05.2018.
 */

public class LRUCache {
    private int capacity;
    private int size;
    private Entry first;
    private Entry element;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(11, 110);
        cache.put(12, 120);
        cache.put(11, 130);
        cache.put(14, 140);
        cache.put(11, 150);
        cache.put(16, 160);
        System.out.println(cache.get(14));
        System.out.println(cache.get(13));
        cache.put(19, 170);
        cache.put(12, 180);
        cache.put(19, 190);

        cache.printAllElements();
        System.out.println(cache.getSize());
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public void printAllElements() {
        element = first;

        for (int i = 0; i < size; i++) {
            if (element != null) {
                System.out.println("Key: " + element.key + ", Value: " + element.value);
                element = element.nextElement;
            }
        }
    }


    public int getSize() {
        return size;
    }


    public int get(int key) {
        int result = -1;
        element = first;

        for (int i = 0; i < size; i++) {
            if (element.key == key) {
                result = element.value;
                moveToFirstPosition(element);
                return result;
            } else {
                element = element.nextElement;
            }
        }

        return result;
    }


    public void put(int key, int value) {
        if (first == null) {
            first = new Entry(key, value, null, null);
            size = 1;
            return;
        }

        element = first;
        for (int i = 0; i < size; i++) {
            if (element.key == key) {
                element.value = value;
                moveToFirstPosition(element);
                return;
            }
            element = element.nextElement;
        }

        element = first;
        first = new Entry(key, value, null, element);
        element.previousElement = first;
        size++;

        if (size > capacity) {
            deleteLastElement();
        }
    }


    private void moveToFirstPosition(Entry element) {
        if (element.nextElement == null) {
            moveToFirstPositionLastElement(element);
            return;
        }

        if (element.previousElement == null) {
            return;
        }

        element.previousElement.nextElement = element.nextElement;
        element.nextElement.previousElement = element.previousElement;

        first.previousElement = element;
        element.nextElement = first;
        element.previousElement = null;
        first = element;

    }


    private void moveToFirstPositionLastElement(Entry element) {
        if (size != 1) {
            element.previousElement.nextElement = null;
            element.previousElement = null;
            element.nextElement = first;
            first.previousElement = element;
            first = element;
        }


    }


    private void deleteLastElement() {
        element = first;

        for (int i = 0; i < size; i++) {
            if (element.nextElement == null) {
                element = element.previousElement;
                element.nextElement = null;
                size--;
            }
            element = element.nextElement;
        }
    }


    private class Entry {
        private int key;
        private int value;
        private Entry previousElement;
        private Entry nextElement;

        public Entry(int key, int value, Entry previousElement, Entry nextElement) {
            this.key = key;
            this.value = value;
            this.previousElement = previousElement;
            this.nextElement = nextElement;
        }
    }
}
