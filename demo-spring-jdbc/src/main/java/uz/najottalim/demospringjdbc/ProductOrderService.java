package uz.najottalim.demospringjdbc;

import uz.najottalim.demospringjdbc.dao.ProductOrder;

import java.util.List;

public interface ProductOrderService {

    List<ProductOrder> getProductOrderByStatus(String statusName);

    List<ProductOrder> getOrdersLastNDay(Integer n);
}