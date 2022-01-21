package backjun;

import java.util.Scanner;

public class BOJ2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input;
		input = sc.nextInt();
		
		String star = "";
		for(int i = 1 ; i <= input ; i++) {
			String space = "";
			star +="*";
			if(star.length() != input) {
				for(int j = 0; j < (input-star.length()) ; j++) {
					space += " ";
				}
			}
			System.out.println(space + star);
		}
		
		sc.close();
	}
}
