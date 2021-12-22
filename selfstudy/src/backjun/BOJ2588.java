package backjun;

import java.util.Scanner;

class BOJ2588{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		String B = Integer.toString(b);

		int x = Integer.parseInt(B.substring(2));

		System.out.println(a*x);
		
		x = Integer.parseInt(B.substring(1, 2));
		
		System.out.println(a*x);
		
		x = Integer.parseInt(B.substring(0, 1));
		
		System.out.println(a*x);
		
		System.out.println(a*b);
		sc.close();
	}
}