package uz.najottalim.demospringjdbc.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private int tier;
  static   class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setTier(rs.getInt("tier"));
            return customer;
        }
    }
    // nuasfkljafnaldfnafilg

}