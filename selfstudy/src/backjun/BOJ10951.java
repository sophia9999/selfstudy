package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
	/**
	 * 이 문제를 어떻게 풀 것인지 문제를 아무리 읽어봐도, 출력의 마지막에 대해 알 수 있는 것이 없었다.
	 * 문제를 제목에 대한 설명을 보니 EOF에 대해 알아 보세요. 라고 되어있었다.
	 * EOF란?
	 * End Of File 을 뜻 하는 것이었고,
	 * 입력이 끝날 때 까지 모든 입력을 받아야 하므로 Scanner 클래스보다 읽는 데 유리한
	 * BufferedReader 를 사용했다.
	 * 다음입력값이 null 이면 읽을 값들이 끝났다는 것이므로 while 안에 line != null 을 이용했다.
	 * 콘솔 창을 통해 테스트 시, 
	 * 입력의 끝을 나타내려면 ctrl + z 를 통해 가능하다.
	 */
class BOJ10951 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		while(line != null) {
			
			int a = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			int b = Integer.parseInt(line.substring(line.indexOf(" ")+1));

			bw.write(Integer.toString(a+b));
			bw.newLine();
			
			line = br.readLine();
		}
		bw.flush();
	}
}
