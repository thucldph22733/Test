package com.poly.springboot.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoucherOrderRequestDto {
    
    private Long orderId;

    private Long voucherId;
    
}