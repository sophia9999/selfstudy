package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
	/**
	 * �� ������ ��� Ǯ ������ ������ �ƹ��� �о����, ����� �������� ���� �� �� �ִ� ���� ������.
	 * ������ ���� ���� ������ ���� EOF�� ���� �˾� ������. ��� �Ǿ��־���.
	 * EOF��?
	 * End Of File �� �� �ϴ� ���̾���,
	 * �Է��� ���� �� ���� ��� �Է��� �޾ƾ� �ϹǷ� Scanner Ŭ�������� �д� �� ������
	 * BufferedReader �� ����ߴ�.
	 * �����Է°��� null �̸� ���� ������ �����ٴ� ���̹Ƿ� while �ȿ� line != null �� �̿��ߴ�.
	 * �ܼ� â�� ���� �׽�Ʈ ��, 
	 * �Է��� ���� ��Ÿ������ ctrl + z �� ���� �����ϴ�.
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