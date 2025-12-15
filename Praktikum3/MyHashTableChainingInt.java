package Praktikum3;

public class MyHashTableChainingInt {

    private HashIntNode[] bucketArray;
    private int numOfBuckets;
    private int size;

    public MyHashTableChainingInt(int aNumOfBuckets) {
        numOfBuckets = aNumOfBuckets;
        bucketArray = new HashIntNode[numOfBuckets];
        size = 0;
    }

    private int getHashIndex(int key) {
        int index = key % numOfBuckets;
        if (index < 0) index += numOfBuckets;
        return index;
    }

    public void add(int key) {
        int bucketIndex = getHashIndex(key);
        HashIntNode head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key == key) return; // schon vorhanden
            head = head.next;
        }

        size++;
        head = bucketArray[bucketIndex];
        HashIntNode newNode = new HashIntNode(key);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public int get(int key) {
        int bucketIndex = getHashIndex(key);
        HashIntNode head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key == key) return head.key;
            head = head.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int bucketIndex = getHashIndex(key);
        HashIntNode head = bucketArray[bucketIndex];
        HashIntNode prev = null;

        while (head != null) {
            if (head.key == key) {
                size--;
                if (prev != null) prev.next = head.next;
                else bucketArray[bucketIndex] = head.next;
                return true;
            }
            prev = head;
            head = head.next;
        }
        return false;
    }

    public void printBuckets() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print(i + ": ");
            HashIntNode cur = bucketArray[i];
            while (cur != null) {
                System.out.print(cur.key + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashTableChainingInt ht = new MyHashTableChainingInt(5);
        int[] keys = {26, 11, 32, 45, 16};
        for (int k : keys) ht.add(k);

        ht.printBuckets();
        System.out.println("get(16) = " + ht.get(16));
        System.out.println("remove(11) = " + ht.remove(11));
        ht.printBuckets();
    }
}

/* Hilfsklasse (top-level, NICHT static) */
class HashIntNode {
    int key;
    HashIntNode next;

    public HashIntNode(int aKey) {
        key = aKey;
    }
}
