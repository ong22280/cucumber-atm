        // Sittipong Hemloun 6410401183
package ku.atm;

public class NotEnoughBalanceException extends Exception {
    public NotEnoughBalanceException() {}
    public NotEnoughBalanceException(String reason) {
        super(reason);
    }
}
