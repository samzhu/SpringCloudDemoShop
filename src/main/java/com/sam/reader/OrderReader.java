package com.sam.reader;

import com.sam.dto.Item;
import com.sam.dto.OrderDetail;
import com.sam.dto.ShopCart;
import com.sam.dto.UserOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by samchu on 2016/12/8.
 */
@FeignClient(name = "order-service")
public interface OrderReader {

    @RequestMapping(method = RequestMethod.POST, value = "/api/order")
    UserOrder create(ShopCart shopCart);

    @RequestMapping(method = RequestMethod.GET, value = "userorder/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Resource<UserOrder> get(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "orderdetail/search/findByOrderID", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Resource<List<OrderDetail>> findByOrderID(@RequestParam("orderID") Long orderID);
}
