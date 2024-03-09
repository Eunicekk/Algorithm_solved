import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 카드 2
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int index = 1;
		while (queue.size() != 1) {
			
			if (index % 2 == 1) {
				queue.poll();
			} else {
				int num = queue.poll();
				queue.add(num);
			}
			
			index++;
		}
		
		bw.write(queue.peek() + "");
		bw.close();
	}
	
}