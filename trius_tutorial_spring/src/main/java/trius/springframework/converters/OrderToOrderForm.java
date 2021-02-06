package trius.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trius.springframework.commands.OrderForm;
import trius.springframework.domain.Order;
import java.time.LocalTime;

@Component
public class OrderToOrderForm implements Converter<Order,OrderForm> {

    @Override
    public OrderForm convert(Order order) {
        OrderForm orderForm=new OrderForm();
        orderForm.setId(order.getId().toHexString());
        orderForm.setName(order.getName());
        orderForm.setPrice(order.getPrice());
        orderForm.setQuantity(order.getQuantity());
        orderForm.setOrderDate(order.getOrderDate());

        return orderForm;
    }
}
