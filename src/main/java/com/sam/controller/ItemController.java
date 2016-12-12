package com.sam.controller;

import com.sam.dto.Item;
import com.sam.reader.ItemReader;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by samchu on 2016/12/8.
 */
@Api(tags = "Item")
@RestController
@RequestMapping(value = "api")
public class ItemController {
    @Autowired
    private ItemReader itemReader;

    @ApiOperation(value = "取得商品", notes = "商品List", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "bearer+空格+access_token", required = false, dataType = "string", paramType = "header")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品分頁清單")})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "v1/item", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PagedResources<Resource<Item>> getItem() {
        return itemReader.getAll();
    }

}
