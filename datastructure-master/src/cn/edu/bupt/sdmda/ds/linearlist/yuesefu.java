package cn.edu.bupt.sdmda.ds.linearlist;

import java.util.Scanner;

public class yuesefu {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int i=0;
		int count=0;
		int num=0;
		int flag[]=new int[n+1];
		flag[0]=0;
		for(i=1;i<=n;i++) {
			flag[i]=1;
		}
		while(count < n - 1) {
	        for(i = 1; i <= n; i++ ) {
	            if (1 == flag[i]) {
	                num++;
	                if(num == m) {
	                    count++;
	                    flag[i] = 0;
	                    num = 0;
	                }
	                if(count == n - 1) {
	                    break;
	                }
	            }
	        }
	    }
		for(i = 1; i <= n; i++) {
	        if(1 == flag[i]) {
	            System.out.println(i);
	        }
	    }
	}

}
