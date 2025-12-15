package Praktikum3;

public class MyClosedHashtableKV<K, V> {

    protected int[] tagArray;
    private HashElement<K, V>[] bucketArray;
    protected int size;
    protected int capacity;

    static final int EMPTY = 0;
    static final int OCCUPIED = 1;
    static final int DELETED = 2;

    public int size() { return size; }
    public int getCapacity() { return capacity;}
    public boolean isEmpty() { return size == 0; }

    @SuppressWarnings("unchecked")
    public MyClosedHashtableKV(int aCapacity) {
        this.capacity = aCapacity;
        tagArray = new int[capacity];
        bucketArray = (HashElement<K, V>[]) new HashElement[capacity];
        for (int i = 0; i < capacity; i++) {
            tagArray[i] = EMPTY;
            bucketArray[i] = null;
        }
        size = 0;
    }
    
    /* Hashfunktion */
    public int getInitialHashIndex(K key) {
        int hashValue = key.hashCode() % capacity;
        if (hashValue < 0) hashValue += capacity;
        return hashValue;
    }

    /* Sondierungsfunktion: lineares Sondieren */
    public int s(int j, Object key) {
        return j;
    }

    public void add(K key, V value) {
        if (size == capacity) return;

        int k = getInitialHashIndex(key);
        int i = k;
        int j = 0;

        while (tagArray[i] == OCCUPIED) {
            i = (k + s(j, key)) % capacity;
            j++;
            if (j > capacity) return; // safety
        }

        bucketArray[i] = new HashElement<>(key, value);
        tagArray[i] = OCCUPIED;
        size++;
    }

    /* Index suchen oder -1 */
    public int searchForKey(K key) {
        int k = getInitialHashIndex(key);
        int i = k;
        int j = 0;

        while (tagArray[i] != EMPTY
                && !(tagArray[i] == OCCUPIED
                    && bucketArray[i] != null
                    && key.equals(bucketArray[i].key))
                && j <= capacity) {
            i = (k + s(j++, key)) % capacity;
        }

        if (j <= capacity && tagArray[i] == OCCUPIED) return i;
        return -1;
    }

    public V find(K key) {
        int i = searchForKey(key);
        return (i != -1) ? bucketArray[i].value : null;
    }
    
    public V remove(K key) {
        int i = searchForKey(key);
        if (i == -1) return null;

        V value = bucketArray[i].value;
        bucketArray[i] = null;
        tagArray[i] = DELETED; // wichtig!
        size--;
        return value;
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            switch (tagArray[i]) {
                case EMPTY -> System.out.print("[ ] ");
                case DELETED -> System.out.print("{ } ");
                case OCCUPIED -> System.out.print("(" + bucketArray[i].key + ") ");
            }
        }
        System.out.println();
    }

    // Test direkt in der Klasse
    public static void main(String[] args) {
        MyClosedHashtableKV<Integer, String> ht = new MyClosedHashtableKV<>(11);

        ht.add(1, "one");
        ht.add(2, "two");
        ht.add(3, "three");
        ht.add(4, "four");
        ht.add(5, "five");
        ht.add(6, "six");
        ht.add(7, "seven");
        ht.add(8, "eight");
        ht.add(12, "twelve");
        ht.add(15, "fifteen");

        ht.printTable();
        ht.add(16, "sixteen");
        ht.printTable();

        System.out.println(ht.find(9));
        System.out.println(ht.find(3));

        ht.remove(3);
        ht.remove(6);
        ht.remove(8);
        ht.printTable();
    }
}

/* Hilfsklasse (top-level, NICHT static) */
class HashElement<K, V> {
    K key;
    V value;

    public HashElement(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

