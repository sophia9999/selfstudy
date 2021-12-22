package backjun;

import java.util.Scanner;

public class BOJ2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, m;
		
		h = sc.nextInt();
		m = sc.nextInt();
		/*
		 * ����� ��
		 * 
		 * m�� 0�̸� 60 - m ���� ���� 
		 * m�� 45���� ũ�� m�� 45������. 
		 * m�� 45���� ������ h = 0 �̸� 23���� �� �� ����� �׳�
		 * -1 ���ָ��
		 */
		
		if( h == 0 && m == 0) { // �Ѵ� 0�� ��
			h = 23;
			m = 15;
			System.out.println(h + " " + m);
		} else if( m == 0) { // m�� 0�̸�
			m = 60 - m;
			System.out.println(h + " " + m);
		} else if( m >= 45) { // m �� 45���� ũ�ų� ������
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
