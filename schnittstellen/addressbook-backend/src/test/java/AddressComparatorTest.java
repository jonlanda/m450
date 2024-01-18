import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressComparatorTest {

    @Test
    public void testCompare_Alphabetical() {
        Address address1 = new Address(1, "Alice", "Doe", "12345", null);
        Address address2 = new Address(2, "John", "Smith", "67890", null);
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(address1, address2);

        assertEquals(-1, result);
    }

    @Test
    public void testCompare_AlphabeticalReverse() {
        Address address1 = new Address(1, "Alice", "Doe", "12345", null);
        Address address2 = new Address(2, "John", "Smith", "67890", null);
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(address2, address1);

        assertEquals(-1, result);
    }

    @Test
    public void testCompare_SameName() {
        Address address1 = new Address(1, "John", "Doe", "12345", null);
        Address address2 = new Address(2, "John", "Smith", "67890", null);
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(address1, address2);

        assertEquals(-1, result);
    }
}
