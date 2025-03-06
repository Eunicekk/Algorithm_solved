import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		int size = 0;
		
		while (true) {
			String line = br.readLine();
			if (line == null) break;
			
			map.put(line, map.getOrDefault(line, 0) + 1);
			size++;
		}

		for (String tree : map.keySet()) {
			double percent = (map.get(tree) * 100.0) / size;
            System.out.println(tree + " " + String.format("%.4f", percent));
		}
	}
	
}
