package Arrays;


public class LeadersInArray {

	public static void main(String...strings) {
		int a[]= {7,10,4,3,6,5,2};
		printLeaders(a);
		System.out.println();
		printLeadersOtherWay(a);
	}

	// O(n)+space=t(n)
	private static void printLeadersOtherWay(int[] a) {
		int[] temp=new int[a.length];
		int leader=a[a.length-1];
		temp[0]=leader;
		int count=1;
		for(int i=a.length-2;i>=0;i--) {
			
			if(a[i]>leader) {
				
				leader=a[i];
				temp[count]=a[i];
				count++;
			}
		}
		for(int i=count-1;i>=0;i--) {
			System.out.print(temp[i]+"  ");
		}
		
		
	}


	//O(n2)
	private static void printLeaders(int[] a) {
		for(int i=0;i<a.length;i++) {
			boolean leader=true;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]>a[i]) {
					leader=false;
					break;
				}
			}
			if(leader) {
				System.out.print(a[i]+"  ");
			}
		}
		
	}
	
	
	
}
