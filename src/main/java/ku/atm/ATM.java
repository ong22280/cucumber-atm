        // Sittipong Hemloun 6410401183
package ku.atm;

public class ATM {
	private Bank bank;
	private Customer currentCustomer;
	private BankAccount currentAccount;

	public ATM(Bank bank) {
		this.bank = bank;
	}

	public boolean validateCustomer(int id, int pin) {
		currentCustomer = bank.matchCustomer(id, pin);
		if (currentCustomer != null) {
			currentAccount = currentCustomer.getAccount();
			return true;
		}
        return false;
	}

	public void withdraw(double value) throws NotEnoughBalanceException {
		if (currentAccount != null)
            currentAccount.withdraw(value);
	}

	public void deposit(double value) {
		if (currentAccount != null)
            currentAccount.deposit(value);
	}

	public double getBalance() {
		if (currentAccount != null)
            return currentAccount.getBalance();
        return -1;
	}

	public void transfer(int receiverId, double amount) throws NotEnoughBalanceException {
		if (currentAccount != null)
            bank.transfer(currentCustomer.getId(), receiverId, amount);
	}

	public void reset() {
		currentCustomer = null;
		currentAccount = null;
	}
}
