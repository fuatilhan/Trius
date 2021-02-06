package trius.springframework.services;
import org.springframework.stereotype.Service;
import trius.springframework.commands.OrderForm;
import trius.springframework.converters.OrderFormToOrder;
import trius.springframework.domain.Order;
import trius.springframework.repositories.OrderRepository;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private OrderFormToOrder orderFormToOrder;

    public OrderServiceImpl(OrderRepository orderRepository, OrderFormToOrder orderFormToOrder) {
        this.orderRepository = orderRepository;
        this.orderFormToOrder = orderFormToOrder;
    }

    @Override
    public List<Order> getAllOrders() {

        return (List<Order>) this.orderRepository.findAll();
    }

    @Override
    public Order getById(String id) {
       return orderRepository.findById(id).get();
    }


    @Override
    public Order saveOrUpdate(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public void delete(String id) { orderRepository.deleteById(id); }

    @Override
    public Order saveOrUpdateOrderForm(OrderForm orderform) {
        Order savedOrder = saveOrUpdate(orderFormToOrder.convert(orderform));
        System.out.println("Saved Order Id: " + savedOrder.getId());
        return savedOrder;
    }
}
