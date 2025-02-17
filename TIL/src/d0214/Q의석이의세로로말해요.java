package d0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q의석이의세로로말해요 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) { // testcase {
				String[][] arr = new String[5][];
				int maxcol = 0;
				for (int i = 0; i < 5; i++) { // 배열 저장
					arr[i] = br.readLine().split("");
					maxcol = maxcol < arr[i].length ? arr[i].length : maxcol; // 최대 열의 길이 저장
				}

				StringBuilder sb = new StringBuilder();
				for (int col = 0; col < maxcol; col++) {
					for (int row = 0; row < 5; row++) {
						if (arr[row].length > col) //넘어가지 않았다면 예외 발생 안함. sb에 추가
							sb.append(arr[row][col]);
					}
				}
				//출력
				System.out.println("#" + tc + " " + sb.toString());
			} // testcase }

		} catch (IOException e) {
		}
	} // main }
}
