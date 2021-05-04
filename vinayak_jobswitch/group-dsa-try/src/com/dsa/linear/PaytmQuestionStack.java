package com.dsa.linear;
import java.util.Stack;

public class PaytmQuestionStack {

	public boolean validatePOP(int push[], int popSequence[]) {

		int j=0;
		Stack<Integer>tempStack = new Stack<>();
		for (int i = 0; i < push.length; i++) {
			tempStack.push(push[i]);
			while(!tempStack.isEmpty() && j<push.length && tempStack.peek() == popSequence[j]) {
				tempStack.pop();
				j++;
			}
		}
		return j==push.length;
	}

	public static void main(String[] args) {
		PaytmQuestionStack paytm = new PaytmQuestionStack();
		int push[] = {1,2,3,4,5};
		int pop[] = {4,5,3,2,1};
		System.out.println(paytm.validatePOP(push, pop));
	}
}
