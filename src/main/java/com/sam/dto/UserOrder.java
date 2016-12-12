package com.sam.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by samchu on 2016/12/8.
 */
@Data
public class UserOrder {
    private Long orderid;
    private String mobileNumber;
    private Integer orderAmount;
    private List<OrderDetail> orderDetails;
    private Date createdDate;
}
