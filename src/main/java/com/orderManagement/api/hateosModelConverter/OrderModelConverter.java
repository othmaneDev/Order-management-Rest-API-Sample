package com.orderManagement.api.hateosModelConverter;

import com.orderManagement.api.controller.OrderController;
import com.orderManagement.api.model.Order;
import com.orderManagement.api.model.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelConverter implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {

        // Unconditional links to single-item resource and aggregate root
        EntityModel<Order> orderEntityModel = new EntityModel<>(order,
                linkTo(methodOn(OrderController.class).getOneOrderById(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).getAllOrders()).withRel("orders"));

        // Conditional links based on state of the order
        if( Status.IN_PROGRESS == order.getStatus()) {
            orderEntityModel.add(linkTo(methodOn(OrderController.class)
                            .cancelOrder(order.getId())).withRel("cancel"));
            orderEntityModel.add(linkTo(methodOn(OrderController.class)
                    .completeOrder(order.getId())).withRel("complete"));
        }

        return orderEntityModel;
    }

}
