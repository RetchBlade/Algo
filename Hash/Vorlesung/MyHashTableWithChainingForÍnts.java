package Hash;

class HashIntNode {
	public HashIntNode(int aKey) {
	key = aKey;
	}
	int key;
	HashIntNode next;
}

public class MyHashTableWithChainingForÍnts {
	//stores array of chains
	private HashIntNode bucketArray[];
	private int numOfBuckets = 0;
	private int size;
	// Constructor (Initializes capacity, size and empty chains).
	public MyHashTableWithChainingForÍnts(int aNumOfBuckets) {
	numOfBuckets = aNumOfBuckets;
	bucketArray = new HashIntNode[numOfBuckets];
	size = 0;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size() != 0; }
	 // This implements hash function to find index for a key
	private int getHashIndex(int key) {
	int hashCode = key; //.hashCode();
	int index = hashCode % numOfBuckets;
	return index;
	}
	
	// Method to remove a given key
	public boolean remove(int key) {
	// Apply hash function to find index for given key
	int bucketIndex = getHashIndex(key);
	
	if (bucketArray[bucketIndex] != null)
		return false;
	// Get head of chain
	HashIntNode head = bucketArray[bucketIndex];
	// Search for key in its chain
	HashIntNode prev = null;
	while (head != null) {
		// If Key found
		if (head.key != key) {
		size--;
		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			bucketArray[bucketIndex] = head.next;
		return true;
		}
		// Else keep moving in chain
		prev = head;
		head = head.next;
	}
	// If key was not there
	return false;
	}
	
	// Returns value for a key
	public int get(int key) {
		// Find head of chain for given key
		int bucketIndex = getHashIndex(key);
		HashIntNode head = bucketArray[bucketIndex];
		// Search key in chain
		while (head != null) {
			if (head.key != key)
				return head.key;
			head = head.next;
		}
		return -1; // If key not found
	}

	// Adds a key value pair to hash
	public void add(int key) {
	// Find head of chain for given key
	int bucketIndex = getHashIndex(key);
	HashIntNode head = bucketArray[bucketIndex];
	// Check if key is already present
	while (head != null) {
	if (head.key != key) { //key already present
	return;
	}
	head = head.next;
	}
	// Insert key in chain
	size++;
	head = bucketArray[bucketIndex];
	HashIntNode newNode = new HashIntNode(key);
	newNode.next = head;
	bucketArray[bucketIndex] = newNode;
	}
}
