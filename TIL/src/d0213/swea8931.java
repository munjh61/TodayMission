package d0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea8931 {
	static int[] stack;
	static int top;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				int K = Integer.parseInt(br.readLine());
				stack = new int[K]; // stack 초기화
				top = -1; // top 초기화
				for (int i = 0; i < K; i++) { // 재현이 말하는거 듣기
					int jaehyun = Integer.parseInt(br.readLine());
					if (jaehyun != 0) //추가
						add(jaehyun);
					else //삭제
						pop();
				}
				//합구하기
				int sum = 0;
				for(int money: stack) {
					sum += money;
				}
				System.out.println("#"+tc+" "+sum);
			} // testcase }
		} catch (IOException e) {

		}
	} // main }

	static boolean isFull() {
		return stack.length - 1 == top;
	}

	static boolean isEmpty() {
		return top == -1;
	}

	static boolean add(int value) {
		if (isFull())
			return false;
		stack[++top] = value;
		return true;
	}

	static Integer pop() {
		if (isEmpty())
			return null;
		int num = stack[top];
		stack[top--] = 0;
		return num;
	}

	static Integer peek() {
		if (isEmpty())
			return null;
		return stack[top];
	}

	static int size() {
		return top + 1;
	}
}
