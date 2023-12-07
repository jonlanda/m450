package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the 'Bank' class.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {

    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        Bank bank = Bank.getInstance();
        assertNotNull(bank);

        String savingsAccount = bank.createSavingsAccount();
        String youthSavingsAccount = bank.createPromoYouthSavingsAccount();
        String salaryAccount = bank.createSalaryAccount(-5000);

        assertNotNull(savingsAccount);
        assertNotNull(youthSavingsAccount);
        assertNotNull(salaryAccount);

        assertNotEquals(savingsAccount, youthSavingsAccount);
        assertNotEquals(savingsAccount, salaryAccount);
        assertNotEquals(youthSavingsAccount, salaryAccount);
    }

    /**
     * Test depositing money into an account.
     */
    @Test
    public void testDeposit() {
        Bank bank = Bank.getInstance();
        String savingsAccount = bank.createSavingsAccount();

        assertTrue(bank.deposit(savingsAccount, 1, 100));
        assertEquals(100, bank.getBalance(savingsAccount));
        assertFalse(bank.deposit("invalidAccount", 1, 50)); // Non-existent account should fail
    }

    /**
     * Test withdrawing money from an account.
     */
    @Test
    public void testWithdraw() {
        Bank bank = Bank.getInstance();
        String salaryAccount = bank.createSalaryAccount(-5000);

        assertTrue(bank.withdraw(salaryAccount, 1, 200));
        assertEquals(-200, bank.getBalance(salaryAccount));
        assertFalse(bank.withdraw("invalidAccount", 1, 50)); // Non-existent account should fail
    }

    /**
     * Test printing account statements.
     */
    @Test
    public void testPrint() {
        Bank bank = Bank.getInstance();
        String savingsAccount = bank.createSavingsAccount();
        bank.deposit(savingsAccount, 1, 100);

        // Just check if the print method runs without errors
        bank.print(savingsAccount);
    }

    /**
     * Test printing monthly account statements.
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = Bank.getInstance();
        String salaryAccount = bank.createSalaryAccount(-5000);
        bank.withdraw(salaryAccount, 31, 200);

        // Just check if the monthly print method runs without errors
        bank.print(salaryAccount, 2023, 1);
    }

    /**
     * Test getting the overall balance of the bank.
     */
    @Test
    public void testBalance() {
        Bank bank = Bank.getInstance();
        String savingsAccount = bank.createSavingsAccount();
        String salaryAccount = bank.createSalaryAccount(-5000);

        bank.deposit(savingsAccount, 1, 100);
        bank.withdraw(salaryAccount, 2, 200);

        // Overall balance should be the sum of individual account balances
        assertEquals(-1305, bank.getBalance());
    }

    /**
     * Test printing the top 5 accounts by balance.
     */
    @Test
    public void testTop5() {
        Bank bank = Bank.getInstance();
        String account1 = bank.createSavingsAccount();
        String account2 = bank.createSavingsAccount();
        String account3 = bank.createSalaryAccount(-5000);
        String account4 = bank.createSalaryAccount(-5000);
        String account5 = bank.createPromoYouthSavingsAccount();

        // Deposit some amounts to the accounts
        bank.deposit(account1, 1, 100);
        bank.deposit(account2, 2, 200);
        bank.deposit(account3, 3, 300);
        bank.deposit(account4, 4, 400);
        bank.deposit(account5, 5, 500);

        // Print the top 5 accounts
        bank.printTop5();
    }

    /**
     * Test printing the bottom 5 accounts by balance.
     */
    @Test
    public void testBottom5() {
        Bank bank = Bank.getInstance();
        String account1 = bank.createSavingsAccount();
        String account2 = bank.createSavingsAccount();
        String account3 = bank.createSalaryAccount(-5000);
        String account4 = bank.createSalaryAccount(-5000);
        String account5 = bank.createPromoYouthSavingsAccount();

        // Withdraw some amounts from the accounts
        bank.withdraw(account1, 1, 50);
        bank.withdraw(account2, 2, 100);
        bank.withdraw(account3, 3, 150);
        bank.withdraw(account4, 4, 200);
        bank.withdraw(account5, 5,

                250);

        // Print the bottom 5 accounts
        bank.printBottom5();
    }
}
