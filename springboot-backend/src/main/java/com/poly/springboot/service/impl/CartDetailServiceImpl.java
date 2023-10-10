package com.poly.springboot.service.impl;

import com.poly.springboot.dto.requestDto.CartDetailRequestDto;
import com.poly.springboot.dto.responseDto.CartDetailResponseDto;
import com.poly.springboot.entity.Cart;
import com.poly.springboot.entity.CartDetail;
import com.poly.springboot.entity.ProductDetail;
import com.poly.springboot.repository.CartDetailRepository;
import com.poly.springboot.repository.CartRepository;
import com.poly.springboot.repository.ProductDetailRepository;
import com.poly.springboot.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService {

    private CartDetailRepository cartDetailRepository;

    private ProductDetailRepository productDetailRepository;

    private CartRepository cartRepository;

    @Autowired
    public CartDetailServiceImpl(CartDetailRepository cartDetailRepository,
                                 ProductDetailRepository productDetailRepository,
                                 CartRepository cartRepository) {
        this.cartDetailRepository = cartDetailRepository;
        this.productDetailRepository = productDetailRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartDetailResponseDto> getCartDetails() {
        return cartDetailRepository.getCartDetails();
    }

    @Override
    public CartDetail saveCartDetail(CartDetailRequestDto cartDetailRequestDto) {
        //find product detail by id
        ProductDetail productDetail = productDetailRepository.findById(cartDetailRequestDto.getProductDetailId()).orElse(null);
        // find cart by id
        Cart cart = cartRepository.findById(cartDetailRequestDto.getCartId()).orElse(null);

        CartDetail cartDetail = new CartDetail();
        cartDetail.setProductDetail(productDetail);
        cartDetail.setCart(cart);
        cartDetail.setQuantity(cartDetailRequestDto.getQuantity());

        cartDetailRepository.save(cartDetail);

        return cartDetail;
    }

    @Override
    public CartDetail updateCartDetail(CartDetailRequestDto cartDetailRequestDto, Long id) {
        //find product detail by id
        ProductDetail productDetail = productDetailRepository.findById(cartDetailRequestDto.getProductDetailId()).orElse(null);
        // find cart by id
        Cart cart = cartRepository.findById(cartDetailRequestDto.getCartId()).orElse(null);
        // find cartDetail by id
        CartDetail cartDetail = cartDetailRepository.findById(id).get();
        // Neu tim thay thi set cart detail va luu lai
        cartDetail.setProductDetail(productDetail);
        cartDetail.setCart(cart);
        cartDetail.setQuantity(cartDetailRequestDto.getQuantity());

        cartDetailRepository.save(cartDetail);

        return cartDetailRepository.save(cartDetail);
    }

    @Override
    public String deleteCartDetail(Long id) {

        if (cartDetailRepository.existsById(id)){

            cartDetailRepository.deleteById(id);
            return "Delete success!";
        }else {
            return "This id was not found: "+id;
        }

    }
}