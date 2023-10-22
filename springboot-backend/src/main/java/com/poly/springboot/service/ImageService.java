package com.poly.springboot.service;

import com.poly.springboot.dto.requestDto.ImageRequestDto;
import com.poly.springboot.dto.responseDto.ImageResponseDto;
import com.poly.springboot.entity.Image;

import java.util.List;

public interface ImageService {

    List<ImageResponseDto> getImages();

    String delete(Long id);

    Image findById(Long id);

    Image save(ImageRequestDto imageRequestDto);

    Image update(ImageRequestDto imageRequestDto ,Long id);
}
