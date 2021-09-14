package JavaTopics;

import JavaTopics.A6_Cloninng.Cat;
import JavaTopics.A6_Cloninng.Dog;

public class A7_DeepCloning {

	public static void main(String...strings) throws CloneNotSupportedException {
		Cat c=new Cat(20);
		Dog d1=new Dog(c,10);
		System.out.println(d1.i+"  "+d1.c.j); // 10 20
		Dog d2=(Dog)d1.clone();
		d2.i=100;
		d2.c.j=120;
		System.out.println(d1.i+"  "+d1.c.j);// 10 20
	}
	
	static class Cat{
		int j;
		Cat(int j){
			this.j=j;
		}
	}
	
	static class Dog implements Cloneable{
		
		Cat c;
		int i;
		Dog(Cat c,int i){
			this.c=c;
			this.i=i;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Cat c1=new Cat(c.j);
			Dog d=new Dog(c1,i);
			return d;
		}
		
	}
}
