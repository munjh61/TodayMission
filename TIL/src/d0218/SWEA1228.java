package d0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SWEA1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 크기 input

			// 원본 암호문
			String line = br.readLine(); // 암호문 input
			List<String> list = new LinkedList<>(Arrays.asList(line.split(" ")));
			// 삽입 횟수
			int insert = Integer.parseInt(br.readLine()); // 삽입횟수 input
			line = br.readLine(); // 수정문 input
			String[] strArr = line.split("I ");
			for (int in = 1; in <= insert; in++) {
				String[] prop = strArr[in].split(" ");

				int idx = Integer.parseInt(prop[0]);
				int cnt = Integer.parseInt(prop[1]);

				for (int i = 0; i < cnt; i++) {
					list.add(idx + i, prop[2 + i]);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			System.out.println("#" + tc + " " + sb.toString().trim());

		} // tc }

		br.close();
	} // main }
}
