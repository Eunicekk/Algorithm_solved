package softeer;

import java.util.*;
import java.io.*;

public class Main_성적평가 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] score = new int[4][N];
		int[][] member = new int[4][3001];
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
				score[3][j] += score[i][j];
				member[i][score[i][j]]++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			member[3][score[3][i]]++;
		}
		
		int[][] sum = new int[4][3001];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 3000; j >= 0; j--) {
				if (j == 3000) sum[i][j] = member[i][j];
				else sum[i][j] = sum[i][j+1] + member[i][j];
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				int order;
				
				if (score[i][j] == 3000) order = 1;
				else order = sum[i][score[i][j]+1] + 1;
				
				sb.append(order).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}
