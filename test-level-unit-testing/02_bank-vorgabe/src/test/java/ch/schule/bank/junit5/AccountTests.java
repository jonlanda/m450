package ch.schule.bank.junit5;

import ch.schule.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTests {

    @Test
    void testInit() {
        Account account = new TestAccount("123");
        assertNotNull(account);
        assertEquals("123", account.getId());
        assertEquals(0, account.getBalance());
        assertTrue(account.canTransact(0));
    }

    @Test
    void testDeposit() {
        Account account = new TestAccount("456");
        assertTrue(account.deposit(1, 100));
        assertEquals(100, account.getBalance());
        assertFalse(account.deposit(0, -50)); // Negative amount should fail
        assertEquals(100, account.getBalance());
        assertTrue(account.deposit(1, 50)); // Cannot deposit on the same day
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() {
        Account account = new TestAccount("789");
        assertTrue(account.withdraw(1, 50));
        assertEquals(-50, account.getBalance());
        assertFalse(account.withdraw(0, -25)); // Negative amount should fail
        assertEquals(-50, account.getBalance());
        assertTrue(account.withdraw(1, 25)); // Cannot withdraw on the same day
        assertEquals(-75, account.getBalance());
    }

    @Test
    void testReferences() {
        // Your test logic here
    }

    @Test
    void testCanTransact() {
        Account account = new TestAccount("999");
        assertTrue(account.canTransact(0));
        assertTrue(account.deposit(1, 100));
        assertFalse(account.canTransact(0)); // Cannot transact before the first transaction
        assertTrue(account.canTransact(1)); // Can transact on the same day or later
    }

    @Test
    void testPrint() {
        Account account = new TestAccount("321");
        account.deposit(1, 100);
        account.withdraw(2, 50);
        account.print(); // Just check if the print method runs without errors
    }

    @Test
    void testMonthlyPrint() {
        Account account = new TestAccount("654");
        account.deposit(1, 100);
        account.withdraw(31, 50); // Transaction on the next month
        account.print(2023, 1); // Just check if the monthly print method runs without errors
    }

    // Helper class for testing
    private static class TestAccount extends Account {
        public TestAccount(String id) {
            super(id);
        }

        @Override
        public boolean canTransact(int date) {
            return super.canTransact(date);
        }

        @Override
        public boolean deposit(int date, long amount) {
            return super.deposit(date, amount);
        }

        @Override
        public boolean withdraw(int date, long amount) {
            return super.withdraw(date, amount);
        }

        @Override
        public void print() {
            super.print();
        }

        @Override
        public void print(int year, int month) {
            super.print(year, month);
        }
    }
}