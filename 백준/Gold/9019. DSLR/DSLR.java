import java.util.*;
import java.io.*;

public class Main {
	
	static int A, B;
	static boolean[] visit = new boolean[10000];
	
	static class Node {
		int number;
		String command;
		
		public Node(int number, String command) {
			this.number = number;
			this.command = command;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs(A, B));
		}
	}
	
	static String bfs(int start, int target) {
		Arrays.fill(visit, false);
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, ""));
		visit[start] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			int number = node.number;
			String command = node.command;
			
			if (number == target) return command;
			
			int d = (number * 2) % 10000;
			if (!visit[d]) {
				visit[d] = true;
				queue.offer(new Node(d, command + "D"));
			}
			
			int s = (number == 0) ? 9999 : number - 1;
			if (!visit[s]) {
				visit[s] = true;
				queue.offer(new Node(s, command + "S"));
			}
			
			int l = (number % 1000) * 10 + number / 1000;
			if (!visit[l]) {
				visit[l] = true;
				queue.offer(new Node(l, command + "L"));
			}
			
			int r = (number % 10) * 1000 + (number / 10); 
			if (!visit[r]) {
				visit[r] = true;
				queue.offer(new Node(r, command + "R"));
			}
		}
		
		return "";
	}
}