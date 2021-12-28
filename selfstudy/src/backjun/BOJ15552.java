package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t, a, b, result = 0;
		String s = "";
		try {
			t = Integer.parseInt(br.readLine() );
			for (int i = 0; i < t; i++) {
				s = br.readLine();
				a = Integer.parseInt(s.substring(0, s.indexOf(" ") ) );
				b = Integer.parseInt(s.substring(s.indexOf(" ")+1 ) );
				result = a+b;
				bw.write(Integer.toString(result)+"\n");
			}
			bw.flush();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
