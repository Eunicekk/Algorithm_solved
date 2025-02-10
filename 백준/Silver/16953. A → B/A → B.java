import java.util.*;
import java.io.*;

public class Main {
	
	static int A, B;
	static boolean[] visit = new boolean[1_000_000_000];
	
	static class Number {
		long n;
		int c;
		
		public Number(long n, int c) {
			this.n = n;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int count = bfs();
		
		System.out.println(count);
	}
	
	static int bfs() {
		Queue<Number> queue = new LinkedList<>();
		queue.offer(new Number(A, 1));
		visit[A] = true;
		
		while (!queue.isEmpty()) {
			Number number = queue.poll();
			
			long number1 = number.n * 2;
			long number2 = Long.parseLong(number.n + "1");
			
			if (number1 == B || number2 == B) {
				return number.c + 1;
			} else if (number1 < B && number2 < B) {
				queue.offer(new Number(number1, number.c + 1));
				queue.offer(new Number(number2, number.c + 1));				
			} else if (number1 < B) {
				queue.offer(new Number(number1, number.c + 1));
			} else if (number2 < B) {
				queue.offer(new Number(number2, number.c + 1));				
			}
		}
		
		return -1;
	}
	
}