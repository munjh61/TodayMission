package d0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1218 {
	static String[] stack;
	static int top;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			for (int tc = 1; tc <= 10; tc++) {
				int n = Integer.parseInt(br.readLine());
				stack = br.readLine().split("");
				top = n - 1;
				int result = 1;
				while (!isEmpty()) {
					StringBuilder sb = new StringBuilder();
					String last = pop();
					boolean couple = false;
					compare: while (!isEmpty()) {
						String compareStr = pop();
						switch (compareStr + last) {
						case "()":
						case "{}":
						case "[]":
						case "<>":
							couple = true;
							break compare;
						}
						// 같지 않을경우 sb에 일시적으로 저장
						sb.insert(0, compareStr);
					}
					// sb에 저장한 elem 다시 stack에 넣기
					if (couple) {
						for (String elem : sb.toString().split("")) {
							if (elem != "")
								add(elem);
						}
					} else {
						result = 0;
						break;
					}
				}
				System.out.println("#" + tc + " " + result);
			} // testcase }
		} catch (IOException e) {

		}
	} // main }

	static boolean isEmpty() {
		return top == -1;
	}

	static boolean isFull() {
		return top == stack.length - 1;
	}

	static boolean add(String str) {
		if (isFull())
			return false;
		stack[++top] = str;
		return true;
	}

	static String pop() {
		if (isEmpty())
			return null;
		String tmp = stack[top];
		stack[top--] = null;
		return tmp;
	}

}
