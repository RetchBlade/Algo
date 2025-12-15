package Praktikum3;

public class MyHashTableChainingKV<K, V> {

    private HashListNode<K, V>[] bucketArray;
    private int numOfBuckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTableChainingKV(int aNumOfBuckets) {
        numOfBuckets = aNumOfBuckets;
        bucketArray = (HashListNode<K, V>[]) new HashListNode[numOfBuckets];
        size = 0;
        for (int i = 0; i < numOfBuckets; i++) bucketArray[i] = null;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    private int getHashIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numOfBuckets;
        if (index < 0) index += numOfBuckets;
        return index;
    }

    public V get(K key) {
        int bucketIndex = getHashIndex(key);
        HashListNode<K, V> head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getHashIndex(key);
        HashListNode<K, V> head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray[bucketIndex];
        HashListNode<K, V> newNode = new HashListNode<>(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public V remove(K key) {
        int bucketIndex = getHashIndex(key);
        HashListNode<K, V> head = bucketArray[bucketIndex];
        HashListNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prev != null) prev.next = head.next;
                else bucketArray[bucketIndex] = head.next;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public void printBuckets() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print(i + ": ");
            HashListNode<K, V> cur = bucketArray[i];
            while (cur != null) {
                System.out.print("(" + cur.key + "->" + cur.value + ") ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashTableChainingKV<Integer, String> ht = new MyHashTableChainingKV<>(5);

        ht.add(1, "one");
        ht.add(6, "six");
        ht.add(11, "eleven");
        ht.printBuckets();

        System.out.println("get(6) = " + ht.get(6));
        System.out.println("remove(6) = " + ht.remove(6));
        ht.printBuckets();
    }
}

/* Hilfsklasse (top-level, NICHT static) */
class HashListNode<K, V> {
    K key;
    V value;
    HashListNode<K, V> next;

    public HashListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
