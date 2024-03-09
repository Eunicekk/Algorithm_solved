import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 크로아티아 알파벳
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// c= c- dz= d- lj nj s= z=
		
		String str = br.readLine();
		int count = 0;
		
		for (int i = 0; i < str.length() - 1; i++) {
			String temp1 = "" + str.charAt(i) + str.charAt(i + 1);
			if (temp1.equals("c=") || temp1.equals("c-") || temp1.equals("d-") || temp1.equals("lj") || temp1.endsWith("nj") || temp1.equals("s=") || temp1.equals("z=")) {
				count++;
			} else if (temp1.equals("dz")) {
				if (i + 1 != str.length() - 1 && str.charAt(i + 2) == '=') {
					count++;
				}
			}
		}
		
		bw.write(String.format("%d", str.length() - count));
		bw.close();
	}

}