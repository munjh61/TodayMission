package d0214;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String line = sc.next();

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < line.length(); i++) { // String을 queue에 char로 저장
				char c = line.charAt(i);
				if (c >= '0' && c <= '9') {
					queue.add(c - '0');
				} else { // A ~ F는 10 ~ 15이다
					queue.add(c - 'A' + 10);
				}
			}
			// System.out.println("que : "+queue);
			int teamNum = N / 4; // 한 변에 있는 char 개수
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < teamNum; i++) { // 한 변의 숫자 개수만큼 회전 할 수 있다.
				int[] teams = new int[4];
				for (int j = 0; j < 4; j++) {
					for (int k = teamNum - 1; k >= 0; k--) { // 각 변마다 숫자 계산
						teams[j] += queue.peek() * Math.pow(16, k);
						queue.add(queue.poll());
					}
					set.add(teams[j]);
				}
				queue.add(queue.poll());
			} // 한 변의 숫자 개수만큼 반복한다.

			List<Integer> list = new LinkedList<>();
			for (int i : set) {
				list.add(i);
			}
			Collections.sort(list, Collections.reverseOrder());
			// System.out.println(list);
			System.out.println("#" + tc + " " + list.get(K - 1));
		} // testcase }
		sc.close();
	} // main }
}
