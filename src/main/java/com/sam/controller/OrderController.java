package com.sam.controller;

import com.sam.dto.Item;
import com.sam.dto.ShopCart;
import com.sam.dto.UserOrder;
import com.sam.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by samchu on 2016/12/8.
 */
@Api(tags = "Order")
@RestController
@RequestMapping(value = "api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "購物車結帳", notes = "結帳", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "bearer+空格+access_token", required = false, dataType = "string", paramType = "header")
    })
    @ApiResponses(value = {@ApiResponse(code = 201, message = "訂單建立成功")})
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "v1/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserOrder createOrder(
            @ApiParam(required = true, value = "購物車")
            @Valid @RequestBody ShopCart shopCart) {
        return orderService.create(shopCart);
    }

    @ApiOperation(value = "取得商品", notes = "商品List", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "bearer+空格+access_token", required = false, dataType = "string", paramType = "header")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品分頁清單")})
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "order/{orderid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Resource<UserOrder> getItem(
            @ApiParam(required = true, name = "orderid", value = "ID") @PathVariable Long orderid) {
        return orderService.get(orderid);
    }
}
