package d0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA2930 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}

		});

		for (int tc = 1; tc <= T; tc++) { // tc 시작
			pq.clear(); // pq 비우기
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				if (line.length == 2) { // 삽입하는 경우
					pq.add(Integer.parseInt(line[1]));
				} else { // 삭제하는 경우
					if (pq.size() != 0) // 크기가 0이 아니면 삭제할 게 있음
						sb.append(pq.poll() + " ");
					else // 삭제할 게 없음
						sb.append("-1 ");
				}
			}
			System.out.println("#" + tc + " " + sb.toString());

		} // tc }
		br.close();
	} // main }
	
}