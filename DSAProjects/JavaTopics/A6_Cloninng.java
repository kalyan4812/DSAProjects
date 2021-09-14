package JavaTopics;

public class A6_Cloninng {

	
	// the process of creating exact duplicate object.
	// to maintain data copy of object,to preserve state of object.
	
	
	// shallow cloning.
	public static void main(String...strings) throws CloneNotSupportedException {
		Cat c=new Cat(20);
		Dog d1=new Dog(c,10);
		System.out.println(d1.i+"  "+d1.c.j); // 10 20
		Dog d2=(Dog)d1.clone();
		d2.i=100;
		d2.c.j=120;
		System.out.println(d1.i+"  "+d1.c.j);// 10 120
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
			
			return super.clone();
		}
		
	}
}
