import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 제로
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		
		for (int k = 0; k < K; k++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				stack.pop();
			} else {
				stack.add(num);
			}
		}
		
		while (!stack.empty()) {
			sum += stack.pop();
		}
		
		bw.write(sum + "");
		bw.close();
	}
	
}