package d0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1232 {
	static int[][] tree;
	static int[] number;
	static String[] operator;
	static int result;
	static String line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			// ---- static 변수 선언, 초기화 ----
			tree = new int[N + 1][3]; // [왼쪽자식][오른쪽자식][부모]
			number = new int[N + 1];
			operator = new String[N + 1];
			result = 0;

			for (int i = 0; i < N; i++) {
				String[] strArr = br.readLine().split(" ");

				// 첫번째 인자 : 인덱스
				int idx = Integer.parseInt(strArr[0]);
				// 두번째 인자 : 노드 값. 숫자일 수도 있고 연산자일 수도 있음
				switch (strArr[1]) {
				case "+":
					operator[idx] = "+";
					break;
				case "-":
					operator[idx] = "-";
					break;
				case "*":
					operator[idx] = "*";
					break;
				case "/":
					operator[idx] = "/";
					break;
				default:
					number[idx] = Integer.parseInt(strArr[1]);
				}
				// 세번째, 네번째 인자 : 자식 노드
				if (strArr.length >= 3) {
					tree[idx][0] = Integer.parseInt(strArr[2]);
				}
				if (strArr.length == 4) {
					tree[idx][1] = Integer.parseInt(strArr[3]);
				}
			}
			// ---- static 변수 선언, 초기화 종료 ----

			// ---- 연산 시작----
			// 만약에 노드에 자식이 있다면 걔는 숫자가 아니다. 연산자이다.
			// 연산자 아래에 있는 아래 자식들이 숫자여야한다.
			// 즉 후위 순회이여야한다.

			// root는 1로 고정이다.
			calc(1);

			System.out.println("#"+tc+" "+number[1]);

		} // tc }

		br.close();
	} // main }

	// 후위 순회
	static void calc(int idx) {
		int left = tree[idx][0];
		if (left != 0) {
			calc(left);
		}
		int right = tree[idx][1];
		if (right != 0) {
			calc(right);
		}

		if (left != 0 && right != 0) { // 제일 아래 있는 애들은 숫자이면서, 자식이 없다.
			switch (operator[idx]) {
			case "+":
				number[idx] = number[left] + number[right];
				break;
			case "-":
				number[idx] = number[left] - number[right];
				break;
			case "*":
				number[idx] = number[left] * number[right];
				break;
			case "/":
				number[idx] = number[left] / number[right];
				break;
			}
		} // 새로운 number[idx] 계산 종료

	}

}
