import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		int[] cards = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		for (int number : cards) {
			sb.append(map.getOrDefault(number, 0)).append(" ");
		}

		System.out.println(sb);
	}
}
