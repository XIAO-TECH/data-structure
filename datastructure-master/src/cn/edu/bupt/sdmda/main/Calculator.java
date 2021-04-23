package cn.edu.bupt.sdmda.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Calculator {

    // some test case 
    // (2-3*4)-(4*(3*3-1)+3)
    // (2-3*4)-(4*(3*3+(-1))+3)
    // -123/(4-1)+3*(4-86)+98*2
	String exp;
	static ArrayList<Character> ops = new ArrayList<>();

	static HashMap<Character, Integer> prior = new HashMap<>();
	static{
		ops.add('+');
		ops.add('-');
		ops.add('*');
		ops.add('/');
		ops.add('(');
		ops.add(')');

		prior.put('+', 1);
		prior.put('-', 1);
		prior.put('*', 2);
		prior.put('/', 2);
		prior.put('(', 0);
	}

	Stack<Character> opsStack = new Stack<>();
	Stack<Integer> numsStack = new Stack<>();

	StringBuilder numBuilder;

	public Calculator(String str) {
		exp = str;
		numBuilder = new StringBuilder(exp);
	}


	public int calc(){
		int i=0;
		while(i<numBuilder.length()) {
			if (getFlag(i)==1){
				if (numBuilder.charAt(i)=='(') {
					opsStack.push(numBuilder.charAt(i));
				}
				else if (numBuilder.charAt(i)==')') {
					while(opsStack.peek()!='(') {
						popAndCalcAndPush();
					}
					opsStack.pop();
				}
				else {compareAndCalc(i);}
				i++;
			} 
			else {
				StringBuilder num = new StringBuilder();
				num.append(numBuilder.charAt(i));
				if (i==numBuilder.length()-1) {
					numsStack.push(Integer.parseInt(num.toString()));
					i++;
				} else {
					i++;
					while(i!=numBuilder.length()&&getFlag(i)==0) {
						num.append(numBuilder.charAt(i));
						i++;
					}
					numsStack.push(Integer.parseInt(num.toString()));
				}
			}
		}
		while(!opsStack.empty()) {
			popAndCalcAndPush();
		}
		return numsStack.peek();
	}

	// return 0 for number
	// return 1 for operator
	// note the '-' which can be both number or operator
	private int getFlag(int i){
		if(numBuilder.charAt(i)=='-') {
			if(i==0 || numBuilder.charAt(i-1)=='(')
				return 0;
			return 1;
		}
		if(numBuilder.charAt(i)>='0' && numBuilder.charAt(i)<='9')
			return 0;
		return 1;
	}


	// pop two numbers from stack, one operator from stack
	// calculate result and push in stack
	private void popAndCalcAndPush(){
		Integer num_latest=numsStack.pop();
		Integer num_first=numsStack.pop();
		char ops = opsStack.pop();
		switch(ops)
		{
			case '+': 
				numsStack.push(num_first+num_latest);
				break;
			case '-':
				numsStack.push(num_first-num_latest);
				break;
			case '*':
				numsStack.push(num_first*num_latest);
				break;	
			case '/':
				numsStack.push(num_first/num_latest);
				break;
	}

	}
	// compare current operator and top operator in stack
	// if prior[cur]>prior[stack[top]], just push cur to stack
	// else popAndCalculate, then push cur to stack
	// note '(' and ')'
	// '(' always be pushed into stack
	// ')' always popAndCalculate until ')'
	private void compareAndCalc(int i){
		if (opsStack.empty()||prior.get(numBuilder.charAt(i))>prior.get(opsStack.peek())) {
			opsStack.push(numBuilder.charAt(i));
		} else {
			while(prior.get(numBuilder.charAt(i))<=prior.get(opsStack.peek())) {
				popAndCalcAndPush();
			}
			opsStack.push(numBuilder.charAt(i));
		}
	}
}
