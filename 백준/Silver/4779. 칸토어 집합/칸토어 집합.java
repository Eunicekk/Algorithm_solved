import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 칸토어 집합
public class Main {
	
	static StringBuilder answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while ((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			int len = (int) Math.pow(3, N);
			answer = new StringBuilder();
			
			for (int i = 0; i < len; i++) {
				answer.append("-");
			}
			
			cantor(0, len);
			System.out.println(answer);
		}
		
	}
	
	static void cantor(int index, int size) {
		// 기저 조건
		if (size == 1) {
			return;
		}
		
		int newSize = size / 3;
		for (int i = index + newSize; i < index + newSize * 2; i++) {
			answer.setCharAt(i, ' ');
		}
		
		// 재귀 부분
		cantor(index, newSize);
		cantor(index + 2 * newSize, newSize);
	}
	
}