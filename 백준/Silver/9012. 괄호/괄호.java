import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 괄호
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		out : for (int t = 0; t < N; t++) {
			Stack<Character> stack = new Stack<Character>();
			String line = br.readLine();
			
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '(') {
					stack.add(line.charAt(i));
				} else {
					if (stack.isEmpty()) {
						bw.write("NO" + "\n");
						continue out;
					} else {
						stack.pop();						
					}
				}
			}
			
			if (stack.isEmpty()) {
				bw.write("YES" + "\n");
			} else {
				bw.write("NO" + "\n");
			}
		}
		
		bw.close();
	}
	
}