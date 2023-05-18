package uz.najottalim.demospringjdbc.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductOrder {
    private Integer id;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
    private Integer customerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    static class ProductOrderRowMapper implements RowMapper<ProductOrder> {

        @Override
        public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductOrder productOrder = new ProductOrder();
            productOrder.id = rs.getInt("id");
            productOrder.orderDate = rs.getDate("order_date");
            productOrder.deliveryDate = rs.getDate("delivery_date");
            productOrder.status = rs.getString("status");
            productOrder.customerId = rs.getInt("customer_id");

            return productOrder;
        }
    }
}
