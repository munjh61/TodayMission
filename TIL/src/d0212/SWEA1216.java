package d0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA1216 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int tc = 1; tc <= 10; tc++) {
				tc = Integer.parseInt(br.readLine());
				// 글자판 저장
				String[][] table = new String[100][100];
				for (int i = 0; i < 100; i++) {
					table[i] = br.readLine().split("");
				}
				int max = 1;
				// 가로
				for (int row = 0; row < 100; row++) {
					for (int col = 0; col < 100; col++) {
						List<Integer> indexes = new ArrayList<>();
						for (int j = col; j < 100; j++) {
							// 행마다 시작 문자와 같은 문자인 위치 저장
							if (table[row][j].equals(table[row][col])) {
								indexes.add(j);
							}
						}
						// 그 문자들마다 회문인지 검사
						for (int elem : indexes) {
							int middle = (elem - col) / 2;
							boolean isOk = true;
							for (int k = 0; k <= middle; k++) {
								if (!table[row][col + k].equals(table[row][elem - k])) { // 회문 아니면 탈출
									isOk = false;
									break;
								}
							}
							if (isOk) {
								int length = elem - col + 1;
								max = max < length ? length : max;
							}
						} // 검사 }
					}
				}
				// 세로
				for (int col = 0; col < 100; col++) {
					for (int row = 0; row < 100; row++) {
						List<Integer> indexes = new ArrayList<>();
						for (int i = row; i < 100; i++) {
							// 행마다 시작 문자와 같은 문자인 위치 저장
							if (table[i][col].equals(table[row][col])) {
								indexes.add(i);
							}
						}
						// 그 문자들마다 회문인지 검사
						for (int elem : indexes) {
							int middle = (elem - row) / 2;
							boolean isOk = true;
							for (int k = 0; k <= middle; k++) {
								if (!table[row + k][col].equals(table[elem - k][col])) { // 회문 아니면 탈출
									isOk = false;
									break;
								}
							}
							if (isOk) {
								int length = elem - row + 1;
								max = max < length ? length : max;
							}
						} // 검사 }
					}
				}
				System.out.println("#" + tc + " " + max);

			} // testcase }

		} catch (IOException e) {

		}
	} // main }
}
