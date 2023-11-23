public class PriceCalculatorTest {

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        boolean allTestsPassed = true;

        // Test Case 1: Base case with no discounts or extras
        allTestsPassed &= test_calculate_price(100.0, 0.0, 0.0, 0, 0.0, 100.0);

        // Test Case 2: Test with special price and discount
        allTestsPassed &= test_calculate_price(100.0, 20.0, 0.0, 0, 20.0, 80.0);

        // Test Case 3: Test with extras, but no discount
        allTestsPassed &= test_calculate_price(100.0, 0.0, 10.0, 4, 0.0, 110.0);

        // Test Case 4: Test with 3 extras and discount
        allTestsPassed &= test_calculate_price(100.0, 0.0, 10.0, 3, 15.0, 97.0);

        // Test Case 5: Test with 5 extras and discount
        allTestsPassed &= test_calculate_price(100.0, 0.0, 10.0, 5, 10.0, 94.0);

        // Test Case 6: Test with extras, special price, and discount
        allTestsPassed &= test_calculate_price(100.0, 15.0, 10.0, 4, 25.0, 107.0);

        // Test Case 7: Test with zero base price and extras
        allTestsPassed &= test_calculate_price(0.0, 0.0, 10.0, 4, 0.0, 10.0);

        // Test Case 8: Test with negative special price
        allTestsPassed &= test_calculate_price(100.0, -20.0, 10.0, 4, 0.0, 90.0);

        // Test Case 9: Test with zero special price and discount
        allTestsPassed &= test_calculate_price(100.0, 0.0, 10.0, 4, 20.0, 90.0);

        // Test Case 10: Test with negative extras
        allTestsPassed &= test_calculate_price(100.0, 0.0, 10.0, -4, 0.0, 110.0);

        // Print overall result
        System.out.println("All tests passed: " + allTestsPassed);
    }

    public static boolean test_calculate_price(double baseprice, double specialprice,
                                               double extraprice, int extras, double discount,
                                               double expectedPrice) {
        double calculatedPrice = calculatePrice(baseprice, specialprice, extraprice, extras, discount);

        if (calculatedPrice == expectedPrice) {
            System.out.println("Test Passed: Base=" + baseprice + ", Special=" + specialprice +
                    ", Extra=" + extraprice + ", Extras=" + extras + ", Discount=" + discount +
                    " => Expected=" + expectedPrice + ", Calculated=" + calculatedPrice);
            return true;
        } else {
            System.out.println("Test Failed: Base=" + baseprice + ", Special=" + specialprice +
                    ", Extra=" + extraprice + ", Extras=" + extras + ", Discount=" + discount +
                    " => Expected=" + expectedPrice + ", Calculated=" + calculatedPrice);
            return false;
        }
    }
}
