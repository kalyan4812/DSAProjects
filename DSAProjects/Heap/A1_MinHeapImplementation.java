package Heap;

public class A1_MinHeapImplementation {

	// internally heap is an array.
	
	/* EX:
	    10
	  80   15
   100   85   18
	 */
	
    // equivalent array: 10 80 15 100 85 18
	
	int [] arr;
	int size;
	int capacity;
	
	
	public A1_MinHeapImplementation(int capacity) {
		arr=new int[capacity];
		size=0;
		this.capacity=capacity;
	}
	
	int left(int i) {      // i=level  ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2*i+1);
	}
	
	int right(int i) {
		return (2*i+2);
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
}
