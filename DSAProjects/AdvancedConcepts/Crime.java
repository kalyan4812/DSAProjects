package AdvancedConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Crime {

	  public static void main(String...strings) {
		  
		  
		  Scanner sc=new Scanner(System.in);
		  int n=sc.nextInt();
		  int m=sc.nextInt();
		  int k=sc.nextInt();
		  int x=sc.nextInt();
		  
		  String word=sc.next();
		  
		  String pos[]=new String[k];
		  
		 
		  int len=0;
		  for(int i=0;i<k;i++) {
			 pos[i]=sc.next();
			 len=pos[i].length();
			  
		  }
		 
		 
		 
		  
		  int index=word.indexOf("#");
		  
		  StringBuilder sb=new StringBuilder(word);
		  sb.delete(index,index+len);
		  
		  
		  
		  
		  ArrayList<String> ans=new ArrayList<>();
		  
		  
		  
		  String b=sb.toString();
		  
		  for(String s:pos) {
			  
			  sb=new StringBuilder(b);
			  ans.add(sb.insert(index, s).toString());
		  }
		 
		  Collections.sort(ans);
		 
		  
		  System.out.println(ans.get(x-1));
		  
		 
	  }
}
