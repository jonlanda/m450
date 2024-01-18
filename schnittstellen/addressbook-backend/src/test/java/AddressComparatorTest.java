import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressComparatorTest {

    private AddressComparator addressComparator;

    @BeforeEach
    void setUp() {
        addressComparator = new AddressComparator();
    }

    @Test
    void testCompare_SameLastNames() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "Alice", "Doe", "67890", null);

        int result = addressComparator.compare(address1, address2);

        assertEquals(9, result);
    }

    @Test
    void testCompare_SameLastNamesAndFirstNames() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "John", "Doe", "67890", null);

        int result = addressComparator.compare(address1, address2);

        assertEquals(-5, result);
    }

    @Test
    void testCompare_DifferentLastNames() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "Alice", "Smith", "67890", null);

        int result = addressComparator.compare(address1, address2);

        assertEquals(-15, result);
    }

    @Test
    void testCompare_DifferentFirstNames() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "Alice", "Doe", "67890", null);

        int result = addressComparator.compare(address1, address2);

        assertEquals(9, result);
    }

    @Test
    void testCompare_SameAttributes() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "John", "Doe", "12345", null);

        int result = addressComparator.compare(address1, address2);

        assertEquals(0, result);
    }

    @Test
    void testSortingAddresses() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "Alice", "Smith", "67890", null);
        Address address3 = new Address(3, "Bob", "Johnson", "55555", null);

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

        Collections.sort(addresses, addressComparator);

        assertEquals(address1, addresses.get(0));
        assertEquals(address2, addresses.get(2));
        assertEquals(address3, addresses.get(1));
    }
}
