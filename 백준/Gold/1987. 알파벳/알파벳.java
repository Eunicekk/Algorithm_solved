import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 알파벳
public class Main {
	
	static int R;
	static int C;
	static char[][] board;
	static List<Character> list = new ArrayList<>();
	static int size = 1;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		list.add(board[0][0]);
		dfs(0, 0);
		System.out.println(size);
	}
	
	static void dfs (int r, int c) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
				if (!list.contains(board[nr][nc])) {
					list.add(board[nr][nc]);
					dfs(nr, nc);
					size = Math.max(size, list.size());
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
