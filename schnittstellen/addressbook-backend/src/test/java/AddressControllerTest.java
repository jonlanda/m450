import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressControllerTest {

    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        addressController = new AddressController(addressService);
    }

    @Test
    public void testCreateAddress() {
        Address newAddress = new Address();
        when(addressService.save(newAddress)).thenReturn(newAddress);

        ResponseEntity<Address> response = addressController.createAddress(newAddress);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newAddress, response.getBody());
    }

    @Test
    public void testGetAddresses() {
        List<Address> addressList = new ArrayList<>();
        when(addressService.getAll()).thenReturn(addressList);

        ResponseEntity<List<Address>> response = addressController.getAddresses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(addressList, response.getBody());
    }

    @Test
    public void testGetAddress_Existing() {
        int addressId = 1;
        Address existingAddress = new Address();
        when(addressService.getAddress(addressId)).thenReturn(Optional.of(existingAddress));

        ResponseEntity<Address> response = addressController.getAddress(addressId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(existingAddress, response.getBody());
    }

    @Test
    public void testGetAddress_NotFound() {
        int addressId = 1;
        when(addressService.getAddress(addressId)).thenReturn(Optional.empty());

        ResponseEntity<Address> response = addressController.getAddress(addressId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
