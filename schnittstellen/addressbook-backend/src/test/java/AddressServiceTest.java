import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import ch.tbz.m450.service.AddressService;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        addressService = new AddressService(addressRepository);
    }

    @Test
    public void testSaveAddress() {
        Address newAddress = new Address();
        when(addressRepository.save(newAddress)).thenReturn(newAddress);

        Address savedAddress = addressService.save(newAddress);

        assertEquals(newAddress, savedAddress);
    }

    @Test
    public void testGetAllAddresses() {
        List<Address> addressList = new ArrayList<>();

        when(addressRepository.findAll()).thenReturn(addressList);

        List<Address> sortedAddresses = addressService.getAll();

        verify(addressRepository).findAll();

        addressList.sort(Comparator.comparing(Address::getFirstname));

        assertEquals(addressList, sortedAddresses);
    }


    @Test
    public void testGetAddress_Existing() {
        int addressId = 1;
        Address existingAddress = new Address();
        when(addressRepository.findById(addressId)).thenReturn(Optional.of(existingAddress));

        Optional<Address> foundAddress = addressService.getAddress(addressId);

        assertEquals(Optional.of(existingAddress), foundAddress);
    }

    @Test
    public void testGetAddress_NotFound() {
        int addressId = 1;
        when(addressRepository.findById(addressId)).thenReturn(Optional.empty());

        Optional<Address> foundAddress = addressService.getAddress(addressId);

        assertEquals(Optional.empty(), foundAddress);
    }
}
