package com.curso.mybank.entidades;

public class Account {
    
	protected Integer id;
    protected double balance;
    
    public Account(double initBalance) {
        balance = initBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amt) {
        balance = balance + amt;
    }
    
    public void withdraw(double amt) throws OverdraftException {
        boolean result = false;  // assume operation failure
        if ( amt <= balance ) {
            balance = balance - amt;
        } else {
            throw new OverdraftException("Insufficient funds", amt - balance);
        }
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}
