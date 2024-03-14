import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 스택
public class Main {
	
	static int[] stack;
	static int size = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			
			if (command.equals("pop")) {
				
				int answer = pop();
				bw.write(answer + "\n");
				
			} else if (command.equals("top")) {
				
				int answer = top();
				bw.write(answer + "\n");
				
			} else if (command.equals("size")) {
				
				bw.write(size + "\n");
				
			} else if (command.equals("empty")) {
				
				int answer = empty();
				bw.write(answer + "\n");
				
			} else {
				
				StringTokenizer st = new StringTokenizer(command);
				String push = st.nextToken();
				int X = Integer.parseInt(st.nextToken());
				push(X);
				
			}
			
		}
		
		bw.close();
	}
	
	static void push(int X) {
		stack[size++] = X;
	}
	
	static int pop() {
		if (size > 0) {
			return stack[--size];			
		} else {
			return -1;
		}
	}
	
	static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	static int top() {
		if (size > 0) {
			return stack[size-1];
		} else {
			return -1;
		}
	}
	
}