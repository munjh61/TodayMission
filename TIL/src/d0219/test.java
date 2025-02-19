package d0219;

import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		list.add(1,999);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}
}
