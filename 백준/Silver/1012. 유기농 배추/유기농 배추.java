import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class Main {
	
	static int N;
	static int M;
	static int[][] field;
	static boolean[][] visit;
	static int count;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치 개수
			
			field = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				field[B][A] = 1;
			}
			
			visit = new boolean [N][M];
			count = 0;
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && field[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			sb.append(count + "\n");
		} // tc
		
		System.out.print(sb);
	}
	
	static void bfs (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && field[nr][nc] == 1 && visit[nr][nc] == false) {
					queue.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
