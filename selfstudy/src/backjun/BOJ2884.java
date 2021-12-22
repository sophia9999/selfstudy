package backjun;

import java.util.Scanner;

public class BOJ2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, m;
		
		h = sc.nextInt();
		m = sc.nextInt();
		/*
		 * 경우의 수
		 * 
		 * m이 0이면 60 - m 으로 설정 
		 * m이 45보다 크면 m에 45를뺀다. 
		 * m이 45보다 작으면 h = 0 이면 23으로 그 외 양수면 그냥
		 * -1 해주면됨
		 */
		
		if( h == 0 && m == 0) { // 둘다 0일 때
			h = 23;
			m = 15;
			System.out.println(h + " " + m);
		} else if( m == 0) { // m이 0이면
			m = 60 - m;
			System.out.println(h + " " + m);
		} else if( m >= 45) { // m 이 45보다 크거나 같으면
			m = m - 45;
			System.out.println(h + " " + m);
		} else if( m < 45 && h == 0) {
			h = 23;
			int x = 45 - m;
			m = 60 - x;
			System.out.println(h + " " + m);
		} else if( m < 45 && h != 0){
			h = h - 1;
			int x = 45 - m;
			m = 60 - x;
			System.out.println(h + " " + m);
		} 
		
		
		sc.close();
	}
}
