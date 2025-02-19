package d0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class SWEA1230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			// 암호문 개수 input
			int N = Integer.parseInt(br.readLine());
			// 암호문 뭉치 input
			String[] text = br.readLine().split(" ");
			LinkedList<String> list = new LinkedList<>(Arrays.asList(text)); // 암호문을 list로 변경
			// 명렁어 개수 input
			int M = Integer.parseInt(br.readLine());
			// 명령어 input
			String[] cmds = br.readLine().split(" ");

			int idx = 0;
			int loc;
			int cnt = 0;
			for (int cmd = 0; cmd < M; cmd++) {
				String type = cmds[idx];
				switch (type) {
				case "I":
					loc = Integer.parseInt(cmds[idx + 1]);
					cnt = Integer.parseInt(cmds[idx + 2]);
					for (int i = 0; i < cnt; i++) {
						list.add(loc+i, cmds[idx + 3 + i]);
					}
					idx += 3 + cnt;
					break;
				case "D":
					loc = Integer.parseInt(cmds[idx + 1]);
					cnt = Integer.parseInt(cmds[idx + 2]);
					for (int i = 0; i < cnt; i++) {
						list.remove(loc);
					}
					idx += 3;
					break;
				case "A":
					cnt = Integer.parseInt(cmds[idx + 1]);
					for (int i = 0; i < cnt; i++) {
						list.add(cmds[idx + 2 + i]);
					}
					idx += 2 + cnt;
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			System.out.println(sb.toString().trim());
		} // tc }

		br.close();
	}

}
