package JavaTopics;

public class A1_JavaBasic1 {

	static {
		A a = new A();
		a.main("kkkkk");
	}

	public static void main(String... strings) {

	}

}

class A {
	public static void main(String... strings) {
		System.out.println("class a");
	}
}

class C {

}
// note a java program can contain an number of classes,but it can contain only at most one public class,and that public class
// should be name of .java file name.

// if there is no public class in the program,we can give any name to .java file,it will compile fine,but if you run it ,it will
// give run time error saying there is no .class file available with given name. 

// in this case three .class file/byte code files will be generated named A1_JavaBasic1.class,A.class,C.class.

// if you run a class without main method, it will give a error.

// and there is no relation between the class which contains main method and the name of .java file name.

// implicit import java.util.*; ,explicit import java.util.ArrayList;

// java.lang ,default package-current working directory  ,import statement is not required they are done automatically.

// if you want to import a package,all classes,interfaces present in that package are available,but not the ones which are in the 
// sub packages.

// package is an encapsulation mechanism to group related classes,interfaces into single unit.there by modularity(the degree to which a system's components may be separated 
//and recombined),maintaining is easy.

// package resolves naming conflicts ,like you can have same class name in two different packages.
// package also provides security ,if a class is default it can be accessed within the package only.
// inside a java program at most one package statement is allowed.
// the first non comment statement should be package name,if you take import before package it will give compile time error.

//class level modifiers-public,abstract-restrict object creation,final-restrict inheritance,default,strict fp-floating point.
// inner class can have other than above -private,protected,static.

// public -global level,can be accessed anywhere.if member of a class is public but if class is not public there is no use.
// Default-within current package.
//private-class level
// recommended modifier for variables is private,for methods is public.
//protected-within package,outside package only within child classes and only with child class reference.

//abstract(not complete)-applicable for methods,classes.
//abstract method-only declaration no implementation.
//if a class contains at least one abstract method ,class should be abstract because if its not abstract if anyone tries to call 
//abstract method there is no implementation.
// abstract class have both abstract and non abstract methods.
// child class has to provide implementation for abstract methods of parent abstract class.other wise you have to make child class
// also abstract.



