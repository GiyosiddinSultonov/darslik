package uz.najottalim.demospringjdbc.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najottalim.demospringjdbc.ProductOrderService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductOrderDAO implements ProductOrderService {
    private final JdbcTemplate jdbcTemplate;



    @Override
    public List<ProductOrder> getProductOrderByStatus(String statusName) {
        LocalDate ad = LocalDate.of(2021,3,30);

        return jdbcTemplate.query(
                "select * from product_order where order_date = ?",
                new ProductOrder.ProductOrderRowMapper(),
                ad
        );
    }

    @Override
    public List<ProductOrder> getOrdersLastNDay(Integer n) {
        Date maxDate = jdbcTemplate.queryForObject(
                "select max(order_date) from product_order",
                Date.class
        );
        return jdbcTemplate.query(
                "select * from product_order " +
                        "where order_date between ? - ? " +
                        "and ? " +
                        "order by order_date desc",
                new ProductOrder.ProductOrderRowMapper(),
                maxDate, n, maxDate
        );
    }
}
