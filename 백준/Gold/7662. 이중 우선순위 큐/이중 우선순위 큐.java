import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			Map<Integer, Integer> count = new HashMap<>();
			
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if (command.equals("I")) {
					pq1.offer(number);
					pq2.offer(number);
					count.put(number, count.getOrDefault(number, 0) + 1);
				} else if (command.equals("D")) {
					if (count.isEmpty()) continue;
					
					if (number == -1) remove(pq1, count);
					else if (number == 1) remove(pq2, count);
				}
			}
			
			if (count.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				int max = remove(pq2, count);
                int min = count.isEmpty() ? max : remove(pq1, count);
				System.out.println(max + " " + min);
			}
		}
	}
	
	static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> count) {
		while (!pq.isEmpty()) {
			int number = pq.poll();
			
			if (count.containsKey(number)) {
				if (count.get(number) == 1) count.remove(number);
				else count.put(number, count.get(number) - 1);
				return number;
			}
		}
		
		return 0;
	}
	
}