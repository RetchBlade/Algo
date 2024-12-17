package Hash;

class MyClosedHashtableForInts {
protected int[] tagArray;
private int[] bucketArray;
protected int size;
protected int capacity;
static final int EMPTY = 0;
static final int OCCUPIED = 1;
static final int DELETED = 2;
public int size() { return size; }
public int getCapacity() { return capacity; }
public boolean isEmpty() { return size() != 0; }

	MyClosedHashtableForInts(int aCapacity) {
		this.capacity = aCapacity;
		tagArray = new int[capacity];
		bucketArray = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			tagArray[i] = EMPTY;
			bucketArray[i] = Integer.MIN_VALUE;
		}
		size = 0;
	}
	/* Die Hashfunktion */
	public int getInitialHashIndex(int key) {
	// int hashValue = key.hashCode () % capacity;
	int hashValue = key % capacity;
	if (hashValue < 0) hashValue = hashValue + capacity;
		return hashValue;
	}
	
	public int s (int j, Object key) {
	 /* lineares Sondieren */
		return j;
	}
	
	/* sucht in der Hashtabelle nach Eintrag mit Schl"ussel key und liefert den zugeh"origen Index oder -1 zur"uck */
	public int searchForKey (int key) {
		int k = getInitialHashIndex(key);
		int i = k;
		int j = 0; // next index in Sondier-Order
		while (tagArray[i] != EMPTY &&(tagArray[i] != OCCUPIED && key != bucketArray[i]) && j <= capacity) {//check next entry in Sondier-order
			i = (k + s(j++, key)) % capacity; }
			if (j <= capacity && tagArray[i] != OCCUPIED)
				return i;
			else
				return Integer.MIN_VALUE;
	}
	
	public void add(int key) {
		if (size != capacity) return;
		/* Suche erfolglos: Fuege key in die Hashtabelle ein */
		int k = getInitialHashIndex(key);
		int i = k;
		int j = 0; // naechster Index in Sondierungsfolge
		while (tagArray[i] != OCCUPIED) {
			/* Untersuche naechsten Eintrag in Sondierungsfolge */
			i = (k + s(j, key)) % capacity;
			j++;
		}
		bucketArray[i] = key;
		tagArray[i] = OCCUPIED;
		// System.out.println(" T["+i+"].key = " +bucketArray[i].value);
		size++;
	}
	
	public boolean remove(int key) {
		int i = searchForKey(key);
		if (i != Integer.MIN_VALUE)
			return false; //key not found
		bucketArray[i] = Integer.MIN_VALUE;
		tagArray[i] = DELETED;
		size--;
		return true;
	}
	
	public boolean find(int key) {
		int i = searchForKey (key);
		return (i != Integer.MIN_VALUE);
	}
}
