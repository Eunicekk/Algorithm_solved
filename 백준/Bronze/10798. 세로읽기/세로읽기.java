import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 세로읽기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arrStr = new String[5];
		char[][] arr = new char[5][15];
		String str = "";
		
		for (int i = 0; i < 5; i++) {
			arrStr[i] = br.readLine();
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				if (j < arrStr[i].length()) {
					arr[i][j] = arrStr[i].charAt(j);
				} else {
					break;
				}
			}
		}
		
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (j < arrStr[i].length()) {
					str += arr[i][j];
				}
			}
		}
		
		bw.write(str);
		bw.close();
	}
	
}