package Arrays;

public class G6_MaxChunkToSortArray {

/*	1. Given an array arr that is a permutation of [0, 1, ..., arr.length - 1].
	2. We split the array into some number of "chunks" (partitions), and individually sort each chunk. 
	3. Shuffling of chunk is not allowed.
	4. After concatenating them, the result equals the sorted array.
	5. What is the most number of chunks we could have made?*/
			
	public static void main(String[] args) {
        
		int arr[]= {2, 0, 1 ,3, 5, 4};

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
	
	 public static int maxChunksToSorted(int[] a) {
	        int max=0;
	        int count=0;
	        
	        int n=a.length;
	        
	        for(int i=0;i<n;i++){
	            max=Math.max(max,a[i]);
	            if(i==max){
	                count++;
	            }
	        }
	        return count;
	    }
}
