package ȫ����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static char[] array;
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		array = scanner.next().toCharArray();
		visited = new boolean[array.length];
		gen(0, "");
		Collections.sort(list);
		for (String s1 : list)
			System.out.println(s1);
		// ע����ĿҪ��ÿ���������������Ҫ�����һ���س���
		System.out.println();
	}

	static void gen(int step, String cur) {
		// �ݹ���ֹ
		if (step == array.length) {
			list.add(cur);
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				gen(step + 1, cur + array[i]);
				// ���ݣ�����ֳ�
				visited[i] = false;
			}
		}

	}
}