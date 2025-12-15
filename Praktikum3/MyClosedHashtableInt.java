package Praktikum3;

public class MyClosedHashtableInt {

    protected int[] tagArray;
    private int[] bucketArray;
    protected int size;
    protected int capacity;

    static final int EMPTY = 0;
    static final int OCCUPIED = 1;
    static final int DELETED = 2;

    public MyClosedHashtableInt(int aCapacity) {
        this.capacity = aCapacity;
        tagArray = new int[capacity];
        bucketArray = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            tagArray[i] = EMPTY;
            bucketArray[i] = Integer.MIN_VALUE;
        }
        size = 0;
    }

    public int getInitialHashIndex(int key) {
        int hashValue = key % capacity;
        if (hashValue < 0) hashValue += capacity;
        return hashValue;
    }

    public int s(int j, int key) {
        return j; // lineares Sondieren
    }

    public void add(int key) {
        if (size == capacity) return;

        int k = getInitialHashIndex(key);
        int i = k;
        int j = 0;

        while (tagArray[i] == OCCUPIED) {
            i = (k + s(j, key)) % capacity;
            j++;
            if (j > capacity) return;
        }

        bucketArray[i] = key;
        tagArray[i] = OCCUPIED;
        size++;
    }

    public int searchForKey(int key) {
        int k = getInitialHashIndex(key);
        int i = k;
        int j = 0;

        while (tagArray[i] != EMPTY
                && !(tagArray[i] == OCCUPIED && bucketArray[i] == key)
                && j <= capacity) {
            i = (k + s(j++, key)) % capacity;
        }

        if (j <= capacity && tagArray[i] == OCCUPIED && bucketArray[i] == key) return i;
        return Integer.MIN_VALUE;
    }

    public boolean find(int key) {
        return searchForKey(key) != Integer.MIN_VALUE;
    }

    public boolean remove(int key) {
        int i = searchForKey(key);
        if (i == Integer.MIN_VALUE) return false;

        bucketArray[i] = Integer.MIN_VALUE;
        tagArray[i] = DELETED;
        size--;
        return true;
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            if (tagArray[i] == EMPTY) System.out.print("[ ] ");
            else if (tagArray[i] == DELETED) System.out.print("{ } ");
            else System.out.print("(" + bucketArray[i] + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyClosedHashtableInt ht = new MyClosedHashtableInt(7);
        int[] keys = {12, 53, 5, 15, 2, 19};
        for (int k : keys) ht.add(k);
        ht.printTable();

        System.out.println("find(15) = " + ht.find(15));
        System.out.println("remove(15) = " + ht.remove(15));
        ht.printTable();
    }
}

