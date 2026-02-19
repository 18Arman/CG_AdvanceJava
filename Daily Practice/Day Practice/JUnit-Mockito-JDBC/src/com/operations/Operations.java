package com.operations;

class Operations {
	public int factorial(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return n*factorial(n-1);
	}
	public boolean validateUser(String name,String pwd) {
		return name.equals("arman")&&pwd.equals("123@");
		
	}
}
