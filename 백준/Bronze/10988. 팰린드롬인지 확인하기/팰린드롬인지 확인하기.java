import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 팰린드롬인지 확인하기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int count = 0;
		
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
				count++;
			}
		}
		
		if (count == str.length() / 2) {
			bw.write("1");
		} else {
			bw.write("0");
		}
		
		bw.close();
	}
	
}