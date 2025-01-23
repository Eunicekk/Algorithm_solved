package baekjoon;

import java.util.*;
import java.io.*;

public class Main_나무공격 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int count = 0;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == 1) count++;
			}
		}
		
		int kill = 0;
		
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			for (int r = L-1; r < R; r++) {
				for (int c = 0; c < M; c++) {
					if (board[r][c] == 1) {
						board[r][c] = 0;
						kill++;
						break;
					}
				}
			}
		}
		
		System.out.println(count - kill);
	}
	
}
