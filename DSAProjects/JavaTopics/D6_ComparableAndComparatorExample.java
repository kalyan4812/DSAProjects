package JavaTopics;

import java.util.Comparator;
import java.util.TreeSet;

public class D6_ComparableAndComparatorExample {

	static class Employee implements Comparable {

		

		String name;
		int id;

		Employee(String name, int id) {
			this.name = name;
			this.id = id;

		}

		@Override
		public String toString() {
			
			return name+"____"+id;
		}

		
		@Override
		public int compareTo(Object o) {
			int id1 = this.id;
			Employee e = (Employee) o;
			int id2 = e.id;

			return id1 - id2;
		}

	}
	
	public static void main(String...strings) {
		Employee e1=new Employee("A",1);
		Employee e2=new Employee("C",6);
		Employee e3=new Employee("B",2);
		
		TreeSet ts=new TreeSet();
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		
		System.out.println(ts); // [A____1, B____2, C____6]
		
		
		
		TreeSet ts2=new TreeSet(new MyComparator());
		ts2.add(e1);
		ts2.add(e2);
		ts2.add(e3);
		
		System.out.println(ts2); // [A____1, B____2, C____6]
		

	}
	
	static class MyComparator  implements Comparator<Employee>{

		@Override
		public int compare(Employee e1, Employee e2) {
		
			return e1.id-e2.id;
		}

	}
}
