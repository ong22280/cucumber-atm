        // Sittipong Hemloun 6410401183
package ku.atm;

public class Customer {
   private int id;
   private int pin;
   private BankAccount account;

   public Customer(int id, int pin, double balance) {
      this.id = id;
      this.pin = pin;
      this.account = new BankAccount(balance);
   }

   public Customer(int id, int pin) {
      this(id, pin, 0);
   }

   public boolean match(int aPin) {
      return pin == aPin;
   }

   public int getId() {
      return id;
   }

   public BankAccount getAccount() {
      return account;
   }
}
