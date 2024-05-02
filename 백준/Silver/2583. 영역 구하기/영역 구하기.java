import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int K;
	static int[][] paper;
	static boolean[][] visit;
	static int num;
	static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		paper = new int[M][N];
		visit = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					paper[r][c]++;
				}
			}
		}
		
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (paper[y][x] == 0 && !visit[y][x]) {
					num = 0;
					dfs(y, x);
					if (num != 0) answer.add(num);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");

		Collections.sort(answer);
		for (int i = 0; i < answer.size()-1; i++) {
			sb.append(answer.get(i)).append(" ");
		}
		sb.append(answer.get(answer.size()-1));
		
		System.out.println(sb);
	}
	
	static void dfs(int y, int x) {
        visit[y][x] = true;
        num++;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int d = 0; d < 4; d++) {
            int ny = y + dr[d];
            int nx = x + dc[d];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N && !visit[ny][nx] && paper[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }
	
}
