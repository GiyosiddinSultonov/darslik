package uz.najottalim.demospringjdbc;

import uz.najottalim.demospringjdbc.dao.Customer;
import uz.najottalim.demospringjdbc.dao.ProductOrder;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    List<ProductOrder> getAllProductOrderById(Integer id);
}
