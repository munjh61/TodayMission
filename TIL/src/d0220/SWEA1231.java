package d0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1231 {
	static int[][] tree;
	static String[] words;
	static String text;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[N + 1][3]; // tree 선언
			words = new String[N + 1]; // 번호에 해당하는 글자 배열 선언
			text = "#" + tc + " "; // text 초기화
			for (int i = 0; i < N; i++) {
				// input
				String[] strArr = br.readLine().split(" ");
				int idx = Integer.parseInt(strArr[0]);
				// 번호에 해당하는 글자 저장
				String word = strArr[1];
				words[idx] = word;
				// 번호에 자식 노드 저장
				// 왼쪽 자식
				if (strArr.length >= 3) {
					int c1 = Integer.parseInt(strArr[2]);
					tree[idx][0] = c1;
					tree[c1][2] = idx;
				}
				// 오른쪽 자식
				if (strArr.length == 4) {
					int c2 = Integer.parseInt(strArr[3]);
					tree[idx][1] = c2;
					tree[c2][2] = idx;
				}

			}
			read(1);
			if (sb.length() != 0)
				sb.append("\n");
			sb.append(text);

		} // tc }
		System.out.println(sb.toString());
		br.close();
	} // main }

	// 중위 순회
	static void read(int idx) {
		if (tree[idx][0] != 0)
			read(tree[idx][0]);
		text += words[idx];
		if (tree[idx][1] != 0)
			read(tree[idx][1]);
	}
}
