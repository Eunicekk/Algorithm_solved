import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] room;
	static int count;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Robot{
		int r;
		int c;
		int di;
		
		public Robot (int r, int c, int di) {
			this.r = r;
			this.c = c;
			this.di = di;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int robot_r = Integer.parseInt(st.nextToken());
		int robot_c = Integer.parseInt(st.nextToken());
		int robot_di = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(robot_r, robot_c, robot_di);
		
		System.out.println(count);
	}
	
	static void bfs(int r, int c, int di) {
		Queue<Robot> queue = new LinkedList<>();
		queue.offer(new Robot(r, c, di));
		if (room[r][c] == 0) {
			room[r][c] = 2;
			count++;
		}

		while (!queue.isEmpty()) {
			Robot robot = queue.poll();
			boolean move = false;
			int nr, nc;
			
			for (int d = 0; d < 4; d++) {
				int index = (robot.di + 3 - d) % 4;
				if (index < 0) index += 4;
				
				nr = robot.r + dr[index];
				nc = robot.c + dc[index];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] == 0) {
					queue.offer(new Robot(nr, nc, index));
					room[nr][nc] = 2;
					count++;
					move = true;
					break;
				}
			}

			if (!move) {
				nr = robot.r - dr[robot.di];
				nc = robot.c - dc[robot.di];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || room[nr][nc] == 1) {
					return;
				}
				
				queue.offer(new Robot(nr, nc, robot.di));
			}
		}
	}
	
}