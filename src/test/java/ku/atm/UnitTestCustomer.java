        // Sittipong Hemloun 6410401183
package ku.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTestCustomer {

    Customer customer;
    int id = 1;
    int pin = 345;
    double balance = 500;

    @BeforeEach
    void init() {
        customer = new Customer(id, pin, balance);
    }

    @Test
    void testMatchPinValid() {
        assertTrue(customer.match(pin));
    }

    @Test
    void testMatchPinInvalid() {
        assertFalse(customer.match(pin+100));
    }
}
