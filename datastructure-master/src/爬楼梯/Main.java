package ��¥��;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			System.out.println(climb_stairs(n));
		}
	}

	private static int climb_stairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climb_stairs(n - 1) + climb_stairs(n - 2);
	}
}
