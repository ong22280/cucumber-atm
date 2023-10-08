        // Sittipong Hemloun 6410401183
package ku.atm;

public class BankAccount {
   private double balance;

   public BankAccount() {
      balance = 0;
   }

   public BankAccount(double balance) {
      this.balance = balance;
   }
 
   public void deposit(double amount) {
      balance = balance + amount;
   }

   public void withdraw(double amount) throws NotEnoughBalanceException {
       if (amount > balance)
         throw new NotEnoughBalanceException("cannot withdraw more than balance");
       balance = balance - amount;
   }

   public double getBalance() {
      return balance; 
   }

}

