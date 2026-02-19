package com.practiceQ1;
class BankAccount {
	double balance;
	static long accountCount=100000000000l;
	long accountNumber;
	BankAccount(){
		this.balance=0;
		this.accountNumber=accountCount;
		accountCount++;
	}
	boolean deposit(double amount) {
		if(amount<=0) {
			throw new InvalidAmountException("Invalid Amount, Failed to deposit!");
		}
		balance+=amount;
		return true;
	}
	boolean withdraw(double amount) {
		if(amount<0) {
			throw new InvalidAmountException("Invalid Amount, Failed to withraw!");
		}
		if(amount>balance) {
			System.out.println("Invalid Amount Exception");
			return false;
		}
		else {
			balance+=amount;
			return true;
		}
	}
	
}
