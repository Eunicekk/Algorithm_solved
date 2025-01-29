import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] board;
	static boolean[][] visit;
	static int max;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visit[r][c] = true;
				dfs(r, c, 1, board[r][c]);
				visit[r][c] = false;
				check(r, c);
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr, nc, depth + 1, sum + board[nr][nc]);
				visit[nr][nc] = false;
			}
		}
	}
	
	static void check(int r, int c) {
		int sum = 0;
		
		// ㅜ
		if (r >= 0 && r + 1 < N && c - 1 >= 0 && c + 1 < M) {
			sum = board[r][c] + board[r+1][c] + board[r][c-1] + board[r][c+1];
			max = Math.max(max, sum);
		}
		
		// ㅏ
		if (r - 1 >= 0 && r + 1 < N && c >= 0 && c + 1 < M) {
			sum = board[r][c] + board[r-1][c] + board[r+1][c] + board[r][c+1];
			max = Math.max(max, sum);
		}
		
		// ㅗ
		if (r - 1 >= 0 && r < N && c - 1 >= 0 && c + 1 < M) {
			sum = board[r][c] + board[r-1][c] + board[r][c-1] + board[r][c+1];
			max = Math.max(max, sum);
		}
		
		// ㅓ
		if (r - 1 >= 0 && r + 1 < N && c - 1 >= 0 && c < M) {
			sum = board[r][c] + board[r-1][c] + board[r+1][c] + board[r][c-1];
			max = Math.max(max, sum);
		}
	}
	
}