package DynamicProgramming;

import java.util.Arrays;

public class E5_EggDropping {

	public static void main(String...strings) {
		int eggs=3;
		int floors=5;
		
		// minimum trials to find floor ,from which egg can break.
		
		int f=recursiveSol(eggs,floors);
		System.out.println(f);
		
		db=new int[eggs+1][floors+1];
		for(int x[]:db) {
			Arrays.fill(x,-1);
		}
		int g=memeSol(eggs,floors);
		System.out.println(g);
	}

	static int db[][];
	private static int memeSol(int e, int f) {
		if(e==1) {
			return f;
		}
		if(f<=1) {
			return f;
		}
		if(db[e][f]!=-1) {
			return db[e][f];
		}
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int tempans=Math.max((db[e-1][k-1]!=-1)?db[e-1][k-1]:memeSol(e-1,k-1),(db[e][f-k]!=-1)?db[e][f-k]:memeSol(e,f-k))+1; //asked for  worst case so.
			min=Math.min(tempans, min);
			db[e][f]=min;
		}
		return db[e][f];
	}

	private static int recursiveSol(int e, int f) {
		if(e==1) {
			return f;
		}
		if(f<=1) {
			return f;
		}
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int tempans=Math.max(recursiveSol(e-1,k-1),recursiveSol(e,f-k))+1; //asked for  worst case so.
			min=Math.min(tempans, min);
		}
		return min;
	}
}
