package com.sam.service;

import com.sam.dto.OrderDetail;
import com.sam.dto.ShopCart;
import com.sam.dto.UserOrder;
import com.sam.reader.OrderReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by samchu on 2016/12/8.
 */
@Service
public class OrderService {
    @Autowired
    private OrderReader orderReader;

    public UserOrder create(ShopCart shopCart){
        return orderReader.create(shopCart);
    }

    public Resource<UserOrder> get(Long orderid){
        Resource<List<OrderDetail>> rsListOrderDetail = orderReader.findByOrderID(orderid);
        Resource<UserOrder> rsUserOrder = orderReader.get(orderid);
        UserOrder userOrder = rsUserOrder.getContent();
        userOrder.setOrderDetails(rsListOrderDetail.getContent());
        return rsUserOrder;
    }
}
