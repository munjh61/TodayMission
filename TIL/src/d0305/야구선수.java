package d0305;

import java.util.Scanner;

public class 야구선수 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        StringBuilder sb;
	        int T = sc.nextInt();

	    for(int tc=1; tc<=T; tc++) {
	        sb = new StringBuilder();
	        sb.append("#").append(tc).append(" ");

	        int n = sc.nextInt();
	        int k = sc.nextInt();

	        int[] arr = new int[1001];

	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;

	        for(int i=0; i<n; i++) {
	            int num = sc.nextInt();

	            if(num < min) {
	                min = num;
	            }
	            if(num > max) {
	                max = num;
	            }
	            arr[num]++;
	        }


	        int sumMax = 0;

	        for(int a=min; a<=max; a++) {
	            int sum = 0;
	            for(int i=0; i<=k; i++) {
	                if(a+i <= 1000) {
	                    sum += arr[a+i];
	                }
	            }
	            if(sum > sumMax) {
	                sumMax = sum;
	            }
	        }

	        sb.append(sumMax);
	        System.out.println(sb);

	    }
	}
}
