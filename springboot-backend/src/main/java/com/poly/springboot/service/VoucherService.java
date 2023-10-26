package com.poly.springboot.service;

import com.poly.springboot.dto.requestDto.VoucherRequestDto;
import com.poly.springboot.dto.responseDto.VoucherResponseDto;
import com.poly.springboot.entity.Voucher;

import java.util.List;

public interface VoucherService {
    List<VoucherResponseDto> getVouchers();

    Voucher saveVoucher(VoucherRequestDto requestDto);

    Voucher updateVoucher(VoucherRequestDto requestDto, Long id);

    String deleteVoucher(Long id);

    Voucher findVoucherById(Long id);

}