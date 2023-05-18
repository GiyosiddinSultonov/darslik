package uz.najottalim.demospringjdbc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO {
    private Logger logger = LoggerFactory.getLogger(ProductDAO.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer findAllCount() {
        String sql = "SELECT COUNT(*) FROM PRODUCT";
        Integer product = jdbcTemplate.queryForObject(sql, Integer.class);
        logger.info("Product count {}", product);
        return product;
    }

    public String findProductNameById(Integer id) {
        String sql = "SELECT name from product where id = ?";
        String product = jdbcTemplate.queryForObject(sql, String.class, id);
        logger.info("Product count {}", product);
        return product;
    }

    public Product findProductById(Integer id) {
        String sql = "SELECT * from product where id = ?";
        Product product = jdbcTemplate.queryForObject(sql, new Product.ProductRowMapper(), id);
        logger.info("Product count {}", product);
        return product;
    }

    public List<Product> findProductsByPrice(Double price) {
        String sql = "SELECT * from product where price > ?";
        List<Product> products22 = new ArrayList<>();
        jdbcTemplate.query(sql, (rs -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setCategory(rs.getString("category"));
            products22.add(product);
        }), price);
        logger.info("product: {}", products22);
        List<Product> products = jdbcTemplate.query(sql, rs -> {
            List<Product> answer = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                answer.add(product);
            }
            return answer;
        }, price);
        logger.info("Products: {}", products);
        List<Product> products2 = jdbcTemplate.query(sql, new Product.ProductRowMapper(), price);
        logger.info("Products2 {}", products2);
        return products;
    }

    public Double getOrderAvg(LocalDate date) {
        String sql = "select avg(price) price from (select sum(p.PRICE) price from PRODUCT_ORDER o " +
                "join ORDER_PRODUCT_RELATIONSHIP op on o.ID = op.ORDER_ID " +
                "join PRODUCT p on p.ID = op.PRODUCT_ID " +
                "where o.ORDER_DATE = ? " +
                "group by o.ID)";
        var avg = jdbcTemplate.queryForObject(sql, Double.class, Date.valueOf(date));
        return avg;
    }
    public Double getOrderSum(LocalDate date){   /**   nimadir  */
        String sql = "select sum(PRICE) from (select sum(p.PRICE) price from PRODUCT_ORDER o\n" +
                "join ORDER_PRODUCT_RELATIONSHIP op on o.ID = op.ORDER_ID\n" +
                "join PRODUCT p on p.ID = op.PRODUCT_ID\n" +
                "where o.ORDER_DATE = ?" +
                "group by o.ID)";
        var sum = jdbcTemplate.queryForObject(sql, Double.class, Date.valueOf(date));
        return sum;

    }
}
