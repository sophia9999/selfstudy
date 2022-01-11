package backjun;

import java.util.Scanner;
/**
 * 메모리 31112KB 시간 436ms 
 * 이게 더 나은 방법 인 것 같다.
 */
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, X;
		
		N = sc.nextInt();
		X = sc.nextInt();
		
		int com;
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N ; i++) {
			com = sc.nextInt();
            if( X > com ) {
                sb.append(com + " ");
            }
		}

		System.out.println(sb.toString());
		
		sc.close();
	}
}
