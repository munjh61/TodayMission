package d0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA1224 {
	public static void main(String[] args) {
		// 후위 표기식으로 변경
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			for (int tc = 1; tc <= 10; tc++) {
				int testcaselength = Integer.parseInt(br.readLine()); // 길이
				String line = br.readLine(); // 문자열
				Stack<Character> op = new Stack<>(); // 연산자 저장
				StringBuilder postfix = new StringBuilder(); // 후입 표기법 저장
				for (int i = 0; i < testcaselength; i++) {
					char ch = line.charAt(i);
					switch (ch) {
					case '(':
						op.push(ch);
						break;
					case ')':
						while (op.peek() != '(') { // 짝궁 소괄호 찾기
							postfix.append(op.pop());
						}
						op.pop(); // 짝꿍 소괄호 버리기
						break;
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						postfix.append(ch);
						break;
					default:
						if (op.isEmpty()) {
							op.push(ch);
						} else {
							while (priority.get(op.peek()) >= priority.get(ch) && !op.isEmpty()) {
								postfix.append(op.pop());
							}
							op.push(ch);
						}
					}
				}
				while (!op.isEmpty()) {
					postfix.append(op.pop());
				}

				// 계산
				Stack<Integer> calc = new Stack<>();
				for (int i = 0; i < postfix.length(); i++) {
					char c = postfix.charAt(i);
					if (c >= '0' && c <= '9') {
						calc.push(c - '0');
					} else {
						int B = calc.pop();
						int A = calc.pop();
						switch (c) {
						case '+':
							calc.push(A + B);
							break;
						case '-':
							calc.push(A - B);
							break;
						case '*':
							calc.push(A * B);
							break;
						case '/':
							calc.push(A / B);
							break;
						}
					}
				} //계산 종료

				System.out.println("#" + tc + " " + calc.pop());
			} // testcase }
		} catch (IOException e) {

		}
	} // main }
}
