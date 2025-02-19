package d0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= testcase ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String[] strArr = br.readLine().split(" ");
			
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}
			
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(int elem : arr) {
				sb.append(elem+" ");
			}
			
			System.out.println("#"+tc+" "+sb.toString().trim());
		}
		br.close();
	}
}
