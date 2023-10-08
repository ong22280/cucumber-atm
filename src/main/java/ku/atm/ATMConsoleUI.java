// Sittipong Hemloun 6410401183
package ku.atm;

import java.util.Scanner;

public class ATMConsoleUI {
	public void start() {
		ATM theATM;
        Bank theBank = new Bank("KU Bank");
		theBank.openAccount(new Customer(1, 111, 100));
        theBank.openAccount(new Customer(2, 222, 200));
        theBank.openAccount(new Customer(3, 333, 300));
		theATM = new ATM(theBank);

		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.print("Enter customer id: ");
			int id = in.nextInt();
			System.out.print("Enter PIN: ");
			int pin = in.nextInt();
			theATM.validateCustomer(id, pin);

			String command;
			do {
				System.out.println("Balance=" + theATM.getBalance());
				System.out.print("A=Deposit, B=Withdrawal, C=Transfer, D=Exit: ");
				command = in.next();
				if (command.equalsIgnoreCase("A")) {
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					theATM.deposit(amount);
				} else if (command.equalsIgnoreCase("B")) {
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					try {
						theATM.withdraw(amount);
					} catch (NotEnoughBalanceException e) {
						System.out.print(e.getMessage());
					}
				} else if (command.equalsIgnoreCase("C")) {
					System.out.print("Transfer To: ");
					int transferTo = in.nextInt();
					System.out.print("Amount: ");
					double amount = in.nextDouble();
					try {
						theATM.transfer(transferTo, amount);
					} catch (NotEnoughBalanceException e) {
						System.out.print(e.getMessage());
					}
				}
			} while (!command.equalsIgnoreCase("D"));
		}
	}
}

