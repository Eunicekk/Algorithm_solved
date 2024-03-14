import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 큐
public class Main {
	
	static int[] queue;
	static int size = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		queue = new int [N];
		
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			
			if (command.equals("pop")) {
				
				int answer = pop();
				bw.write(answer + "\n");
				
			} else if (command.equals("empty")) {
				
				int answer = empty();
				bw.write(answer + "\n");
				
			} else if (command.equals("size")) {
				
				bw.write(size + "\n");
				
			} else if (command.equals("front")) {
				
				int answer = front();
				bw.write(answer + "\n");
				
			} else if (command.equals("back")) {
				
				int answer = back();
				bw.write(answer + "\n");
				
			} else {
				
				StringTokenizer st = new StringTokenizer(command);
				String push = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				push(num);
				
			}
		}
		
		bw.close();
	}
	
	static void push(int X) {
		queue[size++] = X;
	}
	
	static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int num = queue[0];
			
			for (int i = 1; i < size; i++) {
				queue[i-1] = queue[i];
			}
			
			size--;
			return num;
		}
	}
	
	static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	static int front() {
		if (size == 0) {
			return -1;
		} else {
			return queue[0];
		}
	}
	
	 static int back() {
		 if (size == 0) {
			 return -1;
		 } else {
			 return queue[size - 1];
		 }
	 }
}