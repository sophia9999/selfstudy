package backjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, X;
		
		N = sc.nextInt();
		X = sc.nextInt();
		
		List<Integer> suyeol = new ArrayList<Integer>();
		
		for(int i = 0; i < N ; i++) {
			suyeol.add(sc.nextInt());
		}

		String result = "";
		for(int i = 0; i < suyeol.size() ; i++) {
			if(X > suyeol.get(i) ) {
				result += " "+suyeol.get(i);
			}
		}
		
		result = result.substring(1);
		System.out.println(result);
		
		sc.close();
	}
}
