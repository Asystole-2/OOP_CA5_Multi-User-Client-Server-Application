package DTOs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    @Test
    void testCustomerDefaultConstructor() {
        Customer customer = new Customer();
        assertNotNull(customer);
        assertNull(customer.getUserName());
        assertNull(customer.getWalletBalance());
        assertEquals(0, customer.getTicketsPurchased());
        assertEquals(0, customer.getCustomer_id());
    }

    @Test
    void testCustomerConstructorWithParameters() {
        Customer customer = new Customer("JohnDoe", 50.0f, 2);
        assertEquals("JohnDoe", customer.getUserName());
        assertEquals(50.0f, customer.getWalletBalance());
        assertEquals(2, customer.getTicketsPurchased());
    }

    @Test
    void testCustomerConstructorWithAllParameters() {
        Customer customer = new Customer(1, "Alice", 100.0f, 5);
        assertEquals(1, customer.getCustomer_id());
        assertEquals("Alice", customer.getUserName());
        assertEquals(100.0f, customer.getWalletBalance());
        assertEquals(5, customer.getTicketsPurchased());
    }

    @Test
    void testSettersAndGetters() {
        Customer customer = new Customer();
        customer.setCustomer_id(200);
        customer.setUserName("Bob");
        customer.setWalletBalance(75.5f);
        customer.setTicketsPurchased(3);

        assertEquals(200, customer.getCustomer_id());
        assertEquals("Bob", customer.getUserName());
        assertEquals(75.5f, customer.getWalletBalance());
        assertEquals(3, customer.getTicketsPurchased());
    }

    @Test
    void testToString() {
        Customer customer = new Customer(3, "Charlie", 120.0f, 7);
        String expected = "Customer{customer_id=3, userName='Charlie', walletBalance=120.0, ticketsPurchased=7}";
        assertEquals(expected, customer.toString());
    }
}

