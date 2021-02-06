package trius.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import trius.springframework.commands.OrderForm;
import trius.springframework.converters.OrderToOrderForm;
import trius.springframework.domain.Order;
import trius.springframework.services.OrderService;

import javax.validation.Valid;

@Controller
public class OrderController {
    private OrderService orderService;
    private OrderToOrderForm orderToOrderForm;
    @Autowired
    public void setOrderToOrderForm(OrderToOrderForm orderToOrderForm){
        this.orderToOrderForm=orderToOrderForm;
    }
    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService=orderService;
    }
    @RequestMapping({"order/list" ,"/order"})
    public String listOrders(Model model){
        model.addAttribute("orders",orderService.getAllOrders());
               return "order/list";
    }
    @RequestMapping("/order/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("order", orderService.getById(id));
        return "order/show";
    }
    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Order order = orderService.getById(id);
        OrderForm orderForm = orderToOrderForm.convert(order);
        model.addAttribute("orderForm", orderForm);
        return "order/orderform";
    }
    @RequestMapping("/order/new")
    public String newOrder(Model model){
        model.addAttribute("orderForm", new OrderForm());
        return "order/orderform";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveOrUpdateOrder(@Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "order/orderform";
        }

        Order savedOrder = orderService.saveOrUpdateOrderForm(orderForm);

        return "redirect:/order/show/" + savedOrder.getId();
    }

    @RequestMapping("/order/delete/{id}")
    public String delete(@PathVariable String id){
        orderService.delete(id);
        return "redirect:/order/list";
    }


}
