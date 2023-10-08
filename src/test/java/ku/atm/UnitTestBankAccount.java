        // Sittipong Hemloun 6410401183
package ku.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTestBankAccount {

    BankAccount account;
    int initialBalance = 100;

    @BeforeEach
    void init() {
        account = new BankAccount(initialBalance);
    }

    @Test
    void testDeposit() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() throws NotEnoughBalanceException {
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }
    @Test
    @DisplayName("throws NotEnoughBalanceException when withdraw more than balance")
    void testWithdrawMoreThanBalance() {
        assertThrows(NotEnoughBalanceException.class,
                () -> account.withdraw(10000));
        assertEquals(initialBalance, account.getBalance());
    }
}
