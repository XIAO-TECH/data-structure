package cn.edu.bupt.sdmda.main;

public class BracketsMatch {
	public static boolean match(String input) {
		return match(input, "()");
	}
	
	public static boolean match(String input, String brackets) {
		StringBuilder inpuBuilder = new StringBuilder(input);
		int[] count =new int[(brackets.length()+1)/2];
		for (int i = 0; i < inpuBuilder.length(); i++) {
			int index=brackets.indexOf(inpuBuilder.charAt(i));
			if (index!=-1) {
				int tmp=index/2;
				if (index%2==0) {
					count[tmp]+=1;
				}
				else {
					count[tmp]-=1;
				}
			}	
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i]!=0)
				return false;
		}
		return true;
	}
}
