import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] room;
	static int count = 1;
	static int direction;
	
	static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int[] dc = {0, 1, 0, -1};
	
	static class Robot {
		int r;
		int c;
		int d;
		
		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(robot.r, robot.c, robot.d);
		System.out.println(count);
	}
	
	static void dfs (int r, int c, int direction) {
		room[r][c] = -1;
			
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int nr = r + dr[direction];
			int nc = c + dc[direction];
			
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] == 0) {
				count++;
				dfs(nr, nc, direction);
				return;
			}
		}
			
		int back = (direction + 2) % 4;
		int wr = r + dr[back];
		int wc = c + dc[back];
		
		if (wr >= 0 && wc >= 0 && wr < N && wc < M && room[wr][wc] != 1) {
			dfs(wr, wc, direction);
		}
	}
}