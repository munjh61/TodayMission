package d0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		br.close();

		double A = Double.parseDouble(line[0]);
		double B = Double.parseDouble(line[1]);
		double V = Double.parseDouble(line[2]);

		// 도착 못했을 경우 하루에 B - A 만큼 올라간다.
		// 오늘 시작하는 지점이 V - A 이상이라면 도착한다.
		// 즉 (V - A) / (A - B) 하고 소수점 올림한 값 + 하루하면 도착한다.

		System.out.println((int)Math.ceil((V - A) / (A - B)) + 1);
	}

}
