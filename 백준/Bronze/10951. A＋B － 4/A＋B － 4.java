import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		
		while((str = br.readLine()) != null) {
			String[] tokens = str.split(" ");
			int A = Integer.parseInt(tokens[0]);
			int B = Integer.parseInt(tokens[1]);
			bw.write(A + B  +"\n");
		}
		
		bw.close();
		
	}
	
}