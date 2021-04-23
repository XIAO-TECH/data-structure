package cn.edu.bupt.sdmda.main;

import cn.edu.bupt.sdmda.ds.linearlist.SeqStack;

public class NumBaseConvertor {
	
	public final static char[] digits=
		{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};;
	
	
	public static int toDec(String number, int base){
		int res=0, mul=1;
		for(int i=number.length()-1; i>=0; --i) {
			int num=0;
			if(number.charAt(i)>='0' && number.charAt(i)<='9')
				num = number.charAt(i)-'0';
			if(number.charAt(i)>='a' && number.charAt(i)<='f')
				num = (number.charAt(i)-'a') + 10;
			if(number.charAt(i)>='A' && number.charAt(i)<='F')
				num = (number.charAt(i)-'A') + 10;
			res += num * mul;
			mul *= base;
		}
		return res;
	}
	
	public static String Convert(int number, int base){
		if(base>digits.length)
			throw new RuntimeException(String.format(
					"base should not larger than %d, but got %d",
					digits.length, base));
		SeqStack<Object> stack = new SeqStack<Object>();
		int remainder=0;
		String re="";
		while(number>0) {
			remainder = number % base;
			stack.push(digits[remainder]);
			number /= base;
		}
		while(stack.getSize()>0)
			re += stack.pop();
		return re;
	}
	
	
	
	public static String Convert(String number, int srcBase, int desBase) {
		return Convert( toDec(number, srcBase),desBase);
	}
}
