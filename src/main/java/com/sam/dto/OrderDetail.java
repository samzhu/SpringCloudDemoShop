package com.sam.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * Created by samchu on 2016/12/8.
 */
@Data
public class OrderDetail {
    private Long orderDetailID;
    private Long orderID;
    private Long itemID;
    private String itemName;
    private Integer itemPrice;
}
