package trius.springframework.commands;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderForm {
    private String id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private LocalDate orderDate;

    public String getId() { return id;}

    public void setId(String id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
