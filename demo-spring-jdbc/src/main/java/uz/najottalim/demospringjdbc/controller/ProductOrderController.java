package uz.najottalim.demospringjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.demospringjdbc.ProductOrderService;
import uz.najottalim.demospringjdbc.dao.ProductOrder;

import java.util.List;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/product-order")
public class ProductOrderController {
    @Autowired
    ProductOrderService productOrderService;

    @GetMapping("/status/{statusName}")
    public List<ProductOrder> getProductOrderByStatus(@PathVariable String statusName){
        return productOrderService.getProductOrderByStatus(statusName);
    }

    @GetMapping("/orders/day/{n}")
    public List<ProductOrder> getOrdersLastNDay(@PathVariable Integer n){
        return productOrderService.getOrdersLastNDay(n);
    }
}
