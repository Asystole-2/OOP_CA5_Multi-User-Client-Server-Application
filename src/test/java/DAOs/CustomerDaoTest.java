package DAOs;

import DTOs.Customer;
import Exceptions.DaoException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {
    CustomerDaoInterface ICustomerDao = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DaoException {
        ICustomerDao = new CustomerDAO();
    }

    @org.junit.jupiter.api.Test
    void getAllCustomers() throws DaoException {
        List<Customer> Customers = ICustomerDao.getAllCustomers();
        assertNotNull(Customers);

        assertNotNull(Customers, "The list of customers should not be null.");
        assertFalse(Customers.isEmpty(), "The list of customers should not be empty.");
        assertEquals(20, Customers.size(), "Expected 20 customers in the list.");

        Customer firstCustomer = Customers.get(0);
        assertEquals(1, firstCustomer.getCustomer_id(), "The ID of the first customer should be 1.");
        assertEquals("user1", firstCustomer.getUserName(), "The name of the first customer should be user1.");
    }
}
