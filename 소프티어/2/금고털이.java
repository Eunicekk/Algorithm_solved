package softeer;

import java.util.*;
import java.io.*;

public class Main_금고털이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] items = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(items, (a, b) -> {
			return Integer.compare(b[1], a[1]);
		});
		
		int total = 0;
		
		for (int[] item : items) {
			int weight = item[0];
			int value = item[1];
			
			if (W >= weight) {
				total += weight * value;
				W -= weight;
			} else {
				total += W * value;
				break;
			}
		}
		
		System.out.println(total);
	}
	
}
