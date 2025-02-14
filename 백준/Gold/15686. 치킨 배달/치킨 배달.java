import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] city;
	static ArrayList<Point> homes;
	static ArrayList<Point> chickens;
	static ArrayList<Point> select;
	static int distance;
	
	static int[] dr = {-1, 1, 0, 0};
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
		city = new int[N][N];
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		select = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				city[r][c] = Integer.parseInt(st.nextToken());
				
				if (city[r][c] == 1) homes.add(new Point(r, c));
				else if (city[r][c] == 2) chickens.add(new Point(r, c));
			}
		}
		
		distance = Integer.MAX_VALUE;
		dfs(0);
		
		System.out.println(distance);
	}
	
	static void dfs(int start) {
		if (select.size() == M) {
			int sum = 0;
			
			for (Point home : homes) {
				int min = Integer.MAX_VALUE;
				
				for (Point chicken : select) {
					min = Math.min(min, Math.abs(home.r - chicken.r) + Math.abs(home.c - chicken.c));
				}
				
				sum += min;
			}
			
			distance = Math.min(distance, sum);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			select.add(chickens.get(i));
			dfs(i + 1);
			select.remove(select.size() - 1);
		}
	}
	
}