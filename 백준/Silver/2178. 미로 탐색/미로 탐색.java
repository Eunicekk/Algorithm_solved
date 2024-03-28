import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 찾기
public class Main {
	
	static int N;
	static int M;
	static int[][] miro;
	static boolean[][] visited;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		miro = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = temp.charAt(j) - '0';
			}
		}
		
		visited[0][0] = true;
		bfs(0, 0);
		
		System.out.println(miro[N-1][M-1]);
	}
	
	static void bfs (int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(r, c));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && miro[nr][nc] != 0 && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
					miro[nr][nc] = miro[point.r][point.c] + 1;
				}
			}
			
		}
	}
}