import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 재귀의 귀재
public class Main {
	
	static int countRecursion;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String text = br.readLine();
			
			countRecursion = 0;
			int answer = isPalindrome(text);
			
			bw.write(answer + " " + countRecursion + "\n");
		}
		
		bw.close();
	}
	
	static int recursion(String text, int n, int r) {
		countRecursion++;
		
		if (n >= r) return 1;
		else if (text.charAt(n) != text.charAt(r)) return 0;
		else return recursion(text, n + 1, r - 1);
	}
	
	static int isPalindrome(String text) {
		return recursion(text, 0, text.length() - 1);
	}
}