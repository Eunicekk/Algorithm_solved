import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 0;
		
		while (N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			if (value > start) {
				for (int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append("+" + "\n");
				}
				
				start = value;
			} else if (stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-" + "\n");
		}
		
		System.out.print(sb);
	}
	
}