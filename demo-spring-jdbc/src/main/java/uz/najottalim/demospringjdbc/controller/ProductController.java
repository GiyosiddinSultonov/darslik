package uz.najottalim.demospringjdbc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.demospringjdbc.dao.Product;
import uz.najottalim.demospringjdbc.dao.ProductDAO;

import java.time.LocalDate;
import java.util.List;

@RestController

@RequestMapping("/products")
public class ProductController {
    Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/all-count")
    public Integer getAllProductsCount() {
        return productDAO.findAllCount();
    }

    @GetMapping("/name/{id}")
    public String getProductNameById(@PathVariable Integer id) {
        return productDAO.findProductNameById(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productDAO.findProductById(id);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductById(@PathVariable Double price) {
        return productDAO.findProductsByPrice(price);
    }

    @GetMapping("/order/avg/{date}")
    public Double getAvgAtGivenDate(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        log.info("date: {}", date);
        Double ans = productDAO.getOrderAvg(date);
        log.info("getAvgAtGivenDate: {}", ans);
        return ans;
    }
}
