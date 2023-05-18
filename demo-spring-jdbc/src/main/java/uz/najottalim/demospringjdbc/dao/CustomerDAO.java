package uz.najottalim.demospringjdbc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDAO {
    private final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, new Customer.CustomerRowMapper());
    }

    public Customer findById(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new Customer.CustomerRowMapper(),id);
    }
}
