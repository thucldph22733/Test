package com.poly.springboot.service.impl;

import com.poly.springboot.dto.requestDto.ImageRequestDto;
import com.poly.springboot.dto.responseDto.ImageResponseDto;
import com.poly.springboot.dto.responseDto.ProductResponseDto;
import com.poly.springboot.entity.Color;
import com.poly.springboot.entity.Image;
import com.poly.springboot.repository.ImageRepository;
import com.poly.springboot.repository.ProductRepository;
import com.poly.springboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    private ProductRepository productRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository,
                            ProductRepository productRepository){
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ImageResponseDto> getImages() {
        return imageRepository.findAll().stream().map(
                image -> {
                    ImageResponseDto imageResponseDto = new ImageResponseDto();
                    imageResponseDto.setId(image.getId());
                    imageResponseDto.setProductName(image.getProduct().getProductName());
                    imageResponseDto.setImageName(image.getImageName());
                    imageResponseDto.setImageDescribe(image.getImageDescribe());
                    return imageResponseDto;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public String delete(Long id) {
        if (imageRepository.existsById(id)){
            imageRepository.deleteById(id);
            return "Delete Success!";
        }
        return "This is was not found!";
    }

    @Override
    public Image findById(Long id) {
        Optional<Image> result = imageRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Image save(ImageRequestDto imageRequestDto) {
        Image image = new Image();
        image.setProduct(productRepository.findById(imageRequestDto.getProductId()).orElse(null));
        image.setImageDescribe(imageRequestDto.getImageDescribe());
        image.setImageName(imageRequestDto.getImageName());
        imageRepository.save(image);
        return image;
    }

    @Override
    public Image update(ImageRequestDto imageRequestDto, Long id) {
        Image image = imageRepository.findById(id).get();

        image.setProduct(productRepository.findById(imageRequestDto.getProductId()).orElse(null));
        image.setImageDescribe(imageRequestDto.getImageDescribe());
        image.setImageName(imageRequestDto.getImageName());
        imageRepository.save(image);
        return image;
    }
}
