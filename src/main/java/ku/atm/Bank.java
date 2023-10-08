        // Sittipong Hemloun 6410401183
package ku.atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {
   private String name;
   private Map<Integer, Customer> customers;

   public Bank(String name) {
      this.name = name;
      this.customers = new HashMap<>();
   }

   public void openAccount(Customer c) {
      customers.put(c.getId(), c);
   }

   public Customer getCustomer(int id) {
      return customers.get(id);
   }

   public Customer matchCustomer(int id, int pin) {
      Customer customer = customers.get(id);
      if (customer != null && customer.match(pin))
         return customer;
      return null;
   }

   public void transfer(int givingId, int receiverId, double amount) throws NotEnoughBalanceException {
      customers.get(givingId).getAccount().withdraw(amount);
      customers.get(receiverId).getAccount().deposit(amount);
   }
}


