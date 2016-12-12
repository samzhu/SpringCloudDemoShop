package com.sam.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by samchu on 2016/12/8.
 */
@Data
public class Item{
    private Long itemid;
    private String name;
    private Integer price;
    private Date createdDate;
}
