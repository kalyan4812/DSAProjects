package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A6_SortAnArrayUsingRecursion {

	public static void main(String... strings) {

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 5; i >= 0; i--) {
			al.add(i);
		}

		System.out.println(al);

		sort(al);

		System.out.println(al);

	}

	private static void sort(ArrayList<Integer> al) {

		int n = al.size();
		if (n == 1)
			return;

		int temp = al.get(al.size()-1);
		al.remove(al.size()-1);

		sort(al);

		insert(al, temp); // insert removed element at correct position.

	}

	private static void insert(ArrayList<Integer> al, int temp) {

		if (al.size() == 0 || al.get(al.size() - 1) <= temp) {
			al.add(temp);
			return;
		}
		int val = al.get(al.size() - 1);
		al.remove(al.size() - 1);

		insert(al, temp);

		al.add(val);
	}

}
