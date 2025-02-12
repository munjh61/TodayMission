package d0212_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q줄기세포 {
	

	public static void main(String[] args) {

		// int[2] : x,y , int[2] : int[생명력,생성된시간]
		// 비활성 상태 = 생성된 시간 < time < 생성된 시간 + 생명력
		// 활성 상태 = 생성된 시간 + 생명력 < time < 생성된 시간 + 2* 생명력
		// 죽는 상태 = 2*생명력+생성된시간 < time
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			Map<String, int[]> map = new HashMap<>();
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				String[] str = br.readLine().split(" ");
				int N = Integer.parseInt(str[0]);
				int M = Integer.parseInt(str[1]);
				int K = Integer.parseInt(str[2]);
				// 기본 배양
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int j = 0; j < M; j++) {
						if (st.hasMoreTokens()) {
							int[] property = new int[2];
							property[0] = Integer.parseInt(st.nextToken());
							map.put(i + "X" + j, property);
						}
					}
				}

				// 시작!
				int time = 1;
				while (time <= K) {
					Map<String, int[]> instancemap = new HashMap<>();
					for (String key : map.keySet()) {
						int[] prop = map.get(key);
						if (time > prop[0] + prop[1] && time <= 2 * prop[0] + prop[1]) {
							String[] xy = key.split("X");
							int x = Integer.parseInt(xy[0]);
							int y = Integer.parseInt(xy[1]);
							// 위
							nextmove(x - 1, y, prop[0], time, instancemap,map);
							// 아래
							nextmove(x + 1, y, prop[0], time, instancemap,map);
							// 좌
							nextmove(x, y - 1, prop[0], time, instancemap,map);
							// 우
							nextmove(x, y + 1, prop[0], time, instancemap,map);
						}
					}
					for(String key : instancemap.keySet()) {
						map.put(key, instancemap.get(key));
					}
					time++;
				}
				int cnt = 0;
				for (String key : map.keySet()) {
					int[] prop = map.get(key);
					if (time >= prop[1] && time <= 2 * prop[0] + prop[1]) {
						cnt++;
					}
				}

				System.out.println("#" + tc + " " + cnt);
			} // testcase }

		} catch (IOException e) {

		}

	} // main }

	static void nextmove(int x, int y, int life, int time, Map<String, int[]> instancemap, Map<String, int[]> map) {
		instancemap.put(x + "X" + y, map.getOrDefault(x + "X" + y, new int[] { life, time }));
	}
}
