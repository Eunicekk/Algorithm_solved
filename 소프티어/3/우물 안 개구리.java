package softeer;

import java.util.*;
import java.io.*;

public class Main_우물안개구리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] weight = new int[N+1];
		boolean[] member = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (weight[a] > weight[b]) {
				member[b] = true;
			} else if (weight[a] < weight[b]) {
				member[a] = true;
			} else {
				member[a] = true;
				member[b] = true;
			}
		}
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			if (!member[i]) count++;
		}
		
		System.out.println(count);
	}
	
}
