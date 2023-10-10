package com.poly.springboot.service;

import com.poly.springboot.dto.requestDto.ShippingMethodRequestDto;
import com.poly.springboot.entity.ShippingMethod;

import java.util.List;

public interface ShippingMethodService {

    List<ShippingMethod> getShippingMethods();

    ShippingMethod saveShippingMethod(ShippingMethodRequestDto methodRequestDto);

    ShippingMethod updateShippingMethod(ShippingMethodRequestDto methodRequestDto,Long id);

    ShippingMethod findShippingMethodById(Long id);

    String deleteShippingMethod(Long id);
}