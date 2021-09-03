package com.museum.controller;

import com.museum.domain.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"武侯祠----剩余停车位"})
@RestController
@RequestMapping("/parkingquantity")
@RequiredArgsConstructor
public class ParkingQuantityController {

    @ApiOperation(value = "获取剩余停车位")
    @PostMapping("/getparkingquantity")
    public int getparkingquantity(){

        return 22;
    }
}
