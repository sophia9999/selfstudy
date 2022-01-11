package backjun;

import java.util.Scanner;

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
