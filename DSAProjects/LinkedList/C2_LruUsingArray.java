package LinkedList;

public class C2_LruUsingArray {

	static int size;
	static int[] arr;

	public C2_LruUsingArray(int capacity) {
		arr = new int[capacity];
		size = capacity;

	}

	public static void main(String[] args) {

		C2_LruUsingArray l = new C2_LruUsingArray(4);
		l.get(10);
		l.print(arr);
		l.get(20);
		l.print(arr);
		l.get(10);
		l.print(arr);
		l.get(30);
		l.print(arr);
		l.get(40);
		l.print(arr);
		l.get(50);
		l.print(arr);
		l.get(30);
		l.print(arr);
		l.get(40);
		l.print(arr);
		l.get(60);
		l.print(arr);
		l.get(30);
		l.print(arr);
	}
	


	//O(N)
	public void get(int x) {
		int i = C2_LruUsingArray.search(arr, x); //o(p)

		if (i > 0) { // element already there. so delete it and increase array size.
			deleteElement(i);
		}
		if (size == 0) { // when array is full of size remove last name i.e not recently used.
			deleteLastElement(x);
			return;
		}
		size = size - 1;
		arr[size] = x;

	}

	private void deleteLastElement(int x) {
		int r = arr.length - 1;
		while (r >= 1) {
			arr[r] = arr[r - 1];
			r--;
		}
		arr[0] = x;
	}

	private void deleteElement(int i) {
		while (i > size) {
			arr[i] = arr[i - 1];
			i--;
		}
		size++;
	}

	public static int search(int arr[], int x) {
		for (int i = arr.length - 1; i >= size; i--) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public void print(int arr[]) {
		for (int i = size; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
