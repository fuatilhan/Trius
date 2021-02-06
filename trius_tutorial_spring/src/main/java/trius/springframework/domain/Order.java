package trius.springframework.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class Order {
    @Id
    @NotNull
    private ObjectId _id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDate orderDate;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) { this._id = _id;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public BigDecimal getPrice() { return price;}

    public void setPrice(BigDecimal price) { this.price = price;}

    public int getQuantity() { return quantity;}

    public void setQuantity(int quantity) { this.quantity = quantity;}


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
