package Hashing;

public class A2_LinearProbing {

	// constants to identify state of slot in the table.
	private static int EMPTY_VALUE = 0;
	private static int DELETED_VALUE = 1;
	private static int FILLED_VALUE = 2;

	private int tableSize;
	int[] arr;
	int[] flag;

	public A2_LinearProbing(int size) {
		tableSize = size;
		arr = new int[size + 1];
		flag = new int[size + 1];
	}

	private int getHash(int key) {
		return key % tableSize;
	}

	private int resolver(int index) {
		return index;
	}

	// O(tableSize)
	public boolean add(int value) {
		int key = getHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (flag[key] == EMPTY_VALUE || flag[key] == DELETED_VALUE) {
				arr[key] = value;
				flag[key] = FILLED_VALUE;
				return true;
			}
			key = key + resolver(i);
			key = key % tableSize;
		}
		return false;
	}

	// O(tableSize)
	public boolean find(int value) {
		int key = getHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (flag[key] == EMPTY_VALUE) {

				return false;
			}
			if (flag[key] == FILLED_VALUE && arr[key] == value) {
				return true;
			}

			key = key + resolver(i);
			key = key % tableSize;
		}
		return false;
	}

	// O(tableSize)
	public boolean remove(int value) {
		int key = getHash(value);
		for (int i = 0; i < tableSize; i++) {
			if (flag[key] == EMPTY_VALUE) {

				return false;
			}
			if (flag[key] == FILLED_VALUE && arr[key] == value) {

				flag[key] = DELETED_VALUE;
				return true;
			}

			key = key + resolver(i);
			key = key % tableSize;
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < tableSize; i++) {

			if (flag[i] == FILLED_VALUE) {
				System.out.println("Value at index " + i + " is " + arr[i]);

			}

		}
		System.out.println();
	}

	public static void main(String... strings) {
		A2_LinearProbing ht = new A2_LinearProbing(17);
		for (int i = 20; i < 40; i++) {
			ht.add(i);
		}
		ht.print();

		System.out.println((ht.find(30) == true) ? "Found value " : "Value not found");

		ht.remove(30);

		System.out.println((ht.find(30) == true) ? "Found value " : "Value not found");

	}

	/*
	 * Disadvantage :Clustering ,that is occupation of elements in consecutive index
	 * ,elements one after another.problem with this is when you want to add a new
	 * element ,if there is a collision you have to go through many non empty index
	 * to find a empty slot. So it is time consuming to insert a new
	 * element.Solution is quadratic probing.
	 * 
	 * 	Advantage:Cache friendly.
	 * 
	 * Requirments:size>=no of keys to be inserted.
	 */

	/*
	 * Quadratic probing is same as this ,except resolver function private int
	 * resolver(int index) { return index*index; }
	 * 
	 * Disadvantage of quadratic probing is Secondary clusters ,i.e unable to add a element in hashtable because index calculated by this approach
	 * is never empty.But there still exists empty spaces in the table .
	 * why only i^2,why not i^3/i^4 ,i think if power is greater you will encounter a secondary cluster faster.
	 * 
	 * 
	 * Requirements: size of table>=2*no of keys to be inserted to avoid clustering. and size should be prime.
	 */
	
	/*  Double Hashing is also same,resolver function is
	 * resolver(int index) { return index*getSecondHash(key); }
	 * secondHash(int key){ return 6-key%6; } // second hash should never be zero,if zero we will hit same slot again and again,this function wont be zero.
	 * thats why we are subtracting to get values from 1 to 6.
	 * 
	 * Requirement:To find free slot every time secondHash and table size should be relatively prime.
	 * Advantages:no clusters,less collisions better than linear ,quadratic probing.
	 */
	
	/*
	 * Rehashing: if lambda(l)=no of keys/table size ,if l>1 then we need to increase table size to n' ,n' is cloest prime near to 2*n.
	 * Modify hash function to x mod n' ,then reallocate keys acc to new hash function.
	 */
}
